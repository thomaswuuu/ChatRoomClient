package jcl;

import java.util.Scanner;

public class Moder 
{	
	public ModeFlag mode1()
	{
		ModeFlag M1 = new ModeFlag();
		Scanner Md1 = new Scanner(System.in);			
		System.out.println("0.結束  1.新增帳密 2.登入");
		System.out.print("請選擇模式: ");
		M1.mode = Md1.nextInt();
		M1.flag = false;
		
		return M1;		
	}
	
	public ModeFlag mode2()
	{
		ModeFlag M2 = new ModeFlag();
		Scanner Md2 = new Scanner(System.in);			
		System.out.println("0.登出   1.觀看上線帳號   2.一對一聊天  3.多人聊天室)");
		System.out.print("請選擇模式: ");
		M2.mode = Md2.nextInt();
		M2.flag = true;
		
		return M2;		
	}
	
}
