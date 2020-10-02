package com.bdd.helper;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	 public static Properties prop = null;
	 public static WebDriver driver;
	 
	 static {
		 try {
			 prop = new Properties(); 
			 prop.load(Driver.class.getClassLoader().getResourceAsStream("application.properties"));
			 WebDriverManager.chromedriver().setup();
			 WebDriverManager.chromedriver().setup();
			
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
		}}
		 
		 public static WebDriver startDriver() {
		 
			 switch(prop.getProperty("browser"))
			 {
			 case "chrome":
				 driver = new ChromeDriver();
				 break;
			 case "firefox":
		     driver = new FirefoxDriver();
			 break;
			 
			 default:
			  driver = new ChromeDriver();
			  break;
			 }
			 
			 return driver;
		 }
		 
		 
		 
		 public static String getProperty(String key) {
			 return prop == null ? null: prop.getProperty(key,"");
		 }
	 

}
