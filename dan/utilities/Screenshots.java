package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	

	
	public String shots(WebDriver d, String name) throws Exception 
	{
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		String destination ="./Screenshot/"+name+".png";
		FileHandler.copy(src,new File(destination));
		return destination;
		
		
	}

}
