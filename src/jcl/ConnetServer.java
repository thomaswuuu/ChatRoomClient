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
		System.out.print("�п�J���A��IP��}:");
		IP = inputIP.next();
		Socket client = new Socket(IP,1000); //�إ߫Ȥ�ݳs�u
		if(client.isConnected()) System.out.println("�s�u���\!");
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); //��J
		DataInputStream in2 = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());  //��X	
		
		Moder Md = new Moder();
		
	L1:	while(true)
		{	
			if(flag) //���Mode1
			{
				MF = Md.mode1();
				MdSl = MF.mode;
				out.write(MdSl);
				
				switch(MdSl)
				{
					case 0:  //����
						break L1;
					case 1:  //�s�W�b��
						Adder Ad = new Adder();
						status = Ad.AddAccount(in, in2, out);
						if(!status) continue L1;
						break;
					case 2:  //�n�J
						LogIn Li = new LogIn();
						status = Li.logIntoServer(in, in2, out);		
						if(!status) continue L1;
						flag = MF.flag;
						break;
					default:
						System.out.println("�Э��s���!");
				}
			}
			else  //���Mode2
			{
				MF = Md.mode2();
				MdSl = MF.mode;
				out.write(MdSl);
				
				switch(MdSl)
				{
					case 0:  //�n�X
						flag = MF.flag;
						continue L1;
					case 1:  //�[�ݽu�W�b��			
						CheckContact Check = new CheckContact();
						Check.checkOnline(in2);
						break;
					case 2:  //�@��@���
						SingleChat Sc = new SingleChat();
						Sc.select(client);
						break;
					case 3: //�h�H��ѫ�
						ChatRoom ChRoom = new ChatRoom();
						ChRoom.chatRoom(client);
						break;
					default:
						System.out.println("�Э��s���!");
				}
			}
		
	
		
	}
	}
}
	
