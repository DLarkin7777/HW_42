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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chrome {
	static Properties p = new Properties();
	static Writer report;
	static String ls = System.getProperty("line.separator");
	static WebDriver driver;
		
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
			report = new FileWriter("./report_03.csv",false);
			String driverPath = "";
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))
				driverPath = "./chromedriver";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
				driverPath = ".\\chromedriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(p.getProperty("url"));
	// HEADER
			System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
	report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);
	// 01 :: First Name	
			report.write("01,Chrome,index.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
			
			System.out.print("01,Chrome,index.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");

			setValue(By.id(p.getProperty("id_fname")),"fname_value");
	// 02 :: FLast Name
			report.write("02,Chrome,index.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			System.out.print("02,Chrome,index.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			setValue(By.id(p.getProperty("id_lname")),"lname_value");
	// 03 :: Email
			report.write("03,Chrome,index.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			
			System.out.print("03,Chrome,index.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			setValue(By.id(p.getProperty("id_email")),"email_value");
	// 04	:: Phone
			report.write("04,Chrome,index.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			
			System.out.print("04,Chrome,index.php,Phone," + 
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
			report.write("05,Chrome,confirmation.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
			
			System.out.print("05,Chrome,confirmation.php,First Name," + 
					isElementPresent(By.id(p.getProperty("id_fname"))) + "," +
					p.getProperty("fname_value") + "," +
					getSize(By.id(p.getProperty("id_fname"))) + "," +
					getLocation(By.id(p.getProperty("id_fname"))) + "\n");
	// 06 :: Last Name
			report.write("06,Chrome,confirmation.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
			
			System.out.print("06,Chrome,confirmation.php,Last Name," + 
					isElementPresent(By.id(p.getProperty("id_lname"))) + "," +
					p.getProperty("lname_value") + "," +
					getSize(By.id(p.getProperty("id_lname"))) + "," +
					getLocation(By.id(p.getProperty("id_lname"))) + "\n");
	// 07 :: Email
			report.write("07,Chrome,confirmation.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");
			
			System.out.print("07,Chrome,confirmation.php,Email," + 
					isElementPresent(By.id(p.getProperty("id_email"))) + "," +
					p.getProperty("email_value") + "," +
					getSize(By.id(p.getProperty("id_email"))) + "," +
					getLocation(By.id(p.getProperty("id_email"))) + "\n");		
	// 08 :: Phone
			report.write("08,Chrome,confirmation.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			
			System.out.print("08,Chrome,confirmation.php,Phone," + 
					isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
					p.getProperty("phone_value") + "," +
					getSize(By.id(p.getProperty("id_phone"))) + "," +
					getLocation(By.id(p.getProperty("id_phone"))) + "\n");
			report.flush(); report.close(); driver.quit();
		}
	}
