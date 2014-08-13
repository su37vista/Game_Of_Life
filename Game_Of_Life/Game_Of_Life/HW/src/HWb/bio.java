/*********************************************************************
 * FileName       	[ bio.java ]
 * PackageName    	[ HWb ]
 * JavaProjectName	[ HW ]
 * Synopsis       	[ This file generates bio.]
 * Author         	[ Chen-Jhih-Fong (Jason) ]
 * Copyright      	[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
*********************************************************************/
package HWb;
import java.util.Random;
public class bio {
	public int[] live(int[] now,int length) {		//		    0�N�����      ��m��   1 2 3		
		int next[];									//�U�@�^�X���A	3�N��ʹ�                     4 @ 5      
		int pro;									//		    4�N���`                     6 7 8     
		int count=0;
		next=new int[length*length];
		for (int i=0;i<length*length;i++) next[i]=0;	    //next�̥�����W0
		for (int i=1;i<=length*length;i++) {				//��C�@�氵�T�{	
			if (now[i-1]==1) {								//�Ӧ�m���ͪ�
				if(i==1) {									//��󥪤W��
					if (now[i]==1) count++;                //��m5�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
					if (now[i+length]==1) count++;         //��m8�T�{
				}
				else if (i==length) {						//���k�W��
					if (now[i-2]==1) count++;              //��m4�T�{
					if (now[i-2+length]==1) count++;       //��m6�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
				}
				else if (i==(length*length-length+1)){	  //��󥪤U��
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-length]==1) count++;         //��m3�T�{
					if (now[i]==1) count++;                //��m5�T�{
				}
				else if (i==length*length)	{             //���k�U��
					if (now[i-2-length]==1) count++;       //��m1�T�{
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-2]==1) count++;              //��m4�T�{
				}
				else if (i>1&&i<length)	 {                 //���W��
					if (now[i-2]==1) count++;              //��m4�T�{
					if (now[i]==1) count++;                //��m5�T�{
					if (now[i-2+length]==1) count++;       //��m6�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
					if (now[i+length]==1) count++;         //��m8�T�{
				}
				else if ((i+length-1)%length==0) {         //��󥪱�
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-length]==1) count++;         //��m3�T�{
					if (now[i]==1) count++;                //��m5�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
					if (now[i+length]==1) count++;         //��m8�T�{
				}
				else if ((i+length)%length==0){           //���k��
					if (now[i-2-length]==1) count++;       //��m1�T�{
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-2]==1) count++;              //��m4�T�{
					if (now[i-2+length]==1) count++;       //��m6�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
				}
				else if (i>length*length-length+1&&i<length*length){ //���U��
					if (now[i-2-length]==1) count++;       //��m1�T�{
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-length]==1) count++;         //��m3�T�{
					if (now[i-2]==1) count++;              //��m4�T�{
					if (now[i]==1) count++;                //��m5�T�{
				}
				else { 										//��l
					if (now[i-2-length]==1) count++;       //��m1�T�{
					if (now[i-1-length]==1) count++;       //��m2�T�{
					if (now[i-length]==1) count++;         //��m3�T�{
					if (now[i-2]==1) count++;              //��m4�T�{
					if (now[i]==1) count++;                //��m5�T�{
					if (now[i-2+length]==1) count++;       //��m6�T�{
					if (now[i-1+length]==1) count++;       //��m7�T�{
					if (now[i+length]==1) count++;         //��m8�T�{
				}			
			}			
			if (count==1) next[i-1]=3;						//����1���A�i��ʹ�
			if (count>2)  next[i-1]=4;  					//����j��2���A���`
			count=0;										//�p���k�s
		}
		
		for (int i=1;i<=length*length;i++) {				//��C�@�氵�T�{				
			if (next[i-1]==3) {								//���A���ʹ�
				pro=0;										
				while(pro==0) {
				if (i>1&&i<length) pro=(int)(Math.random()*5+4);//�W�ƪ��c�ަ�m
				else if (i==1) {							//���W�����c�ަ�m
					while(pro==0) {							
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=5;						//����ͪ��X�ͦ�m��5
					else if (pro==2) pro=7;					//����ͪ��X�ͦ�m��7
					else if (pro==3) pro=8;					//����ͪ��X�ͦ�m��8
					}
				}
				else if (i==length) {						//�k�W�����c�ަ�m
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=4;						//����ͪ��X�ͦ�m��4
					else if (pro==2) pro=6;					//����ͪ��X�ͦ�m��6
					else if (pro==3) pro=7;					//����ͪ��X�ͦ�m��7
				}
				else if (i==length*length-length+1) {		//���U�����c�ަ�m
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=2;						//����ͪ��X�ͦ�m��2
					else if (pro==2) pro=3;					//����ͪ��X�ͦ�m��3
					else if (pro==3) pro=5;					//����ͪ��X�ͦ�m��5
				}
				else if (i==length*length) {				//�k�U�����c�ަ�m
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=1;						//����ͪ��X�ͦ�m��1
					else if (pro==2) pro=2;					//����ͪ��X�ͦ�m��2
					else if (pro==3) pro=4;					//����ͪ��X�ͦ�m��4
				}
				else if ((i+length-1)%length==0) {			//���ƪ��c�ަ�m
					pro=(int)(Math.random()*5+1);
					if (pro==1) pro=2;						//����ͪ��X�ͦ�m��2
					else if (pro==2) pro=3;					//����ͪ��X�ͦ�m��3
					else if (pro==3) pro=5;					//����ͪ��X�ͦ�m��5
					else if (pro==4) pro=7;					//����ͪ��X�ͦ�m��7
					else if (pro==5) pro=8;					//����ͪ��X�ͦ�m��8
				}
				else if (i%length==0) {						//�k�ƪ��c�ަ�m
					pro=(int)(Math.random()*5+1);
					if (pro==1) pro=1;						//����ͪ��X�ͦ�m��1
					else if (pro==2) pro=2;					//����ͪ��X�ͦ�m��2
					else if (pro==3) pro=4;					//����ͪ��X�ͦ�m��4
					else if (pro==4) pro=6;					//����ͪ��X�ͦ�m��6
					else if (pro==5) pro=7;					//����ͪ��X�ͦ�m��7
				}
				else if (i>length*length-length+1&&i<length*length) pro=(int)(Math.random()*5+1);//�U�ƪ��c�ަ�m
				else pro=(int)(Math.random()*8+1);			//��l���c�ަ�m
				switch (pro) 								//�c�ަ�m
				{
				case 1:					
					if (next[i-2-length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-2-length]=1;
					break;
				case 2:
					if (next[i-1-length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-1-length]=1;
					break;
				case 3:
					if (next[i-length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-length]=1;
					break;
				case 4:
					if (next[i-2]==4) {						//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-2]=1;
					break;
				case 5:
					if (next[i]==4) {						//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i]=1;
					break;
				case 6:
					if (next[i-2+length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-2+length]=1;
					break;
				case 7:
					if (next[i-1+length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i-1+length]=1;
					break;
				case 8:
					if (next[i+length]==4) {				//�p�G�c�ަ�m�W���Y�N���`�ͪ��A���s�w���c�ަ�m
						pro=0;
						continue;
					}
					now[i+length]=1;
					break;					
				}
				}
			}
			else if(next[i-1]==4) now[i-1]=0; 				//�p�G���A�����`�A�U�^�X�M�Ŧ�m
		}
		//for (int i=0;i<length*length;i++) {				//��ܥͪ����A
		//	System.out.print(next[i]+" ");	
		//	if((i+1)%length==0) System.out.println();
		//}
		return now;
	}
}
