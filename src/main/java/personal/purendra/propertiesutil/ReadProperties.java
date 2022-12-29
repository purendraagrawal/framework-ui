package personal.purendra.propertiesutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

  private Properties prop;

  private ReadProperties() {
    prop = new Properties();
    try {
      prop.load(new FileInputStream(new File("src/test/resources/data.properties")));
    } catch (IOException e) {
      e.printStackTrace();
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
