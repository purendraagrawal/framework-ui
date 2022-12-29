package personal.purendra.pages;

import personal.purendra.enums.LocatorTypeEnum;

public final class LoginPage extends BasePage {

  public LoginPage enterUserName(String username) {
    sendKeys(elementIdentification(LocatorTypeEnum.NAME, "username"), username, "Username");
    return this;
  }

  public LoginPage enterPassword(String password) {
    sendKeys(elementIdentification(LocatorTypeEnum.NAME, "password"), password, "Password");
    return this;
  }

  public HomePage clickLogin() {
    clickBtn(elementIdentification(LocatorTypeEnum.XPATH, "//button[@type='submit']"),
        "Login Button");
    return new HomePage();
  }
}
