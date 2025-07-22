package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Familypage {

	WebDriver d;
	By fmlypage=By.xpath("//div[@class='sidebar_sidebarMenuTop__VGH7q']/nav/li[4]");
	By addbutton=By.xpath("//div[@class='ant-space css-17gxuku ant-space-horizontal ant-space-align-center cursor-pointer']");
	By name=By.id("memberName");
	By genderfield=By.xpath("//div[@class='ant-select appSelect_customSelect__vZuyq  undefined css-17gxuku ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']");
	By genderselect=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div[1]");
	By relatedto=By.xpath("//div[@class='ant-select selectMember_customSelect__BLn3p undefined css-17gxuku ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']/div[1]");
	By relatedname=By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div/div[3]/div[2]/div/div[2]/div[1]/div/div/div[2]/div");
	By relationtype=By.xpath("//div[@class='ant-select appSelect_customSelect__vZuyq  undefined css-17gxuku ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']");
	By relationtypeselect=By.xpath("//body/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[4]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]");
	By crelation=By.xpath("//body/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[5]/div[1]/div[3]/div[1]/div[1]/span[2]");
	By crelationselect=By.xpath("//body/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[5]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By dobpick=By.xpath("//*[@id=\"dob\"]");
	By dobyear=By.xpath("//button[contains(text(),'2024')]");
	By yearcal=By.xpath("//div[@class='ant-picker-year-panel']/div[2]/table/tbody/tr/td");
	By prevyrbutton=By.xpath("//body/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]");
	By monthcal=By.xpath("//*[@class='ant-picker-month-panel']/div/table/tbody/tr/td");
	By datecal=By.xpath("//*[@class='ant-picker-date-panel']/div/table/tbody/tr/td");
	By email=By.id("emailID");
	By phonedrop=By.xpath("//div[@class='flag-container']/div/div");
	By phonecode=By.xpath("//body/div[6]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[10]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[8]");
	By phoneinput=By.xpath("//input[@id='']");
	By rolefield=By.xpath("//div[@class='ant-select-selection-overflow']");
	By roleselct=By.xpath("//div[contains(text(),'Expert')]");
	By savebtn=By.xpath("//*[contains(text(),'Save')]");
	By listview=By.xpath("//div[@class='toggle-mode-wrap']//div[2]//button[1]//*[name()='svg']");
	By fmlymembersel=By.xpath("//*[contains(text(),'Tom')]");
	By kebabmenu=By.xpath("//div[@class='profileWrap_menuPropsBox__rqsYw']");
	//Edit window
	By editmembropt=By.xpath("//div[@class='ant-dropdown appOptionsDropDown_CustomDropDown__XKIE6 css-17gxuku ant-dropdown-placement-bottomRight']/ul/li[1]");
	By editname=By.xpath("//input[@value='Tom']");
	By genfield=By.xpath("//div[@class='ant-select-selector']");
	By genselct=By.xpath("//div[contains(text(),'Female')]");
	By dobfld=By.xpath("//div[@class='ant-picker-input']");
	By previousbutton=By.xpath("//span[@class='ant-picker-super-prev-icon']");
	//By yearcal1=By.xpath("//div[@class='ant-picker-body']/table/tbody/tr/td");
	By mnthcal=By.xpath("//*[@class='ant-picker-month-panel']/div[2]/table/tbody/tr/td");
	By datcal=By.xpath("//div[@class='ant-picker-date-panel']/div[2]/table/tbody/tr/td");
	By location=By.xpath("//div[@class='ant-row css-17gxuku']/div[4]/div/input");
	
	public Familypage(WebDriver d)
	{
		this.d=d;
	}
	
	public void familypageload() throws Exception
	{
		Thread.sleep(8000);
		d.findElement(fmlypage).click();
	}
	
	public void addfamilymember() throws Exception
	{
		d.findElement(addbutton).click();
		d.findElement(name).sendKeys("Jose");
		d.findElement(genderfield).click();
		d.findElement(genderselect).click();
		d.findElement(relatedto).click();
		Thread.sleep(5000); 
		d.findElement(relatedname).click();
		d.findElement(relationtype).click();
		Thread.sleep(5000); 
		d.findElement(relationtypeselect).click();
		d.findElement(crelation).click();
		d.findElement(crelationselect).click();
		d.findElement(dobpick).click();

		d.findElement(dobyear).click();
		
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(50));
		boolean yrselected=false;
		while(!yrselected)
		
		{
 try {
		   
			List<WebElement> yr=d.findElements(yearcal);
			for(WebElement y:yr )
			{
				 String expyear = "1868";
			String act=y.getAttribute("title");
			System.out.println(act);
			if(act.equalsIgnoreCase(expyear))
			{
				
				y.click();
				yrselected=true;
				break;
				}
				
			}
			if(!yrselected)
			{
			d.findElement(prevyrbutton).click();
			}
 }
			catch(StaleElementReferenceException e)
			{
				System.out.println("Stale Element Exception caught, retrying...");
				
			}
			}
			
	
		
		List<WebElement> mn=w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(monthcal));
			for(WebElement mnth:mn)
			{
				String expmonth = "Nov";
				String actmn=mnth.getText();
				System.out.println(actmn);
				if(actmn.equalsIgnoreCase(expmonth))
				{
					try
					{
					mnth.click();
					}
					catch(StaleElementReferenceException e)
					{
						System.out.println("Stale Element Exception caught, retrying...");
						w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(monthcal));
						mnth.click();
					}
					Thread.sleep(5000);
					String expdate="15";
					List<WebElement> dt=w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(datecal));
					for(WebElement dats:dt)
					{
						String actdate=dats.getText();
						
						if(actdate.equalsIgnoreCase(expdate))
						{
							try
							{
							dats.click();
							break;
							}
							catch(StaleElementReferenceException e)
							{
								System.out.println("Stale Element Exception caught, retrying...");
								dt=d.findElements(datecal);
							}
						}
					}
					break;
				}
			}
			
			JavascriptExecutor js=(JavascriptExecutor)d;
			js.executeScript("window.scrollBy(0,250)");
			d.findElement(email).sendKeys("jos@gmail.com");
		//	w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(phonedrop));
		//	WebElement pd=w.until(ExpectedConditions.elementToBeClickable(phonedrop));
			
		//	pd.click();
		//	js.executeScript("arguments[0].click();", pd);
		//	d.findElement(phonecode).click();
			d.findElement(phoneinput).sendKeys("956335556");
			d.findElement(rolefield).click();
			Thread.sleep(5000);
			d.findElement(roleselct).click();
			d.findElement(savebtn).click();
	}

	public void editfamilymember() throws Exception
	{
		d.findElement(listview).click();
		d.findElement(fmlymembersel).click();
		Thread.sleep(3000);
		d.findElement(kebabmenu).click();
		d.findElement(editmembropt).click();
		Thread.sleep(3000);
		Actions act=new Actions(d);
	   WebElement edn=d.findElement(editname);
	   act.keyDown(edn, Keys.CONTROL).sendKeys("A");
	   act.keyDown(Keys.DELETE);
	   act.keyUp(Keys.CONTROL);
	   act.keyUp(Keys.DELETE);
	   act.perform();
	   Thread.sleep(3000);
	   edn.click();
	   edn.sendKeys("Sara");
	   d.findElement(genfield).click();
	   d.findElement(genselct).click();
	   d.findElement(dobfld).click();
	   d.findElement(dobyear).click();
	   
	   WebDriverWait wt=new WebDriverWait(d,Duration.ofSeconds(50));
	
	//   List<WebElement> yr =d.findElements(yearcal1);
	   
	   boolean yrs= true;
	   while(yrs)
	   {
		   List<WebElement> yr=wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(yearcal));
		   try
			{
	   for(WebElement y:yr)
	   {
		   
		   String expyr="1990";
		   String actyr=y.getAttribute("title");
		   
		   System.out.println(actyr);
		     
		   if(actyr.equalsIgnoreCase(expyr))
		   {
			
			   y.click();
			
			   yrs=false; 
			   break;
			  
			   }
			 
		  
	
		   }
	   if(yrs)
	   {
			   d.findElement(previousbutton).click();
	   }
			}
		   catch(StaleElementReferenceException e)
		   {
			   System.out.println("Stale Element Exception caught, retrying 1...");
			   
		   }
		   
	   }
	 
	   
	   List<WebElement> mns=d.findElements(mnthcal);
	   try
	   {
	   for(WebElement mnt:mns)
	   {
		   String exmnth="Feb";
		   String actmnth=mnt.getText();
		   System.out.println(mnt);
		   if(exmnth.equalsIgnoreCase(actmnth))
		   {
			   
				   mnt.click();  
			   }
	   }
	   }
			   catch(StaleElementReferenceException e)
			   {
				   System.out.println("Stale Element Exception caught, retrying 2...");
//				   wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mnthcal));
//				   mnt.click();
			   }
			   
		   
	   
	   
	   try
	   {
	   List<WebElement> da=d.findElements(datcal);
	   
	   for(WebElement dat:da)
	   {
		   String expda="11";
		   String actda=dat.getText();
		   
		   if(expda.equalsIgnoreCase(actda))
		   {
			  
			   dat.click();
			   }
	   }
	   }
			   catch(StaleElementReferenceException E)
			   {
				   System.out.println("Stale Element Exception caught, retrying 3...");
//				   wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(datcal));
//				   dat.click();
			   }
	   d.findElement(location).sendKeys("Kottayam");
		   }
	   
	   
	   
		
	}
			
		
		
	


		
	
	
		
		
		
			
		
		
		
	


