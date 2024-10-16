package webui.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formattedDateTime = dateTime.format(formatter);

        String screenshotDestination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + formattedDateTime+ ".png";
        File destination = new File(screenshotDestination);

        try {
            FileHandler.copy(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*****************************************************************************************
        try {
             Capture entire screen using Robot class
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            // Save the screenshot to the specified destination
            ImageIO.write(screenFullImage, "png", destination);

        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }***************************************************************************************/

            return screenshotDestination;
    }
}
