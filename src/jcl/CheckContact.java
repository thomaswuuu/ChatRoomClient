package jcl;

import java.io.DataInputStream;
import java.io.IOException;

public class CheckContact 
{
	public void checkOnline(DataInputStream in) throws IOException
	{
		String online = new String();  
		StringBuffer Sb =new StringBuffer();
		
		while(true)   //接收線上帳號的資料
		{			
			char x = (char) in.read();
			if(x==';') break;
			Sb.append(x);
		}		
		online = Sb.toString();
		
		if(!online.isEmpty())
		{
			System.out.println("[---在線成員---]\n"+ online);
		}
		
	}	
}
