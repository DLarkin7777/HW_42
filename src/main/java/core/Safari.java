package core;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari {
	static Properties p = new Properties();
	static Writer report;
	static String ls = System.getProperty("line.separator");
	
	static WebDriver driver = new SafariDriver();;
		
		public static boolean isElementPresent(By by) {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     if (!driver.findElements(by).isEmpty()) return true; else return false;}
		
		public static String getSize(By by) {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x"); 
	else return "null";}
		public static String getLocation(By by) {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x"); 
	else return "null";}
		public static void setValue(By by, String value) {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
		     	  driver.findElement(by).sendKeys(p.getProperty(value));}
		
		public static String getValue(By by) {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
		    	 return driver.findElement(by).getText(); else return "null";}
		
		public static void main(String[] args) throws Exception {
			Logger.getLogger("").setLevel(Level.OFF);
			p.load(new FileInputStream("./input.properties"));
			report = new FileWriter("./report_02.csv",false);
			driver.manage().window().maximize();
			driver.get(p.getProperty("url"));
	// HEADER
			System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
	report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);
	// 01 :: First Name	
			report.write("01,Safari,index.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
			
			System.out.print("01,Safari,index.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");

			setValue(By.id(p.getProperty("id_fname")),"fname_value");
	// 02 :: FLast Name
			report.write("02,Safari,index.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			System.out.print("02,Safari,index.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			setValue(By.id(p.getProperty("id_lname")),"lname_value");
	// 03 :: Email
			report.write("03,Safari,index.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			
			System.out.print("03,Safari,index.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			setValue(By.id(p.getProperty("id_email")),"email_value");
	// 04	:: Phone
			report.write("04,Safari,index.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			
			System.out.print("04,Safari,index.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			
			setValue(By.id(p.getProperty("id_phone")),"phone_value");
	// SUBMIT		
		driver.findElement(By.id(p.getProperty("id_submit_button"))).submit(); 
	// Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.titleIs("Confirmation"));
	// 05 :: First Name
			report.write("05,Safari,confirmation.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
			
			System.out.print("05,Safari,confirmation.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
	// 06 :: Last Name
			report.write("06,Safari,confirmation.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			System.out.print("06,Safari,confirmation.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
	// 07 :: Email
			report.write("07,Safari,confirmation.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			
			System.out.print("07,Safari,confirmation.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");		
	// 08 :: Phone
			report.write("08,Safari,confirmation.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			
			System.out.print("08,Safari,confirmation.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			report.flush(); report.close(); driver.quit();
		}
	}

