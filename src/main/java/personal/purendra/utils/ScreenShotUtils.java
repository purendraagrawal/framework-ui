package personal.purendra.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import personal.purendra.driverutil.DriverManager;

public final class ScreenShotUtils {

  private ScreenShotUtils() {}

  public static String takeScreenshot() {
    return ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BASE64);
  }

}
