package jcl;

import java.io.DataInputStream;
import java.io.IOException;

public class CheckContact 
{
	public void checkOnline(DataInputStream in) throws IOException
	{
		String online = new String();  
		StringBuffer Sb =new StringBuffer();
		
		while(true)   //�����u�W�b�������
		{			
			char x = (char) in.read();
			if(x==';') break;
			Sb.append(x);
		}		
		online = Sb.toString();
		
		if(!online.isEmpty())
		{
			System.out.println("[---�b�u����---]\n"+ online);
		}
		
	}	
}
