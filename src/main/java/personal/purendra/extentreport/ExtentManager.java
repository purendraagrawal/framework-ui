package personal.purendra.extentreport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

  private ExtentManager() {}

  private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

  static ExtentTest getExttest() {
    return extTest.get();
  }

  static void setExtTest(ExtentTest test) {
    extTest.set(test);
  }

  static void unload() {
    extTest.remove();
  }
}
