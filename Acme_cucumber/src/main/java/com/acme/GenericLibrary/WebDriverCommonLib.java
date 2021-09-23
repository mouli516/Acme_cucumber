package com.acme.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommonLib extends BaseTest{
	
	
	public String getpagetitle()
	{
		String pagetitle = BaseTest.driver.getTitle();
		return pagetitle;
	}
	
	public void waitpage(String title)
	{
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,20);
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	public void selectOptionsBytext(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}
	public void selectOptionsByvalue(String value,WebElement element)
	{
		Select sel = new Select(element);
		
		sel.selectByValue(value);
	}
	public void selectOptionsByindex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mouseHover(WebElement element)
	{
	Actions ac = new Actions(BaseTest.driver);
	ac.moveToElement(element).perform();
	}
	
	public void verify(String actual, String expected, String page)
	{
		if(actual.equals(expected))
		{
			System.out.println(page+" is displayed, pass");
		}
		else
		{
			System.out.println(page+" is not displayed, fail");
		}
	}
	
	public String getpagescreeenshot(String path,String Screenshotname)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = path+Screenshotname+".png";
		File dest1 = new File(dest);
		try 
		{
			Files.copy(src, dest1);
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		}
		return dest;
	}
	
	public void getelementscreenshot(WebElement element,String path)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void switchToFrame(int index)
	{
		BaseTest.driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String value)
	{
		BaseTest.driver.switchTo().frame(value);
	}
	
	public void switchToFrame(WebElement element)
	{
		BaseTest.driver.switchTo().frame(element);
	}
	
	public void dropdownenabled(WebElement element, String elementname)
	{
		if(element.isEnabled())
		{
			Assert.assertTrue(true);
			Reporter.log(elementname+" is Enabled",true);
		}
		else
		{
			Assert.assertTrue(false);
			Reporter.log(elementname+" is Disabled",true);
		}
	}
	
	
	public void getWindowHandleclick(String targetbrowsertitle,WebElement element) throws Throwable
	{
		String mainwindow = BaseTest.driver.getWindowHandle();
		Set<String> allwindows = BaseTest.driver.getWindowHandles();
		
		for(String currentwindow:allwindows)
		{
			String title = BaseTest.driver.switchTo().window(currentwindow).getTitle();
			if(title.equalsIgnoreCase(targetbrowsertitle))
			{
				//System.out.println(title);
				Thread.sleep(3000);
				element.click();
			}
		}
		BaseTest.driver.switchTo().window(mainwindow);
	}
		
	public void getWindowHandleclose(WebElement element,String targetbrowsertitle)
		{
			Set<String> allwindows = BaseTest.driver.getWindowHandles();
			
			for(String currentwindow:allwindows)
			{
				String title = BaseTest.driver.switchTo().window(currentwindow).getTitle();
				if(title.equalsIgnoreCase(targetbrowsertitle))
				{
					BaseTest.driver.close();
				}
			}
	    }
	
	public void windowtitles()
	{
		Set<String> win = BaseTest.driver.getWindowHandles();
		for(String w:win)
		{
			String title = BaseTest.driver.switchTo().window(w).getTitle();
			System.out.println(title);
		}
		
		
		
		
	}
	public void scrolldown(WebElement element)
	{
		Point location = element.getLocation();
		JavascriptExecutor jse = (JavascriptExecutor)BaseTest.driver;
		jse.executeScript("window.scrollBy"+location);
	}
	
	
	

}
