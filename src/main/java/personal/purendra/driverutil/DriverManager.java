package personal.purendra.driverutil;

import org.openqa.selenium.WebDriver;

public class DriverManager {

  private DriverManager() {}

  private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();


  public static WebDriver getWebDriver() {
    return threadLocal.get();
  }

  public static void setWebDriver(WebDriver driver) {
    threadLocal.set(driver);
  }

  public static void unload() {
    threadLocal.remove();
  }
}
