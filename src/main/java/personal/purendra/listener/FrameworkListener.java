package personal.purendra.listener;

import java.util.Arrays;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import personal.purendra.extentreport.ExtentLogger;
import personal.purendra.extentreport.ExtentReporter;

public class FrameworkListener implements ISuiteListener, ITestListener {

  @Override
  public void onStart(ISuite suite) {
    ExtentReporter.initReport();
  }

  @Override
  public void onFinish(ISuite suite) {
    ExtentReporter.flushReport();
  }


  @Override
  public void onTestStart(ITestResult result) {
    ExtentReporter.createTest(result.getMethod().getMethodName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    ExtentLogger.onPass(result.getMethod().getMethodName() + " is Passed");
  }

  @Override
  public void onTestFailure(ITestResult result) {
    ExtentLogger.onFail(result.getMethod().getMethodName() + " is failed", true);
    ExtentLogger.onFail(Arrays.toString(result.getThrowable().getStackTrace()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    ExtentLogger.onSkip(result.getMethod().getMethodName() + " is Skipped");
  }

}
