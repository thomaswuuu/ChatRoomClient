package jcl;

import java.util.Scanner;

public class Moder 
{	
	public ModeFlag mode1()
	{
		ModeFlag M1 = new ModeFlag();
		Scanner Md1 = new Scanner(System.in);			
		System.out.println("0.����  1.�s�W�b�K 2.�n�J");
		System.out.print("�п�ܼҦ�: ");
		M1.mode = Md1.nextInt();
		M1.flag = false;
		
		return M1;		
	}
	
	public ModeFlag mode2()
	{
		ModeFlag M2 = new ModeFlag();
		Scanner Md2 = new Scanner(System.in);			
		System.out.println("0.�n�X   1.�[�ݤW�u�b��   2.�@��@���  3.�h�H��ѫ�)");
		System.out.print("�п�ܼҦ�: ");
		M2.mode = Md2.nextInt();
		M2.flag = true;
		
		return M2;		
	}
	
}
