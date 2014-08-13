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
	public int[] live(int[] now,int length) {		//		    0代表維持      位置圖   1 2 3		
		int next[];									//下一回合狀態	3代表生殖                     4 @ 5      
		int pro;									//		    4代表死亡                     6 7 8     
		int count=0;
		next=new int[length*length];
		for (int i=0;i<length*length;i++) next[i]=0;	    //next裡全部填上0
		for (int i=1;i<=length*length;i++) {				//對每一格做確認	
			if (now[i-1]==1) {								//該位置有生物
				if(i==1) {									//位於左上角
					if (now[i]==1) count++;                //位置5確認
					if (now[i-1+length]==1) count++;       //位置7確認
					if (now[i+length]==1) count++;         //位置8確認
				}
				else if (i==length) {						//位於右上角
					if (now[i-2]==1) count++;              //位置4確認
					if (now[i-2+length]==1) count++;       //位置6確認
					if (now[i-1+length]==1) count++;       //位置7確認
				}
				else if (i==(length*length-length+1)){	  //位於左下角
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-length]==1) count++;         //位置3確認
					if (now[i]==1) count++;                //位置5確認
				}
				else if (i==length*length)	{             //位於右下角
					if (now[i-2-length]==1) count++;       //位置1確認
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-2]==1) count++;              //位置4確認
				}
				else if (i>1&&i<length)	 {                 //位於上排
					if (now[i-2]==1) count++;              //位置4確認
					if (now[i]==1) count++;                //位置5確認
					if (now[i-2+length]==1) count++;       //位置6確認
					if (now[i-1+length]==1) count++;       //位置7確認
					if (now[i+length]==1) count++;         //位置8確認
				}
				else if ((i+length-1)%length==0) {         //位於左排
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-length]==1) count++;         //位置3確認
					if (now[i]==1) count++;                //位置5確認
					if (now[i-1+length]==1) count++;       //位置7確認
					if (now[i+length]==1) count++;         //位置8確認
				}
				else if ((i+length)%length==0){           //位於右排
					if (now[i-2-length]==1) count++;       //位置1確認
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-2]==1) count++;              //位置4確認
					if (now[i-2+length]==1) count++;       //位置6確認
					if (now[i-1+length]==1) count++;       //位置7確認
				}
				else if (i>length*length-length+1&&i<length*length){ //位於下排
					if (now[i-2-length]==1) count++;       //位置1確認
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-length]==1) count++;         //位置3確認
					if (now[i-2]==1) count++;              //位置4確認
					if (now[i]==1) count++;                //位置5確認
				}
				else { 										//其餘
					if (now[i-2-length]==1) count++;       //位置1確認
					if (now[i-1-length]==1) count++;       //位置2確認
					if (now[i-length]==1) count++;         //位置3確認
					if (now[i-2]==1) count++;              //位置4確認
					if (now[i]==1) count++;                //位置5確認
					if (now[i-2+length]==1) count++;       //位置6確認
					if (now[i-1+length]==1) count++;       //位置7確認
					if (now[i+length]==1) count++;         //位置8確認
				}			
			}			
			if (count==1) next[i-1]=3;						//附近有1隻，進行生殖
			if (count>2)  next[i-1]=4;  					//附近大於2隻，死亡
			count=0;										//計數歸零
		}
		
		for (int i=1;i<=length*length;i++) {				//對每一格做確認				
			if (next[i-1]==3) {								//狀態為生殖
				pro=0;										
				while(pro==0) {
				if (i>1&&i<length) pro=(int)(Math.random()*5+4);//上排的繁殖位置
				else if (i==1) {							//左上角的繁殖位置
					while(pro==0) {							
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=5;						//附近生物出生位置為5
					else if (pro==2) pro=7;					//附近生物出生位置為7
					else if (pro==3) pro=8;					//附近生物出生位置為8
					}
				}
				else if (i==length) {						//右上角的繁殖位置
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=4;						//附近生物出生位置為4
					else if (pro==2) pro=6;					//附近生物出生位置為6
					else if (pro==3) pro=7;					//附近生物出生位置為7
				}
				else if (i==length*length-length+1) {		//左下角的繁殖位置
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=2;						//附近生物出生位置為2
					else if (pro==2) pro=3;					//附近生物出生位置為3
					else if (pro==3) pro=5;					//附近生物出生位置為5
				}
				else if (i==length*length) {				//右下角的繁殖位置
					pro=(int)(Math.random()*3+1);
					if (pro==1) pro=1;						//附近生物出生位置為1
					else if (pro==2) pro=2;					//附近生物出生位置為2
					else if (pro==3) pro=4;					//附近生物出生位置為4
				}
				else if ((i+length-1)%length==0) {			//左排的繁殖位置
					pro=(int)(Math.random()*5+1);
					if (pro==1) pro=2;						//附近生物出生位置為2
					else if (pro==2) pro=3;					//附近生物出生位置為3
					else if (pro==3) pro=5;					//附近生物出生位置為5
					else if (pro==4) pro=7;					//附近生物出生位置為7
					else if (pro==5) pro=8;					//附近生物出生位置為8
				}
				else if (i%length==0) {						//右排的繁殖位置
					pro=(int)(Math.random()*5+1);
					if (pro==1) pro=1;						//附近生物出生位置為1
					else if (pro==2) pro=2;					//附近生物出生位置為2
					else if (pro==3) pro=4;					//附近生物出生位置為4
					else if (pro==4) pro=6;					//附近生物出生位置為6
					else if (pro==5) pro=7;					//附近生物出生位置為7
				}
				else if (i>length*length-length+1&&i<length*length) pro=(int)(Math.random()*5+1);//下排的繁殖位置
				else pro=(int)(Math.random()*8+1);			//其餘的繁殖位置
				switch (pro) 								//繁殖位置
				{
				case 1:					
					if (next[i-2-length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-2-length]=1;
					break;
				case 2:
					if (next[i-1-length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-1-length]=1;
					break;
				case 3:
					if (next[i-length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-length]=1;
					break;
				case 4:
					if (next[i-2]==4) {						//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-2]=1;
					break;
				case 5:
					if (next[i]==4) {						//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i]=1;
					break;
				case 6:
					if (next[i-2+length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-2+length]=1;
					break;
				case 7:
					if (next[i-1+length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i-1+length]=1;
					break;
				case 8:
					if (next[i+length]==4) {				//如果繁殖位置上有即將死亡生物，重新安排繁殖位置
						pro=0;
						continue;
					}
					now[i+length]=1;
					break;					
				}
				}
			}
			else if(next[i-1]==4) now[i-1]=0; 				//如果狀態為死亡，下回合清空位置
		}
		//for (int i=0;i<length*length;i++) {				//顯示生物狀態
		//	System.out.print(next[i]+" ");	
		//	if((i+1)%length==0) System.out.println();
		//}
		return now;
	}
}
