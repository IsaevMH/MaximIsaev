package com.epam.tc.hw6.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.InputStream;
import java.util.List;

public class AttachmentUtil {

    public static void attachFromInputStream(final String name, final InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

    @Attachment
    public static String makeStringAttachment(final List<String> attachmentStrings) {
        return attachmentStrings.toString();
    }

    @Attachment(type = "image/png")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
