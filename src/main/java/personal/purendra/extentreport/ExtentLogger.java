package personal.purendra.extentreport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import personal.purendra.driverutil.DriverManager;

public final class ExtentLogger {

  private ExtentLogger() {}

  public static void onPass(String message) {
    ExtentManager.getExttest().pass(message);
  }

  public static void onFail(String message) {
    ExtentManager.getExttest().fail(message);
  }

  public static void onSkip(String message) {
    ExtentManager.getExttest().skip(message);
  }

  public static void onPass(String message, boolean isScreenshot) {
    if (isScreenshot)
      ExtentManager.getExttest().pass(message,
          MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
    else
      onPass(message);
  }

  public static void onFail(String message, boolean isScreenshot) {
    if (isScreenshot)
      ExtentManager.getExttest().fail(message,
          MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
    else
      onFail(message);
  }

  public static void onSkip(String message, boolean isScreenshot) {
    if (isScreenshot)
      ExtentManager.getExttest().skip(message,
          MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
    else
      onSkip(message);
  }

  private static String takeScreenshot() {
    return ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BASE64);
  }
}
