package com.ranford.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exelib {

	
	public static void main(String[] args) throws IOException 
	{
	
		//instance class
		
		Lib LB=new Lib();
		
		String Res=LB.OpenApp("http://seoemirates.com/Build2/home.aspx");
		System.out.println(Res);
		LB.Login("Admin","Admin");
		/*LB.Role("telleraxis","teller","E");
		LB.Logout();
		LB.Close();*/
		
		//To get File
		
		FileInputStream Fis=new FileInputStream("E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\testdata\\Role.xlsx");
		
		//creating workbook
		
		XSSFWorkbook WB=new XSSFWorkbook(Fis);
		
		//sheets
		
		XSSFSheet WS=WB.getSheet("Roledata");
		
		//Row count
		
		int Rc=WS.getLastRowNum();
		System.out.println(Rc);
		
		//multiple interations ------For loop
		
		for (int i=1; i<=Rc;i++) 
		{
		//Rows
			
			XSSFRow WR=WS.getRow(i);
			
			//cells
			
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			XSSFCell WC2=WR.getCell(2);
			
			XSSFCell WC3=WR.createCell(3);
			
			String Rn=WC.getStringCellValue();
			String Rd=WC1.getStringCellValue();
			String Rty=WC2.getStringCellValue();
			
			Res=LB.Role(Rn,Rd,Rty);
			System.out.println(Res);
			
			WC3.setCellValue(Res);
			
		}
		
		FileOutputStream Fos=new FileOutputStream("E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\results\\RoleRes.xlsx");
	  WB.write(Fos);
	  WB.close();
		
		
		
		
	}

}
