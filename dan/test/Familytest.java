package test;

import java.time.Duration;

import org.testng.annotations.Test;

import base.Baseclass;
import page.Familypage;
import page.Loginpage;

public class Familytest extends Baseclass{
	
	@Test (priority=1)
	public void login() throws Exception
	{
		ts=rs.createTest("Successful login");
		Loginpage lp=new Loginpage(d);
		lp.userid();
		lp.passwordpg();
	}
	
	@Test (priority=2)
	public void familytreee() throws Exception
	{
		ts=rs.createTest("Loaded family tree page successfully");
		Familypage fp=new Familypage(d);
		fp.familypageload();
		Thread.sleep(6000);
	//	fp.addfamilymember();
	
		fp.editfamilymember();
	}

}
