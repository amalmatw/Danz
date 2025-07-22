package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dashboardpage {
	
	WebDriver d;
	By mainprofilepic= By.xpath("//div[@class='principalDashboardHeader_profileImage__5N5iW']/span/img");
	By sideprofilepic= By.xpath("//div[@class='sidebar_sidebarProfile__Vgap6']/div/span/img");
	By networthtrendgraph =By.xpath("//div[@class='principalDashboardNetworthGraph_chartWrapper__9Dk1S']/canvas");
	By refreshbutton=By.xpath("//*[@class='principalDashboardNetworthGraph_linkName__PXGcJ']");
	By searchfield=By.xpath("//input[@placeholder='Search']");
	By searchdrop=By.xpath("//*[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-17gxuku']/li[1]");
	By assetreportbutton=By.xpath("//*[contains(text(),'Asset reports')]");
	By wealthallocationgraph=By.xpath("//*[@class='principalDashboardWealthGraph_wealthAllocationMainWrap__Vdqmn']/div");
	By countrygraph=By.xpath("//*[@class='principalDashboardWealthGraph_doughnutGraphWrapper__KXYmm']/div/div[1]");
	By cashreservegraph=By.xpath("//*[@class='principalDashboardWealthGraph_doughnutGraphWrapper__KXYmm']/div/div[2]");
	By topcategories=By.xpath("//*[@class='principalDashboardHeader_currentNetWorthMain___TmNp']");
	By morebutton=By.xpath("//div[@class='sidebar_sidebarMenuTop__VGH7q']/nav/div");
	By contacticon=By.xpath("//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light sidebarMenu_useProfileDropDownMenu__rM_EC css-17gxuku']/li[1]");
	
			public Dashboardpage(WebDriver d)
	{
		this.d=d;
	}
	
	public void mainprofilepic()
	{
		boolean mp=d.findElement(mainprofilepic).isDisplayed();
		Assert.assertTrue(mp);
	}
	public void sideprofilepic()
	{
		boolean sp=d.findElement(mainprofilepic).isDisplayed();
		Assert.assertTrue(sp);
	}
	public void networthtrendgraph()
	{
		d.findElement(networthtrendgraph).isDisplayed();
		Assert.assertTrue(d.findElement(networthtrendgraph).isDisplayed());
	}
	
	public void refreshbutton() throws Exception
	{
		d.findElement(refreshbutton).isEnabled();
		Assert.assertTrue(d.findElement(refreshbutton).isEnabled());
		Thread.sleep(4000);
		System.out.println(d.findElement(refreshbutton).getText());
		d.findElement(refreshbutton).click();
	}
	
	public void search() throws Exception
	{
		
		Thread.sleep(30000);
		WebElement x=d.findElement(searchfield);
		
		d.findElement(searchfield).sendKeys("tony",Keys.ENTER);
		x.click();
		Thread.sleep(30000);
	//	WebDriverWait wait=new WebDriverWait(d,40);
	//	WebElement s=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light css-17gxuku']/li[1]")));
		d.findElement(searchdrop).click();
	}
	
	public void assetreportbutton()
	{
		d.findElement(assetreportbutton).isEnabled();
		Assert.assertTrue(d.findElement(assetreportbutton).isEnabled());
	}
	
	public void assetreportpage() throws Exception
	{
		d.findElement(assetreportbutton).click();
		String exp="https://staging.danti.techfriar.xyz/assetReports";
		Thread.sleep(6000);
		String act=d.getCurrentUrl();
		Assert.assertEquals(act, exp);
	}
	
	public void wealthallocation()
	{
		
		Assert.assertTrue(d.findElement(wealthallocationgraph).isDisplayed());
	}
	
	public void country()
	{
		Assert.assertTrue(d.findElement(countrygraph).isDisplayed());
	}
	public void cashreserve()
	{
		Assert.assertTrue(d.findElement(cashreservegraph).isDisplayed());
	}
	public void topcategorieslist()
	{
		Assert.assertTrue(d.findElement(topcategories).isDisplayed());
	}
	public void contactpage() throws Exception
	{
		Thread.sleep(10000);
		d.findElement(morebutton).click();
		Thread.sleep(3000);
		d.findElement(contacticon).click();
		String exp="https://staging.danti.techfriar.xyz/contacts";
		String act=d.getCurrentUrl();
		Assert.assertEquals(act, exp);
	}

}
