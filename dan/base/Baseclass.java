package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	protected WebDriver d;
	ExtentHtmlReporter rtr;
	protected ExtentReports rs;
	protected ExtentTest ts;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		d=new ChromeDriver(c);
		
		rtr=new ExtentHtmlReporter("./Report/R.html");
		rtr.config().setTheme(Theme.DARK);
		rtr.config().setDocumentTitle("Automation Report");
		rtr.config().setReportName("Danti");
		
		rs=new ExtentReports();
		rs.attachReporter(rtr);
		rs.setSystemInfo("Browser", "Chrome");
		rs.setSystemInfo("OS", "Windows ");
		rs.setSystemInfo("Tester", "Amal");
	}
	
	@BeforeMethod
	public void url()
	{
		d.get("https://qa.danti.techfriar.xyz/");
		d.manage().window().maximize();
	}

}
