package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Baseclass;
import page.Contactspage;
import page.Dashboardpage;
import page.Loginpage;
import utilities.Screenshots;

public class Contacttest extends Baseclass {

	@Test (priority=1)
	public void login() throws Exception
	{
		ts=rs.createTest("Successful login");
		Loginpage lp=new Loginpage(d);
		lp.userid();
		lp.passwordpg();
	}
	@Test (priority=2)
	public void contactpageopen() throws Exception
	{
		ts=rs.createTest("Contact page loaded successful");
		Dashboardpage dp=new Dashboardpage(d);
		dp.contactpage();
	}
	
	@Test (priority=3)
	public void addcontact() throws Exception
	{
		ts=rs.createTest("Contact created?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.contactpage();
		Contactspage cp=new Contactspage(d);
		cp.addcontact();
	}
	@AfterMethod
	public void report(ITestResult I) throws Exception
	{
		if(I.getStatus()==ITestResult.SUCCESS)
		{
			ts.log(Status.PASS, "Success case "+I.getName());
		}
		else if(I.getStatus()==ITestResult.FAILURE)
		{
			ts.log(Status.FAIL,"Failed case "+I.getName());
			ts.log(Status.FAIL, "Reason for failure "+I.getThrowable());
			Screenshots s=new Screenshots();
			String path=s.shots(d,I.getName());
			ts.addScreenCaptureFromPath(path);
			
		}
		else
		{
			ts.log(Status.SKIP, "Skipped case "+I.getName());
		}
	}
	
	@AfterTest
	public void complete()
	{
		rs.flush();
		//d.close();
		
	}
	
}
