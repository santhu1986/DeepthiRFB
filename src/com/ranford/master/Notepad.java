package com.ranford.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {


	public static void main(String[] args) throws IOException 
	
	{
		
Lib LB=new Lib();
		
		String Res=LB.OpenApp("http://seoemirates.com/Build2/home.aspx");
		System.out.println(Res);
		LB.Login("Admin","Admin");

		
		//Test data file path
		
		String Fpath="E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\testdata\\Role.txt";
		
		//Results file path
		
		String Rpath="E:\\deepthi\\Ranford Project Live\\src\\com\\ranford\\results\\ResRole.txt";
		String SD;
		
		//to get file
		
		FileReader FR=new FileReader(Fpath);
		BufferedReader BR=new BufferedReader(FR);
		String Sread=BR.readLine();
		System.out.println(Sread);
		
		//To Write Data to results file
		
		FileWriter FW=new FileWriter(Rpath);
	  BufferedWriter BW=new BufferedWriter(FW);
	  BW.write(Sread);
	  BW.newLine();
	  
	  //multiple interations  --While loop
	  
	  while ((SD=BR.readLine())!=null)
	  {
		System.out.println(SD);
		
		String SR[]=SD.split("###");
		
		String RN=SR[0];
		String RD=SR[1];
		String RT=SR[2];
		
		 Res=LB.Role(RN,RD,RT);
		 System.out.println(Res);
		 
		BW.write(SD+"%%%"+Res); 
		BW.newLine();
		 
	}
	  BW.close();
	  BR.close();
	}

}
