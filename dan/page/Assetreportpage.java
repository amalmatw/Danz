package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assetreportpage {

	WebDriver d;
	By Wealthallocationgraph=By.xpath("//canvas[@role='img']");
	By cashreserve=By.xpath("//*[@class='ant-row css-17gxuku']/div[1]");
	By wealthallocationpercent=By.xpath("//*[@class='ant-row css-17gxuku']/div[2]");
	By country=By.xpath("//*[@class='ant-row css-17gxuku']/div[3]");
	By performancefilter=By.xpath("//*[@class='principalDashboardAssetReport_dropDownWrap__OX6HV']/div[1]");
	//By leastperformance=By.xpath("//*[contains(text(),'Least performing assets')]");
	By leastperformance=By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/div");
	By cashreservetrend=By.xpath("//div[@class='principalDashboardAssetReport_cashReserveWrapper__1doMm']");
    public Assetreportpage(WebDriver d)
	{
		this.d=d;
	}
	
	public void wealthgraph()
	{
		d.findElement(Wealthallocationgraph).isDisplayed();
		
		Assert.assertTrue(d.findElement(Wealthallocationgraph).isDisplayed());
	}
	public void cashreservegraph()
	{
		d.findElement(cashreserve).isDisplayed();
	
		Assert.assertTrue(d.findElement(cashreserve).isDisplayed());
	}
	public void wealthpercentgraph()
	{
		d.findElement(wealthallocationpercent).isDisplayed();
	
		Assert.assertTrue(d.findElement(wealthallocationpercent).isDisplayed());
	}
	public void filterclick() throws Exception
	{
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,500)", "");
		d.findElement(performancefilter).click();
		Thread.sleep(5000);
		d.findElement(leastperformance).click();
		
	}
	public void country()
	{
		d.findElement(country).isDisplayed();
		System.out.println(d.findElement(country).getText());
		Assert.assertTrue(d.findElement(country).isDisplayed());
	}
	public void cashtrend()
	{
		System.out.println(d.findElement(cashreservetrend).getText());
		Assert.assertTrue(d.findElement(cashreservetrend).isDisplayed());
	}
}
