package jcl;

import java.net.Socket;

public class ChatRoom
{
	public void chatRoom(Socket client)
	{
		System.out.println("0.���}��ѫ�  1.�ݲ�ѫǦ���");
		Thread ChR = new Thread(new ChatRead(client,false));
		Thread ChW = new Thread(new ChatWrite(client,false));
		ChR.start();
		ChW.start();
		while(ChR.isAlive()||ChW.isAlive());
	}
	
}
