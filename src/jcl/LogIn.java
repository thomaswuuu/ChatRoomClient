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
		
		System.out.println("[--�п�J�b�K--]");
		System.out.print("�b��:");	
		acnt.ID = input1.next();
		System.out.print("�K�X:");
		acnt.PWD = input2.next();
		
		return acnt;
	}
	
	private void logSucceed()
	{
		System.out.println("�n�J���\!");
	}
	
	private void logFailed(boolean ID,boolean PWD)
	{
		if(!ID)
			System.out.println("���b�����s�b!");
		else if(!PWD)
			System.out.println("�K�X��J���~!");
	}
	
	public boolean logIntoServer(BufferedReader in,DataInputStream in2,DataOutputStream out) throws IOException
	{
		boolean logStatus = true;  //�P�_�O�_�n�J���\
		boolean isIdExist; //�P�_�b���O�_�s�b
		boolean isPwdExist ;  //�P�_�K�X�O�_�s�b
		
		acnt = login();
		out.writeBytes(acnt.ID+"\n");
		out.writeBytes(acnt.PWD+"\n");

		isIdExist = in2.readBoolean();
		isPwdExist = in2.readBoolean();
		
		if(isIdExist && isPwdExist) logSucceed(); //�p�G�b�K���s�b�A�n�J���\
		else  
		{
			logFailed(isIdExist,isPwdExist); //�p�G�䤤�@�Ӥ��s�b�A�n�J����
			logStatus=false;  
		}

		return logStatus;				
	}

	
	
	
	
	
}
