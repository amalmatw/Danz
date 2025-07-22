package page;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Loginpage {
	
	WebDriver d;
	By log=By.xpath("//*[@id='__next']/main/div/div//img[2]");
	By idfield=By.id("loginId");
	By firstnextbutton= By.xpath("//button[@type='button']");
	By password=By.name("password");
	By loginbutton =By.xpath("//button[@type='button']");
	By otp1=By.xpath("//*[@class='otpInutField_otpContainer__ld_e7']//div/input[1]");
	By otp2=By.xpath("//*[@class='otpInutField_otpContainer__ld_e7']//div/input[2]");
	By otp3=By.xpath("//*[@class='otpInutField_otpContainer__ld_e7']//div/input[3]");
	By otp4=By.xpath("//*[@class='otpInutField_otpContainer__ld_e7']//div/input[4]");
	By confirmbutton=By.xpath("//*[@type='button']");
	
	public Loginpage(WebDriver d)
	{
		this.d=d;
	}
	
	public void logoverification() throws Exception
	{
		Thread.sleep(6000);
		boolean act=d.findElement(log).isDisplayed();
		Assert.assertEquals(act, true);
	}
	
	public void splashscreen()
	{
		String exp="https://staging.danti.techfriar.xyz/splash";
//		if(d!=null) {
//			d.getCurrentUrl();
//		}
//		else {
//			System.out.println("null hey");
//		}
		d.getCurrentUrl();
		//System.out.println(d.getCurrentUrl());
		Assert.assertEquals(d.getCurrentUrl(), exp);
	}
	
	public void loginflow1(String id) throws Exception
	{
		//email id
	
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	//	d.findElement(idfield).clear();
		d.findElement(idfield).sendKeys(Keys.CONTROL +"a");
		d.findElement(idfield).sendKeys(Keys.DELETE);
		d.findElement(idfield).sendKeys(id);
		d.findElement(firstnextbutton).click();
		Thread.sleep(5000);
	}
	
	public void userid() throws Exception
	{
		Thread.sleep(8000);
		d.findElement(idfield).sendKeys(Keys.CONTROL +"a");
		d.findElement(idfield).sendKeys(Keys.DELETE);
		d.findElement(idfield).sendKeys("bijoy@techfriar.com");
		d.findElement(firstnextbutton).click();
		
	}
	
	
	public void loginflow2(String pass) throws Exception
	{
		//password
	
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	       // d.findElement(password).clear();
		d.findElement(password).sendKeys(Keys.CONTROL +"a");
		d.findElement(password).sendKeys(Keys.DELETE);
	        d.findElement(password).sendKeys(pass);
	      //  d.findElement(password).clear();
	        d.findElement(loginbutton).click();

	}
	
	public void passwordpg() throws Exception
	{
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	      
		d.findElement(password).sendKeys(Keys.CONTROL +"a");
		d.findElement(password).sendKeys(Keys.DELETE);
	        d.findElement(password).sendKeys("Admin123,.");
	        d.findElement(loginbutton).click();
	        //2factor authentication is disabled, so no otp page
	        Thread.sleep(5000);
			String exp="https://qa.danti.techfriar.xyz/";
			String act=d.getCurrentUrl();
			Assert.assertEquals(act, exp);
	}
	public void loginflow3() throws Exception
	{
		//otp
	
		
		d.findElement(otp1).sendKeys("1");
		d.findElement(otp2).sendKeys("2");
		d.findElement(otp3).sendKeys("3");
		d.findElement(otp4).sendKeys("4");
		d.findElement(confirmbutton).click();
		Thread.sleep(5000);
		String exp="https://qa.danti.techfriar.xyz/";
		String act=d.getCurrentUrl();
		Assert.assertEquals(act, exp);
	}
}
	



