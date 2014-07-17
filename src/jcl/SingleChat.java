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
		
		System.out.print("請選擇連絡人: ");
		String Contact = selectCon.next();
		out.writeBytes(Contact+"\n");	//先傳給伺服器判斷跟誰聊天
		isContactExist = in.readBoolean();  //伺服器會回傳是否連絡人在線上
		
		if(isContactExist) 
		{
			System.out.println("歡迎你進入一對一聊天模式~!");
			chat(Contact,client);	
		}
		else 
		{
			System.out.println("此人不在線上!");
		}

	}
	
	public void chat(String Contact,Socket client) throws IOException
	{
	//	ChatRead CR = new ChatRead(Contact,client);
		Thread ChatR = new Thread( new ChatRead(client,true));
		Thread ChatW = new Thread(new ChatWrite(client,true));
		ChatR.start(); //接收對方訊息
		ChatW.start(); //傳送訊息給對方
		while(ChatR.isAlive() || ChatW.isAlive());
	}
}
