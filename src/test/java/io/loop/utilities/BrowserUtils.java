package io.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * takes screenshot
     */
    public static void takeScreenshot(Scenario scenario){
        try{
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        }catch (WebDriverException | ClassCastException wbd){
            wbd.getMessage();
        }
    }
//    public static WebDriver driver;
//    public static WebDriverWait wait;

    // this class is created to store utils for browser

    /**
     * validate if the driver switched to the expected url or title
     * @param driver
     * @param  expectedUrl
     * @param expectedTitle
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        // to lower case the params to avoid case sensitiveness
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one and each ti,e check if the url matches expected to stop
        var windowHandles = driver.getWindowHandles();
        for (var windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String currentWindowHandle = driver.getWindowHandle();
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(currentWindowHandle);
    }

    /**
     * clicks any link from loop practice
     * @param nameOfPage
     * @author Polina
     */

    public static void loopLonkClickMethod(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DocuportConstants.LARGE));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * waits for the provided element to be clickable
     * @param element
     * @param timeout
     * @return element
     * @author Polina
     */

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * waits for provided element to be invisible on the page
     * @param element
     * @param timeout
     */

    public static void waitForInvisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * waits for provided element to be clickable
     * @param element
     * @param timeout
     */

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void uploadFileWindows(String filePath) {
        // copy the file path
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        //simulate keyboard paste and enter
        try {
            Robot robot = new Robot();
            robot.delay(1000);

            // press contrl + V and release
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            //press enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void uploadFileMac(String filePath) {
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        try{
            Robot robot = new Robot();
            robot.delay(1000);

            // press ⌘ + Shift + G to open go to finder
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_META);

            // Paste file path (⌘ + V)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            robot.delay(1000);

            // press enter
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(1000);

            // Press Enter again to confirm file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void uploadFileUsingAppleScript(String filePath) throws Exception {
        String script = "tell application \"System Events\"\n"
                + "delay 1\n"
                + "keystroke \"G\" using {command down, shift down}\n"
                + "delay 1\n"
                + "keystroke \"" + filePath + "\"\n"
                + "keystroke return\n"
                + "delay 1\n"
                + "keystroke return\n"
                + "end tell";

        String[] command = { "osascript", "-e", script };
        Runtime.getRuntime().exec(command);
    }

    public static void uploadFileMac2(String filePath) {
        // 1) Ensure absolute POSIX-like path
        String path = new java.io.File(filePath).getAbsolutePath();

        // 2) Put path on clipboard
        StringSelection selection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        try {
            Robot robot = new Robot();
            robot.setAutoWaitForIdle(true);

            // Small helper
            Runnable shortPause = () -> {
                try { Thread.sleep(350); } catch (InterruptedException ignored) {}
            };

            // 3) Give the OS time to open the file chooser (you said it's already open)
            Thread.sleep(700);

            // 4) Click center to ensure the dialog has focus
            java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int cx = screen.width / 2;
            int cy = screen.height / 2;
            robot.mouseMove(cx, cy);
            shortPause.run();
            robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(400);

            // 5) Open "Go to Folder" (⌘ + ⇧ + G)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_META);

            Thread.sleep(500);

            // 6) Try paste (⌘ + V)
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);

            Thread.sleep(250);

            // If paste didn't work (sometimes blocked), type it manually.
            // You can comment this block out if paste works.
            if (!clipboardLikelyWorked()) {
                typeString(robot, path);
            }

            // 7) Hit Enter to close "Go to Folder"
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(500);

            // 8) Hit Enter again to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean clipboardLikelyWorked() {
        // Often you can just return true and rely on paste; keeping hook for debugging.
        return true;
    }

    private static void typeString(Robot robot, String s) {
        for (char c : s.toCharArray()) {
            typeChar(robot, c);
            try { Thread.sleep(8); } catch (InterruptedException ignored) {}
        }
    }

    private static void typeChar(Robot robot, char c) {
        // Basic mapping for common path characters on a US layout
        switch (c) {
            case '/': robot.keyPress(KeyEvent.VK_SLASH); robot.keyRelease(KeyEvent.VK_SLASH); return;
            case '-': robot.keyPress(KeyEvent.VK_MINUS); robot.keyRelease(KeyEvent.VK_MINUS); return;
            case '_': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS); robot.keyRelease(KeyEvent.VK_SHIFT); return;
            case '.': robot.keyPress(KeyEvent.VK_PERIOD); robot.keyRelease(KeyEvent.VK_PERIOD); return;
            case ' ': robot.keyPress(KeyEvent.VK_SPACE); robot.keyRelease(KeyEvent.VK_SPACE); return;
            default:
                boolean upper = Character.isUpperCase(c);
                int code = KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(c));
                if (code == KeyEvent.VK_UNDEFINED) return;
                if (upper) robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(code);
                robot.keyRelease(code);
                if (upper) robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
