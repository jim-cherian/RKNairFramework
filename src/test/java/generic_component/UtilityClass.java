package generic_component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class UtilityClass {
	
	public static String get_properties_file(String key) throws Exception
	{	
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration_file.properties");
		
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);		
	}

}
