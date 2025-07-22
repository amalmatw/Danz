package test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.Baseclass;
import page.Dashboardpage;
import page.Loginpage;
import utilities.ExcelHandler;
import utilities.Screenshots;

public class Dashboardtest extends Baseclass {

	
/*	public void loginverification() throws Exception
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
		
	} */
	@Test (priority=1)
	public void login() throws Exception 
	{
		ts=rs.createTest("Login verification");
		Loginpage lp=new Loginpage(d);
		lp.userid();
		lp.passwordpg();
	//	lp.loginflow3();
	}
	
	@Test (priority =3)
	public void mainprofileimg()
	{
		ts=rs.createTest("Main profile image is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.mainprofilepic();
	}
	
	@Test (priority =2)
	public void sideprofileimg() 
	{
		ts=rs.createTest("Side profile image is displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.sideprofilepic();
	}
	
	@Test (priority=4)
	public void networthgraph()
	{
		ts=rs.createTest("Networth trend graph displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.networthtrendgraph();
	}
	
	@Test (priority=5)
	public void networthgraphrefresh() throws Exception
	{
		ts=rs.createTest("Refresh button enabled?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.refreshbutton();
	}
		
	@Test (priority=6)
	public void searchtest() throws Exception
	{
		ts=rs.createTest("Search box working?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.search();
		//d.navigate().back();
	}
	
	@Test (priority=7, enabled=true)
	public void assetreportbutton()
	{
		ts=rs.createTest("Assetreport button working?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportbutton();
	}
	
	@Test (priority=8, enabled=true)
	public void assertreportpage() throws Exception
	{
	ts=rs.createTest("Redirected to Asset report page?");
	Dashboardpage dp=new Dashboardpage(d);
		dp.assetreportpage();
	}
	
	@Test (priority=9)
	public void wealthallocate()
	{
		ts=rs.createTest("Wealth allocation graph?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.wealthallocation();
	}
	@Test (priority=10)
	public void cashreservebreakdown()
	{
		ts=rs.createTest("Cash reserve breakdown graph?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.cashreserve();
	}
	@Test (priority=11)
	public void topcategory()
	{
		ts=rs.createTest("Top categories displayed?");
		Dashboardpage dp=new Dashboardpage(d);
		dp.topcategorieslist();
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
