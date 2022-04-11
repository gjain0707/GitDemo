package jain2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;

	@BeforeTest
	public void Config() {
		
		//ExtentSparkReporter, ExtentReports - classes will be used 
		// 1. path variable where you want to save the report.
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		
		// 2. Create the objects of ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		//3. use different methods for different actions
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setReportName("Web Automation Result");
		
		//4. Create the objects of ExtentReports
		extent =new ExtentReports();
		
		
		//5. provide the ExtentSparkReporter object as argument for ExtentReports class
		extent.attachReporter(reporter);
		
	}
	
	@Test
	public void InitialDemo() {
		
		extent.createTest("InitialDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		
		extent.flush();
	}
	
	
	
	
	
}
