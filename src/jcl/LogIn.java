package jcl;

import java.io.*;
import java.util.Scanner;

public class LogIn 
{
	private Account acnt = new Account();
	
	private Account login()
	{
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		System.out.println("[--請輸入帳密--]");
		System.out.print("帳號:");	
		acnt.ID = input1.next();
		System.out.print("密碼:");
		acnt.PWD = input2.next();
		
		return acnt;
	}
	
	private void logSucceed()
	{
		System.out.println("登入成功!");
	}
	
	private void logFailed(boolean ID,boolean PWD)
	{
		if(!ID)
			System.out.println("此帳號不存在!");
		else if(!PWD)
			System.out.println("密碼輸入錯誤!");
	}
	
	public boolean logIntoServer(BufferedReader in,DataInputStream in2,DataOutputStream out) throws IOException
	{
		boolean logStatus = true;  //判斷是否登入成功
		boolean isIdExist; //判斷帳號是否存在
		boolean isPwdExist ;  //判斷密碼是否存在
		
		acnt = login();
		out.writeBytes(acnt.ID+"\n");
		out.writeBytes(acnt.PWD+"\n");

		isIdExist = in2.readBoolean();
		isPwdExist = in2.readBoolean();
		
		if(isIdExist && isPwdExist) logSucceed(); //如果帳密都存在，登入成功
		else  
		{
			logFailed(isIdExist,isPwdExist); //如果其中一個不存在，登入失敗
			logStatus=false;  
		}

		return logStatus;				
	}

	
	
	
	
	
}
