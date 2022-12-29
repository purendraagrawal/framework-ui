package personal.purendra.webtestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import personal.purendra.driverutil.Driver;

public class BaseTest {

  @BeforeMethod
  public void setUp() {
    Driver.initDriver();
  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }
}
