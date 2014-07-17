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
		System.out.println("(���A���T��) ���|���i�J�@��@��ѼҦ��A�еy��...");
	}
	private void serverMessageYes()
	{
		System.out.println("(���A���T��) ���w�i�J�@��@�Ҧ��A�i�}�l��J�T���C");
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
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); //��J
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

