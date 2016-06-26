package com.admin.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {
	// 属性文件的路径
	private static String profilepath = "system.properties";
	
	private static Properties props = new Properties();
	/**
	 * 静态代码块，系统启动时对system.properties文件进行加载
	 */
	static {
		try {
			// 获取classpath路径
			String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			profilepath = classPath.concat(profilepath);
			props.load(new FileInputStream(profilepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
	}

	/**
	 * 读取属性文件中相应键的值
	 * 
	 * @param key
	 *            主键
	 * @return String
	 */
	public static String getValue(String key) {
		return props.getProperty(key);
	}
}
