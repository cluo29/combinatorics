package combinatorics_sensi;

public class Wielandt {
	public static int power2(int n)
	{
		if(n==0)
			return 1;
		else
			return power2(n-1)*2;
	}	
	public static int sum_vector(int z[][])
	{
		int sum=0;
		for(int i=0;i<z.length;i++){
			sum=sum+z[i][0];
		}
		return sum;
	}
	public static int[][] Wie(int x, int y) { //create Wielandt-type matrices
		// initialize that matrix
		int mat [][] = new int [x][x] ;
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				mat [i][j] = 0;
				
			}
		}
		mat [0][x-1] = 1;
		mat [y][x-1] = 1;
		for(int i=1;i<x;i++){
			mat [i][i-1] = 1;
		}
		return mat;
	}
	public static int[][] multiplication(int[][] a, int[][] b) {  //multiplication
		int [][] c = new int[a.length][b[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b[0].length;j++){
				c[i][j]=0;
			}
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b[0].length;j++){
				for(int k=0;k<b.length;k++){
					c[i][j]=c[i][j]+a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}
	public static int[][] zero(int x) { //create zero matrices
		// initialize that matrix
		int mat [][] = new int [x][x];
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				mat [i][j] = 0;
			}
		}
		return mat;
	}
	public static void main(String[] args) {
		int x=5;
		int y=1;
		int w [][] = zero (x);
		int [] v = new int[x*x];
		int [] u = new int[x*x];
		int [][] z = new int[x][1];
		
		//int w [][] = Wie(x,y);
		/* cout
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				System.out.print(w[i][j]);
			}
			System.out.print("\n");
		}
		*/
		/* vector 
		int [][] v = new int[x][1];
		for(int i=0;i<x;i++){
			v[i][0]=0;
		}
		v[0][0]=1;
		*/
		
		for(int c=1;c<power2(x*x);c++){
			int g1 [][] = zero (power2(x));
			int k=c;
			for(int i=0;i<x*x;i++){
				v[i]=k % 2;
				k=k/2;
			}
			for(int i=0;i<x*x;i++){
				u[i]=v[x*x-i-1];
			}
			for(int i=0;i<x*x;i++){ //generate a matrix
				w[i/x][i%x]=u[i];
			}
			int sum1=0;
			int sum2=0;
			int flag=0;
			for(int i=0;i<x;i++){
				sum1=0;
				sum2=0;
				for(int j=0;j<x;j++){
					sum1=sum1+w[i][j];
					sum2=sum2+w[j][i];
				}
				if(sum1*sum2==0)
					flag=1;
			}
			if(flag==1)
				continue;    //line and row not all 0
			//we have a matrix now
			// p =  w * z (2^x)
			for(int i=1;i<power2(x);i++){
				int k2=i;
				for(int j=0;j<x;j++){
					z[j][0]=k2 % 2;
					k2=k2/2;
				}
				int [][] p = new int[x][1];
				p = multiplication(w,z);
				//we have p, create a graph, see circle, and see length
				
				g1 [sum_vector(z)][sum_vector(p)]=1; //from z to p is 1
				
				// then check if there is a circle and see the length
				
				
			}
			
			//print a matrix
			System.out.print(c+"\n");
			for(int i=0;i<x;i++){
				for(int j=0;j<x;j++){
					System.out.print(w[i][j]);
				}
				System.out.print("\n");
			}
			
		}
		
	}
}
