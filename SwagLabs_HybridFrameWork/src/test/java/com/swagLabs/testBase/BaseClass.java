package com.swagLabs.testBase;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.swagLabs.pageObjects.LogInPage;
public class BaseClass
{

	public static WebDriver driver;
    public Logger logger;
    
	@BeforeClass(groups = {"EndToEnd","Master","Regression","Functional"})
  // @org.testng.annotations.Parameters({"browser"})
    public void setUp() throws InterruptedException {
       
		
		logger=LogManager.getLogger(this.getClass());  //lOG4J2
		  
//	    // Initialize the WebDriver based on the browser name
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            default:
//                System.out.println("Please provide a valid browser name (chrome, firefox, edge)");
//                break;
//        }
	
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.saucedemo.com/");
        
      
        
        
        
    }
	@AfterClass(groups ={"EndToEnd","Master","Regression","Functional"})
    public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
    }
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
