package personal.purendra.driverutil;

import org.openqa.selenium.chrome.ChromeDriver;
import personal.purendra.propertiesutil.ReadProperties;

public final class Driver {

  private Driver() {}

  public static void initDriver() {
    if (DriverManager.getWebDriver() == null) {
      DriverManager.setWebDriver(new ChromeDriver());
      DriverManager.getWebDriver().manage().window().maximize();
      DriverManager.getWebDriver()
          .get(ReadProperties.getInstance().readDataFromPropertiesFile("url"));
    }
  }

  public static void quitDriver() {
    if (DriverManager.getWebDriver() != null) {
      DriverManager.getWebDriver().quit();
    }
  }
}
