package combinatorics_sensi;
import java.util.*;
public class Recurrence {
	public static double rec(int y, int i, int j){
		//if(2*i+j>y)
		//	return 0;
		if(i<1||j<0)
			return 0;
		if(y-1==1&&i==1&&j==0)
			return 1;
		else if(y-1==1)
			return 0;
		int left=y;
		double right=0;
		double right1=(y-1+i*(y-1+2-i-j))*rec(y-1,i,j-1);
		right=right+right1;
		double right2=(i*(i+j)-y+1)*rec(y-1,i,j);
		right=right+right2;
		double right3=(y-1+4-2*i-j)*(y-1+3-2*i-j)*rec(y-1,i-1,j-1);
		right=right+right3;
		double right4=(y-1+2*i+j)*(y-1+3-2*i-j)*rec(y-1,i-1,j);
		right=right+right4;
		double right5=(j+1)*(2*y-2+2-j)*rec(y-1,i-1,j+1);
		right=right+right5;
		double right6=(j+1)*(j+2)*rec(y-1,i-1,j+2);
		right=right+right6;
		int cjjawl=0;
		cjjawl=1;
	
		double x=right/(left+0.0);
		int n=y-1;
		System.out.println("n="+y+";i="+i+";j="+j+"; =="+x);
		return x;
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{	
				int y=3;
				int n=y-1;
				
					//if(2*i+j<=y)
						System.out.println("n="+y+";i="+i+";j="+j+"; =="+rec(y,i,j));
				
			}
		}
	}
}
