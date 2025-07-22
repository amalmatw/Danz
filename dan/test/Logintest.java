package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Baseclass;
import page.Loginpage;
import utilities.ExcelHandler;
import utilities.Screenshots;

public class Logintest extends Baseclass{
	
	@Test (priority=2, enabled=true)
	public void logo() throws Exception
	{
		ts=rs.createTest("Logo Displayed?");
		Loginpage lp=new Loginpage(d);
		lp.logoverification();
	}
	
	@Test (priority =1, enabled=true)
	public void splash()
	{
		ts=rs.createTest("Splash screen available?");
		Loginpage lp=new Loginpage(d);
		lp.splashscreen();
	}
	
	@Test (priority=3)
	public void loginverification() throws Exception
	{
		ts=rs.createTest("Login verification");
		Loginpage lp=new Loginpage(d);
		
		String path="C:\\Users\\Techfriar\\OneDrive\\Desktop\\to attach\\loginid.xlsx";
		String Sheet="Sheet1";
		int count=ExcelHandler.lastrow(path, Sheet);
	
		for(int i=1;i<count;i++)
		{

			Thread.sleep(3000);
			String user=ExcelHandler.details(path,Sheet,i,1);
			System.out.println("User Id "+user);

			
			lp.loginflow1(user);
		}
		for(int i=1;i<count;i++)
		{
			
			Thread.sleep(3000);

			String pass=ExcelHandler.details(path,Sheet,i,2);
			System.out.println("Password "+pass);
			
			lp.loginflow2(pass);
		}
		
		lp.loginflow3();
		
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
		d.close();
		
	}

}
