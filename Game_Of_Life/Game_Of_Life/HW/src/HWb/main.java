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
			System.out.println("�п�J�ͪ��ƶq");				//�U�ؿ�J
			number=input.nextInt();
			System.out.println("���Ҥj�p(�e)");
			length=input.nextInt();
			System.out.println("�i��^�X��");
			times=input.nextInt();
			System.out.println("���𻨬��(ms)");
			delay=input.nextInt();
			if (number<0||length<1||times<1) {
				System.out.println("�Ʀr��J���~!");
				number=0;
			}
			if (number>length*length) {
				System.out.println("�ͪ��ƶq�W�L���Ҥj�p!");
				number=0;
			}
			if (times<1) {
				System.out.println("�^�X�Ƥp��1!");
				number=0;
			}
			if (times<1) {
				System.out.println("����ɶ��p��1ms!");
				number=0;
			}
		}
		environment envi=new environment();
		envi.round(number,length,times,delay);	
		
	}
}
