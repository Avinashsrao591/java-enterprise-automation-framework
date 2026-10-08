package framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot(
            WebDriver driver,
            String testName) {

        if (driver == null) {
            return;
        }

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        File destination =
                new File(
                        "target/screenshots/"
                                + testName
                                + "_"
                                + timestamp
                                + ".png"
                );

        try {

            destination
                    .getParentFile()
                    .mkdirs();

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: "
                            + destination.getAbsolutePath()
            );

        } catch (IOException e) {

            System.out.println(
                    "Unable to save screenshot: "
                            + e.getMessage()
            );
        }
    }
}