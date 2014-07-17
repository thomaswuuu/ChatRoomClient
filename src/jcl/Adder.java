package jcl;

import java.io.*;
import java.util.Scanner;

public class Adder 
{
	//輸入帳號密碼並判斷是否符合格式
	private String AddID()
	{
		Scanner input1 = new Scanner(System.in);
		String ID = new String();
		
		System.out.println("[---在帳號輸入6個 0可回到選擇模式---] ");
		System.out.print("請輸入帳號(限6~10字，英數皆可):");	
		String tempId = input1.next();
				
		if(tempId.matches("[A-Za-z0-9]{6,10}"))
			ID = tempId;
		else 
		{
			System.out.println("輸入格式錯誤，請重新輸入!");
			ID = AddID();	
		}
		
		return ID;
	}
	
	
	private String AddPassword(String ID)
	{
		Scanner input2 = new Scanner(System.in);
		String PWD = new String();
		
		System.out.print("請輸入密碼(限數字6~10字):");
		String tempPwd = input2.next();
				
		
		if(tempPwd.matches("[0-9]{6,10}"))
			PWD = tempPwd;
		else
		{
			System.out.println("輸入格式錯誤，請重新輸入!");
			System.out.println("帳號:" + ID);
			PWD = AddPassword(ID);
		}
		
		return PWD;
	}
	
	private void MessageIDAddsuccess()
	{
		System.out.println("帳號新增成功!");
	}
	
	private void MessageIDAddfailed()
	{
		System.out.println("輸入帳號已使用，請重新輸入!");
	}

	public boolean AddAccount(BufferedReader in,DataInputStream in2,DataOutputStream out) throws IOException
	{
		Account acnt = new Account();
		boolean Message = true;
		boolean addStatus = true;
		
	L1:	while(true)
		{
			acnt.ID = AddID();
			out.writeBytes(acnt.ID+"\n");			
			if(acnt.ID.equals("000000"))  //輸入6個0回到選擇模式
			{
				addStatus = false;
				break L1; 
			}
			
			acnt.PWD = AddPassword(acnt.ID);
			out.writeBytes(acnt.PWD+"\n");
		
			Message = in2.readBoolean(); //接收是否新增成功
			
			if(Message)
			{		
				MessageIDAddsuccess();
				break;
			}
			else
			{
				MessageIDAddfailed();
			}
		}
		return addStatus;
	}
	
}



