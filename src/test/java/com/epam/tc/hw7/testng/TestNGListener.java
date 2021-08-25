package com.epam.tc.hw7.testng;

import com.epam.jdi.tools.Safe;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.last;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {
    private Safe<Long> start = new Safe<>(0L);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ITestNGMethod testMethod = method.getTestMethod();
            if (testMethod.getConstructorOrMethod().getMethod().isAnnotationPresent(Test.class)) {
                TEST_NAME.set( last(testMethod.getTestClass().getName().split("\\.")) +
                        "." + testMethod.getMethodName());
                start.set(currentTimeMillis());
                logger.step("== Test '%s' START ==", TEST_NAME.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String result = getTestResult(testResult);
            logger.step("=== Test '%s' %s [%s] ===", TEST_NAME.get(), result,
                    new SimpleDateFormat("mm:ss.SS")
                            .format(new Date(currentTimeMillis() - start.get())));
            if ("FAILED".equals(result)) {
                try {
                    takeScreen();
                } catch (RuntimeException ignored) { }
                if (testResult.getThrowable() != null) {
                    logger.step("ERROR: " + testResult.getThrowable().getMessage());
                } else {
                    logger.step("UNKNOWN ERROR");
                }
            }
        }
    }

    private String getTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "FAILED";
        }
    }
}
