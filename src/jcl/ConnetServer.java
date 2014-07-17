package jcl;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ConnetServer 
{
	private boolean flag = true; //mode flag
	private boolean status;
	private int MdSl; //mode select
	private ModeFlag MF = new ModeFlag();

	
	public void connect() throws IOException
	{
		Scanner inputIP = new Scanner(System.in);
		String IP = new String();
		System.out.print("請輸入伺服器IP位址:");
		IP = inputIP.next();
		Socket client = new Socket(IP,1000); //建立客戶端連線
		if(client.isConnected()) System.out.println("連線成功!");
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); //輸入
		DataInputStream in2 = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());  //輸出	
		
		Moder Md = new Moder();
		
	L1:	while(true)
		{	
			if(flag) //選擇Mode1
			{
				MF = Md.mode1();
				MdSl = MF.mode;
				out.write(MdSl);
				
				switch(MdSl)
				{
					case 0:  //結束
						break L1;
					case 1:  //新增帳號
						Adder Ad = new Adder();
						status = Ad.AddAccount(in, in2, out);
						if(!status) continue L1;
						break;
					case 2:  //登入
						LogIn Li = new LogIn();
						status = Li.logIntoServer(in, in2, out);		
						if(!status) continue L1;
						flag = MF.flag;
						break;
					default:
						System.out.println("請重新選擇!");
				}
			}
			else  //選擇Mode2
			{
				MF = Md.mode2();
				MdSl = MF.mode;
				out.write(MdSl);
				
				switch(MdSl)
				{
					case 0:  //登出
						flag = MF.flag;
						continue L1;
					case 1:  //觀看線上帳號			
						CheckContact Check = new CheckContact();
						Check.checkOnline(in2);
						break;
					case 2:  //一對一聊天
						SingleChat Sc = new SingleChat();
						Sc.select(client);
						break;
					case 3: //多人聊天室
						ChatRoom ChRoom = new ChatRoom();
						ChRoom.chatRoom(client);
						break;
					default:
						System.out.println("請重新選擇!");
				}
			}
		
	
		
	}
	}
}
	
