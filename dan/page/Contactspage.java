package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Contactspage {

	WebDriver d;
	By Addbuton=By.xpath("//div[@class='contactHeader_contactAdd__lA8u_']/button");
	By firstname=By.id("firstName");
	By lastname=By.id("lastName");
	By countrycode=By.xpath("//div[@class='iti-flag ae']");
	By Indiacode=By.xpath("//ul[@class='country-list']/li[99]");
	By tel=By.xpath("//input[@type='tel']");
	By emailaddress=By.id("emailAddress");
	By company=By.id("AddCompany");
	By jobtitle=By.id("AddJobTitle");
	By addadressbutton=By.xpath("//div[@class='contactAdd_addAddress__jOkJu']/span");
	By street=By.id("street");
	By city=By.id("city");
	By state=By.id("state");
	By zip=By.id("zip");
	By country=By.id("country");
	By addnotesbutton=By.xpath("//div[@class='contactAdd_addNotes__GqWlt']/span");
	By notes=By.id("Addnotes");
	
	public Contactspage(WebDriver d)
	{
		this.d=d;
	}
	
	public void addcontact() throws Exception
	{
		Thread.sleep(7000);
		d.findElement(Addbuton).click();
		d.findElement(firstname).sendKeys("Tommy");
		d.findElement(lastname).sendKeys("Gun");
		d.findElement(countrycode).click();
		Thread.sleep(5000);
		d.findElement(Indiacode).click();
		d.findElement(tel).sendKeys("9545633552");
		d.findElement(emailaddress).sendKeys("tg@gun.com");
		d.findElement(company).sendKeys("Dodge");
		d.findElement(jobtitle).sendKeys("Knight",Keys.ENTER);
		d.findElement(addadressbutton).click();
		
	}
}
