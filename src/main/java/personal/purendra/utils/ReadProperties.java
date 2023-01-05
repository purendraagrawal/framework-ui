package personal.purendra.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import personal.purendra.exceptions.FrameworkException;

public class ReadProperties {

  private Properties prop;

  private ReadProperties() {
    prop = new Properties();
    try (FileInputStream fileInput =
        new FileInputStream(new File("src/test/resources/data1.properties"))) {
      prop.load(fileInput);
    } catch (IOException e) {
      throw new FrameworkException(e.getMessage(),e.getCause());
    }
  }

  private static ReadProperties readProperties;

  public static ReadProperties getInstance() {
    if (readProperties == null) {
      readProperties = new ReadProperties();
    }
    return readProperties;
  }

  public String readDataFromPropertiesFile(String key) {
    return prop.getProperty(key);
  }
}
