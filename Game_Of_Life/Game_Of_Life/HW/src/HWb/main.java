/*********************************************************************
 * FileName       	[ main.java ]
 * PackageName    	[ HWb ]
 * JavaProjectName	[ HW ]
 * Synopsis       	[ This file initials all the settings.]
 * Author         	[ Chen-Jhih-Fong (Jason) ]
 * Copyright      	[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
*********************************************************************/
package HWb;
import java.util.Scanner; 
public class main {
	private static Scanner input;
	public static void main(String[] args) {
		int number=0,length=0,times=0,delay=1;
		input = new Scanner(System.in);
		while(number==0) {
			System.out.println("請輸入生物數量");				//各種輸入
			number=input.nextInt();
			System.out.println("環境大小(寬)");
			length=input.nextInt();
			System.out.println("進行回合數");
			times=input.nextInt();
			System.out.println("延遲豪秒數(ms)");
			delay=input.nextInt();
			if (number<0||length<1||times<1) {
				System.out.println("數字輸入有誤!");
				number=0;
			}
			if (number>length*length) {
				System.out.println("生物數量超過環境大小!");
				number=0;
			}
			if (times<1) {
				System.out.println("回合數小於1!");
				number=0;
			}
			if (times<1) {
				System.out.println("延遲時間小於1ms!");
				number=0;
			}
		}
		environment envi=new environment();
		envi.round(number,length,times,delay);	
		
	}
}
