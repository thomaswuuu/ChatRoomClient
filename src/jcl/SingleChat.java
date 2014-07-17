package jcl;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SingleChat 
{
	private boolean isContactExist = false;
	
	public void select(Socket client) throws IOException
	{
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		DataInputStream in = new DataInputStream(client.getInputStream());
		Scanner selectCon = new  Scanner(System.in);
		
		System.out.print("�п�ܳs���H: ");
		String Contact = selectCon.next();
		out.writeBytes(Contact+"\n");	//���ǵ����A���P�_��ֲ��
		isContactExist = in.readBoolean();  //���A���|�^�ǬO�_�s���H�b�u�W
		
		if(isContactExist) 
		{
			System.out.println("�w��A�i�J�@��@��ѼҦ�~!");
			chat(Contact,client);	
		}
		else 
		{
			System.out.println("���H���b�u�W!");
		}

	}
	
	public void chat(String Contact,Socket client) throws IOException
	{
	//	ChatRead CR = new ChatRead(Contact,client);
		Thread ChatR = new Thread( new ChatRead(client,true));
		Thread ChatW = new Thread(new ChatWrite(client,true));
		ChatR.start(); //�������T��
		ChatW.start(); //�ǰe�T�������
		while(ChatR.isAlive() || ChatW.isAlive());
	}
}
