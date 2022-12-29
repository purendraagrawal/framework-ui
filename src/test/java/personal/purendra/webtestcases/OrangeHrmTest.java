package personal.purendra.webtestcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import personal.purendra.pages.HomePage;
import personal.purendra.pages.LoginPage;

public class OrangeHrmTest extends BaseTest {

  @Test(dataProvider = "loginData")
  public void loginValid(String username, String password) {
    LoginPage loginObj = new LoginPage();
    HomePage homepage = loginObj.enterUserName(username).enterPassword(password).clickLogin();
    homepage.clickOnLogoutLink();
  }

  @DataProvider(name = "loginData", parallel = true)
  public Object[][] loginData() {
    return new Object[][] {
        {"Admin", "admin123"},
        {"admin123", "Admin"}
    };
  }
}
