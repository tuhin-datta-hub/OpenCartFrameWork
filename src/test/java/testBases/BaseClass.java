package testBases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
//logger import
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties pf;

	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws IOException {
		

		switch (browser.toLowerCase()) {
			case "chrome" :
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge" :
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default :
				System.out.println("Invalid brower");
				return;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		FileInputStream file=new FileInputStream("./src/test/resources//config.properties");
		pf=new Properties();
		pf.load(file);
		
		driver.get(pf.getProperty("url"));
	}

	@AfterClass(groups = {"sanity","regression","master","datadriven"})
	public void closeBrowser() {
		driver.quit();
	}

	
	
	public String captureScreen(String tname) {
		
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		String trg_FilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File trg=new File(trg_FilePath);
		src.renameTo(trg);
		
		return trg_FilePath;
		
	}

}
