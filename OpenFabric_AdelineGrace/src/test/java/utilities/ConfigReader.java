package utilities;


	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


	public class ConfigReader {

		  static Properties properties =new Properties();

		public static Properties init_prop() throws IOException
		{	
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/config.properties");

		 
			properties.load(ip);
			
			
			return properties;
		}
		
		public static String getProperty( String key) {
			return properties.getProperty(key);
		}

		
		public static String getWebUrl() throws IOException
		   {
			   return init_prop().getProperty("weburl");
		   }
		
		
		
	}