package jcl;

import java.io.*;
import java.net.Socket;

 public class ChatRead implements Runnable
{
	private String ReadMessage = new String();
	private Socket client = new Socket();
	private boolean MessageCount = true;
	private boolean SingleChatFlag = false;
	
	public ChatRead()
	{		
	}
	
	public ChatRead(Socket client,boolean flag)
	{
		this.client = client;
		this.SingleChatFlag = flag;
	}
	
	private void serverMessageNo()
	{
		System.out.println("(伺服器訊息) 對方尚未進入一對一聊天模式，請稍候...");
	}
	private void serverMessageYes()
	{
		System.out.println("(伺服器訊息) 對方已進入一對一模式，可開始輸入訊息。");
		MessageCount = false;
	}
	
	public void run() 
	{
		if(SingleChatFlag)
		{
			do
			{
				try 
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); //輸入
					ReadMessage = in.readLine();
					if(ReadMessage.equals("no") && MessageCount) serverMessageNo();
					else if(MessageCount) serverMessageYes();			
					else if(!ReadMessage.equals("no"))
						System.out.println(ReadMessage);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
			}while(!ReadMessage.equals("I say:exit"));
		}
		else
		{
			do
			{				
				try
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					ReadMessage = in.readLine();
					System.out.println(ReadMessage);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 		
			}while(!ReadMessage.equals("I say:0"));
			
		}
	}
	
}

