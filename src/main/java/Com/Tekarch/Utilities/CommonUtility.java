package Com.Tekarch.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class CommonUtility {

	public void LoadPropertyFile() throws Exception {
		String sPath = System.getProperty("user.dir") + "\\src\\resources\\Login_TC.properties";
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(sPath);
		prop.load(fi);
		System.getProperties().putAll(prop);
	}

	public void LoadLog4jPropertyFile() throws Exception {
		String sFile = System.getProperty("user.dir") + "\\Properties\\log4j.properties";
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(sFile);
		prop.load(file);
		System.getProperties().putAll(prop);
		PropertyConfigurator.configure(prop);
	}

}