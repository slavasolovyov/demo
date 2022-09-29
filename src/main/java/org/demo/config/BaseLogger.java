package org.demo.config;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.openqa.selenium.OutputType;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class BaseLogger implements TestWatcher, TestExecutionListener {

    private final Map<TestIdentifier, String> startTime = new ConcurrentHashMap<>();

    public String currentTime() {
        return new Date().toInstant().atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    @Attachment(value = "Screenshot of failed test", type = "image/png")
    private byte[] makeScreenshotOnFailure() {
        return Selenide.screenshot(OutputType.BYTES);
        // return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
        try {
            if (extensionContext.getExecutionException().isPresent()) {
                makeScreenshotOnFailure();
            }
        } catch (Throwable ex) {
            log.warn("An error occurred when taking a screenshot - " + ex.getMessage());
        }
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (testIdentifier.isTest()) {
            startTime.put(testIdentifier, currentTime());
            log.info("===== Test started: {}", testIdentifier.getDisplayName());
        }
    }
}
