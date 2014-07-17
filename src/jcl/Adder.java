package jcl;

import java.io.*;
import java.util.Scanner;

public class Adder 
{
	//��J�b���K�X�çP�_�O�_�ŦX�榡
	private String AddID()
	{
		Scanner input1 = new Scanner(System.in);
		String ID = new String();
		
		System.out.println("[---�b�b����J6�� 0�i�^���ܼҦ�---] ");
		System.out.print("�п�J�b��(��6~10�r�A�^�Ƭҥi):");	
		String tempId = input1.next();
				
		if(tempId.matches("[A-Za-z0-9]{6,10}"))
			ID = tempId;
		else 
		{
			System.out.println("��J�榡���~�A�Э��s��J!");
			ID = AddID();	
		}
		
		return ID;
	}
	
	
	private String AddPassword(String ID)
	{
		Scanner input2 = new Scanner(System.in);
		String PWD = new String();
		
		System.out.print("�п�J�K�X(���Ʀr6~10�r):");
		String tempPwd = input2.next();
				
		
		if(tempPwd.matches("[0-9]{6,10}"))
			PWD = tempPwd;
		else
		{
			System.out.println("��J�榡���~�A�Э��s��J!");
			System.out.println("�b��:" + ID);
			PWD = AddPassword(ID);
		}
		
		return PWD;
	}
	
	private void MessageIDAddsuccess()
	{
		System.out.println("�b���s�W���\!");
	}
	
	private void MessageIDAddfailed()
	{
		System.out.println("��J�b���w�ϥΡA�Э��s��J!");
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
			if(acnt.ID.equals("000000"))  //��J6��0�^���ܼҦ�
			{
				addStatus = false;
				break L1; 
			}
			
			acnt.PWD = AddPassword(acnt.ID);
			out.writeBytes(acnt.PWD+"\n");
		
			Message = in2.readBoolean(); //�����O�_�s�W���\
			
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



