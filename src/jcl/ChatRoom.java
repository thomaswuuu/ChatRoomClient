package jcl;

import java.net.Socket;

public class ChatRoom
{
	public void chatRoom(Socket client)
	{
		System.out.println("0.離開聊天室  1.看聊天室有誰");
		Thread ChR = new Thread(new ChatRead(client,false));
		Thread ChW = new Thread(new ChatWrite(client,false));
		ChR.start();
		ChW.start();
		while(ChR.isAlive()||ChW.isAlive());
	}
	
}
