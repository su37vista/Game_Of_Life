/*********************************************************************
 * FileName       	[ environment.java ]
 * PackageName    	[ HWb ]
 * JavaProjectName	[ HW ]
 * Synopsis       	[ This file sets the environment and shows new generations.]
 * Author         	[ Chen-Jhih-Fong (Jason) ]
 * Copyright      	[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
*********************************************************************/
package HWb;
import java.util.Random;
public class environment {
	public void round (int number,int length,int times,int delay)  {
		bio bi=new bio();
		int i=0;
		int[] now;
		now = new int[length*length];
		for (i=0;i<length*length;i++)  now[i]=0;				//現在狀態全部為0
		Random rand = new Random();								
		i=0;
		while(i!=number) {
			int a=(int)(Math.random()*length*length);			//隨機位置產生生物
			if (now[a]==1) continue;							//假如位置上已經有生物，再跑一次亂數
			else if  (now[a]==0){								
				now[a]=1;
				i++;
			}			
		}
		for (int a=0;a<times;a++) {								//進行回合數
			System.out.printf("第%d回合\n",a+1);					
			for (i=0;i<length*length;i++) {						//繪製表格
				if (now[i]==0) System.out.print("  ");
				if (now[i]==1) System.out.print("@ ");			
				if((i+1)%length==0) System.out.println();
			}
			for(i=0;i<length;i++) System.out.print("- ");
			System.out.println();
			now=bi.live(now, length);							//下一回合更新
			try {
				Thread.sleep(delay);     						//延遲秒
			} 
			catch(InterruptedException e) {
			}
		}
	}
}
