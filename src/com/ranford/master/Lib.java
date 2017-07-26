package com.ranford.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class Lib 
{
	 public static WebDriver driver;
	 public static String Expval,Actval;
	 public static Properties Pr;
	 public static FileInputStream Fis;
	
public String OpenApp(String Url)
{
	
	Expval="Ranford Bank";
	
  driver = new FirefoxDriver();
	driver.manage().window().maximize();
    driver.get(Url);
    String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
   if (Expval.equalsIgnoreCase(Actval))
   {
	 System.out.println("Ranford home page is displayed");
	 return "Pass";
}
   else
   {
	   System.out.println("Ranford home page is not displayed");
	   return "Fail";
   }

}

public void Login(String Uname,String Pswd) throws IOException
{
	Pr=new Properties();
	Fis=new FileInputStream("E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\properties\\Rep.properties");
	Pr.load(Fis);
	
	Expval="Welcome to Admin";
    
    driver.findElement(By.id(Pr.getProperty("Un"))).sendKeys(Uname);
    driver.findElement(By.id(Pr.getProperty("Pwd"))).sendKeys(Pswd);
    driver.findElement(By.id(Pr.getProperty("Lgn"))).click();
 Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();

 if (Expval.equalsIgnoreCase(Actval))
   {
	 System.out.println("Admin home page is displayed");
}
   else
   {
	   System.out.println("Admin home page is not displayed");
   }


}

public String Role(String Rname,String Rdes,String Rtype)
{
	Expval="Sucessfully";
    Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.xpath(Pr.getProperty("RBtn"))).click();
		    driver.findElement(By.id(Pr.getProperty("NRBtn"))).click();
		    driver.findElement(By.id(Pr.getProperty("RN"))).sendKeys(Rname);
		    driver.findElement(By.id(Pr.getProperty("Rdes"))).sendKeys(Rdes);
		    Sleeper.sleepTightInSeconds(4);
		    Select type = new Select (driver.findElement(By.id(Pr.getProperty("Rtype"))));
		    type.selectByVisibleText(Rtype);
		    Sleeper.sleepTightInSeconds(4);
		    driver.findElement(By.id(Pr.getProperty("BtnIns"))).click();
		    Actval= driver.switchTo().alert().getText();
		    driver.switchTo().alert().accept();
		    driver.findElement(By.xpath((Pr.getProperty("HBt")))).click();
		    if (Actval.contains(Expval))
		    {
		    	System.out.println("Role created");
		    	return Actval;
		    	    }
		    else
		    {
		    	System.out.println("Role already exists");
		    	return Actval;
		    }

}
public void employee(String EName, String EPwd, String Erole, String Ebranch){
	
	Expval= "Successfully";
	Sleeper.sleepTightInSeconds(4);
	driver.findElement(By.xpath(Pr.getProperty("Ebutton"))).click();
	driver.findElement(By.xpath(Pr.getProperty("NEbutton"))).click();
	driver.findElement(By.id(Pr.getProperty("EUname"))).sendKeys(EName);
	Sleeper.sleepTightInSeconds(4);
	driver.findElement(By.id(Pr.getProperty("EPwd"))).sendKeys(EPwd);
	//driver.findElement(By.id("lst_Roles"))
	Sleeper.sleepTightInSeconds(4);
	new Select(driver.findElement(By.id(Pr.getProperty("ERole")))).selectByVisibleText(Erole);
	Sleeper.sleepTightInSeconds(4);
	//driver.findElement(By.id("lst_Branch"))
	new Select(driver.findElement(By.id(Pr.getProperty("EBranch")))).selectByVisibleText(Ebranch);
	Sleeper.sleepTightInSeconds(4);
	driver.findElement(By.id(Pr.getProperty("ESubmit"))).click();
	Sleeper.sleepTightInSeconds(4);
	Actval= driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	System.out.println(Actval);
	if(Actval.contains(Expval) )
	{
		System.out.println("Employee created");
		
	}
	else
	{
		System.out.println("Employee already existed");
	}
	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
	
}

public void Logout()
{
	Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
}

public void Close()
{
	driver.close();
}
}
