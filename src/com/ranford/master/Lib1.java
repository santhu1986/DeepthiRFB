package com.ranford.master;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.channel.StaticChannelPipeline;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;


public class Lib1
{
		public static Properties Pr;
		public static FileInputStream Fis;
	public static WebDriver driver;
	public static String Expval,Actval;

	public String openApp(String Url) throws IOException
	{
	
		 Expval="Ranford Bank";
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(Url);
		Sleeper.sleepTightInSeconds(4);
		String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();	
				System.out.println(Actval);
		if (Expval.equalsIgnoreCase(Actval)) 
		{
		System.out.println("Application is launched");
		return "pass";
		}
		else
		{
			System.out.println("Application not opened");
			return "fail";
		}
	}
	public String AdmLgn(String Un,String Pwd)
	{
		Expval="Welcome to Admin";
		driver.manage().window().maximize();
		driver.findElement(By.id("txtuId")).sendKeys(Un);
		driver.findElement(By.id("txtPword")).sendKeys(Pwd);
		driver.findElement(By.id("login")).click();
		
		Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		System.out.println(Actval);
		//driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	if (Expval.equalsIgnoreCase(Actval)) 
	{
	System.out.println("adminhome is displayed");
	return "pass";
	}
	else
	{
		System.out.println("adminhome is not displayed");
	return "fail";
	}
		}

	public String Role(String RN,String RT)
	{
		Expval="Sucessfully";
		Sleeper.sleepTightInSeconds(4);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Sleeper.sleepTightInSeconds(2);
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  return "Pass";
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  return "Fail";
	      }
	      
	     }

	      public void branch()
	      {
	    	  driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
	  		driver.findElement(By.xpath(".//*[@id='BtnNewBR']")).click();
	  		driver.findElement(By.id("txtbName")).sendKeys("hfmhkmh");
	          Sleeper.sleepTightInSeconds(2);
	  		driver.findElement(By.id("txtAdd1")).sendKeys("lkhjhhj");
	          Sleeper.sleepTightInSeconds(2);
	          driver.findElement(By.id("txtZip")).sendKeys("12345");
	   		 Sleeper.sleepTightInSeconds(2);
	  		driver.findElement(By.id("lst_counrtyU")).sendKeys("INDIA");
	  		 Sleeper.sleepTightInSeconds(2);
	  		
	  		driver.findElement(By.id("lst_stateI")).sendKeys("Andhra Pradesh");
	  		WebElement d=driver.findElement(By.xpath(".//*[@id='lst_cityI']"));
	  		 Sleeper.sleepTightInSeconds(2);
	  		d.click();
	  		
	  		List<WebElement> city=driver.findElements(By.xpath(".//*[@id='lst_cityI']/option"));
	  		System.out.println(city.size());
	  		for (int i = 0; i < city.size(); i++) 
	  		{
	  			if (city.get(i).getText().equalsIgnoreCase("Hyderabad")) 
	  			{
	  				
	  				city.get(i).click();
	  				break;
	  				
	  			}
	  			}
	  		driver.findElement(By.xpath(".//*[@id='btn_insert']")).click();
	  		Sleeper.sleepTightInSeconds(4);
	  		driver.switchTo().alert().accept();
	  		Sleeper.sleepTightInSeconds(4);
	  		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
	  	
	      }
	     public void admlgt()
	     
	     {
	    	 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
	    	 
	    	 }

	     public void Appc()
	     {
	    	 driver.close();
	     }

	}

