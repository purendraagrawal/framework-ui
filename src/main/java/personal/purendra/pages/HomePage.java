package personal.purendra.pages;

import personal.purendra.enums.LocatorTypeEnum;

public class HomePage extends BasePage {

  private void clickOnProfilePicture() {
    clickBtn(
        elementIdentification(LocatorTypeEnum.XPATH, "//span[@class='oxd-userdropdown-tab']/i"),"Profile Picture");
  }

  public LoginPage clickOnLogoutLink() {
    clickOnProfilePicture();
    clickBtn(elementIdentification(LocatorTypeEnum.XPATH, "//a[text()='Logout']"),"Log out Link");
    return new LoginPage();
  }

}
