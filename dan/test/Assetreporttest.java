package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Baseclass;
import page.Assetreportpage;
import page.Dashboardpage;
import page.Loginpage;
import utilities.Screenshots;

public class Assetreporttest extends Baseclass {

	@Test (priority=1)
	public void login() throws Exception 
	{
		ts=rs.createTest("Login verification");
		Loginpage lp=new Loginpage(d);
		lp.userid();
		lp.passwordpg();
	//	lp.loginflow3();
	}
	
	@Test (priority=2)
	public void assertreportpage() throws Exception 
	{
	ts=rs.createTest("Redirected to Asset report page?");
	Dashboardpage dp=new Dashboardpage(d);
	dp.assetreportpage();
	}
	
	@Test (priority=3)
	public void wealthallocationtest() throws Exception
	{
		ts=rs.createTest("Wealth allocation graph is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.wealthgraph();
	}
	
	@Test (priority=4)
	public void cashreservebreakdown() throws Exception
	{
		ts=rs.createTest("Cash reserve breakdown is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.cashreservegraph();
	}
	
	@Test (priority=5)
	public void wealthpercent() throws Exception
	{
		ts=rs.createTest("Wealth allocation percentage graph is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.wealthpercentgraph();
	}
	
	@Test (priority=6)
	public void countrygrph() throws Exception
	{
		ts=rs.createTest("Country graph is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.country();
	}
	
	@Test (priority=7)
	public void filterworks() throws Exception
	{
		
		ts=rs.createTest("Filters working ?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.filterclick();
	}
	
	@Test (priority=8)
	public void cashreservetrendgraph() throws Exception
	{
		ts=rs.createTest("Cashreserve trend graph?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
		Assetreportpage as=new Assetreportpage(d);
		as.cashtrend();
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


