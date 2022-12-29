package personal.purendra.extentreport;

import java.util.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

  private ExtentReporter() {}

  private static ExtentReports extent = null;

  public static void initReport() {
    if (Objects.isNull(extent)) {
      extent = new ExtentReports();
      ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
      extent.attachReporter(spark);
    }
  }

  public static void createTest(String testName) {
    ExtentManager.setExtTest(extent.createTest(testName));
  }

  public static void flushReport() {
    if (Objects.nonNull(extent)) {
      extent.flush();
      ExtentManager.unload();
    }
  }

}
