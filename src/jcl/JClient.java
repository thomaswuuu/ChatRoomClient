package jcl;

public class JClient 
{
	public static void main(String argv[])
	{
		
		try
		{
			ConnetServer conserver = new ConnetServer();
			conserver.connect();
		}
		catch(Exception e)
		{
			System.out.println("�s�u���ѡA�Э��s��J!"); 
		}
	}

}
