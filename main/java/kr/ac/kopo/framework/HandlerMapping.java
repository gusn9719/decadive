package kr.ac.kopo.framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String, Controller> mappings = new HashMap<>();
	
	public HandlerMapping() {
		
		Properties prop = new Properties();
		try {
			InputStream is = new FileInputStream("D:\\Lecture\\decadive\\My-WEB-MVC\\bean.properties");	
			prop.load(is);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
				
				Class<?> clz = Class.forName(className);
				Constructor<?> constructor = clz.getConstructor();
				Controller controller = (Controller)constructor.newInstance();
				
				mappings.put(key.toString(), controller);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Controller getController(String uri) {
		
		return mappings.get(uri);
	}
	

}











