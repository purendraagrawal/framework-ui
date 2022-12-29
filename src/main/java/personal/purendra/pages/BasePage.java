package personal.purendra.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import personal.purendra.driverutil.DriverManager;
import personal.purendra.enums.LocatorTypeEnum;
import personal.purendra.extentreport.ExtentLogger;

public class BasePage {

  protected By elementIdentification(LocatorTypeEnum locatorType, String locatorValue) {
    switch (locatorType) {
      case XPATH:
        return By.xpath(locatorValue);
      case CSS:
        return By.cssSelector(locatorValue);
      case ID:
        return By.id(locatorValue);
      case CLASS_NAME:
        return By.className(locatorValue);
      case LINK:
        return By.linkText(locatorValue);
      case PARTIAL_LINK:
        return By.partialLinkText(locatorValue);
      case TAG_NAME:
        return By.tagName(locatorValue);
      case NAME:
        return By.name(locatorValue);
    }
    return null;
  }

  private WebDriver getWebDriver() {
    return DriverManager.getWebDriver();
  }

  private WebElement getFindElement(By element) {
    new WebDriverWait(getWebDriver(), Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(element));
    return getWebDriver().findElement(element);
  }

  protected void sendKeys(By element, String value, String name) {
    getFindElement(element).sendKeys(value);
    ExtentLogger.onPass(value + " entered successfully in " + name);
  }

  protected void clickBtn(By element, String name) {
    getFindElement(element).click();
    ExtentLogger.onPass(name + " clicked successfully");
  }
}
