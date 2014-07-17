package jcl;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatWrite implements Runnable
{
	private String WriteMessage = new String();
	private Socket client = new Socket();
	private boolean SingleChatFlag = false;
	
	public ChatWrite()
	{		
	}
	
	public ChatWrite(Socket client,boolean flag)
	{
		this.client = client;
		this.SingleChatFlag = flag;
	}
	public void run() 
	{	
		Scanner input = new Scanner(System.in);	
		if(SingleChatFlag)
		{
			System.out.println("輸入 exit 可結束對話 。");	
			do
			{	
				try {
					WriteMessage = input.next();
					DataOutputStream out = new DataOutputStream(client.getOutputStream());
					out.writeBytes(WriteMessage+"\n");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}while(!WriteMessage.equals("exit"));
		}
		else
		{
			do
			{	
				try {
					WriteMessage = input.next();
					DataOutputStream out = new DataOutputStream(client.getOutputStream());
					out.writeBytes(WriteMessage+"\n");
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}while(!WriteMessage.equals("0"));
		}
	}

}
