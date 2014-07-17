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
			System.out.println("連線失敗，請重新輸入!"); 
		}
	}

}
