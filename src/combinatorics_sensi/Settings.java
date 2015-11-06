package combinatorics_sensi;

import java.util.ArrayList;
import java.util.List;


public class Settings {
	public static int mods(int square, int linear, int cons, int mod_linear, int mod_cons)
	{
		for(int i=0;i<30;i++){
			int z=(square*i*i+linear*i+cons) % (mod_linear*i+mod_cons);
					System.out.println(z);
		}
		return 0;
	}
	public static int power2(int n)
	{
		if(n==0)
			return 1;
		else
			return power2(n-1)*2;
	}
	public static int exam(String input)
	{
		int x [] = new int [32] ;
		int S=0;
		int f=-1;
		int senc=0;
		for(int i=0;i<input.length();i++){
			x[i]=Integer.parseInt(input.substring(i,i+1));
		}
		for(int i=0;i<input.length();i++){
			S=S+i*x[i];
		}
		S=S%input.length();
		f=x[S];
		
		for(int j=0;j<input.length();j++){
			int S2=0;
			//flip
			x[j]= (x[j]+1)%2;
			for(int i=0;i<input.length();i++){
					S2=S2+i*x[i];
			}
			
			S2=S2%input.length();
			
			if(f!=x[S2]) //change
			{
				senc=senc+1;
			}
			// flip back
			x[j]= (x[j]+1)%2;
			
		}
		System.out.println(input.length());
		System.out.println(senc);
			return 1;
		
	}
	
	
	public static int sx(int amount_of_n, int amount_of_variables ) {
		int x [] = new int [amount_of_variables] ;  //rev
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int Total_Sen=0;
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
		for(int i=0;i<amount_of_variables;i++){
			x[i]=k % 2;
			k=k/2;
			cont[i]=0;
		}
		for(int i=0;i<amount_of_variables;i++){
			y[i]=x[amount_of_variables-1-i];
			
		}
		
		for(int i=0;i<amount_of_variables;i++){
			S=S+i*y[i];
		}
		S=S%amount_of_variables;
		f[c]=y[S];
	  }
		for(int c=0;c<amount_of_n;c++){
			
			senc [c]=0;
			int k=c;
		
		for(int i=0;i<amount_of_variables;i++){
			x[i]=k % 2;
			k=k/2;
		}
		for(int i=0;i<amount_of_variables;i++){
			y[i]=x[amount_of_variables-1-i];
			
		}
		for(int j=0;j<amount_of_variables;j++){
			int S=0;
			//flip
			y[j]= (y[j]+1)%2;
			for(int i=0;i<amount_of_variables;i++){
					S=S+i*y[i];
			}
			S=S%amount_of_variables;
			f2[c]=y[S];
			
			
			
			if(f2[c]!=f[c]) //change
			{
				senc[c]=senc[c]+1;
				Total_Sen=Total_Sen+1;
				cont[j]=cont[j]+1;
			}
			// flip back
			y[j]= (y[j]+1)%2;
		}
	  }
		
		for(int c=0;c<amount_of_n;c++){ //find max
			//System.out.println(senc[c]);
			if(senc[c]>Max)
			{
				//System.out.println(c);
				//cjjawl=c;
				Max=senc[c];
			}
			if(senc[c]<Min)
			{
				//System.out.println(c);
				
				Min=senc[c];
			}
			
			//for 15
			if(senc[c]==-1)
			{
				int k=c;
				int x1 [] = new int [32] ;
				
				for(int i=0;i<amount_of_variables;i++){
					x1[i]=k % 2;
					k=k/2;
					//System.out.println(x[i]); x[amount_of_variables-1-i]
				}
				for(int i=0;i<amount_of_variables;i++){
			
					//System.out.print(x1[amount_of_variables-1-i]); 
				}
				//System.out.println("--");
				
			}
			//for prime
			if(senc[c]==0)
			{
				int k=c;
				int x1 [] = new int [32] ;
				
				for(int i=0;i<amount_of_variables;i++){
					x1[i]=k % 2;
					k=k/2;
					//System.out.println(x[i]); x[amount_of_variables-1-i]
				}
				for(int i=0;i<amount_of_variables;i++){
			
					System.out.print(x1[amount_of_variables-1-i]); 
				}
				System.out.println("--");
				
			}
		}
			
			System.out.println("Vars = "+amount_of_variables);
			//System.out.println("Max = "+Max);
			
			System.out.println(Min);
			//for(int i=0;i<amount_of_variables;i++)
			//System.out.println("Contri = " +cont[amount_of_variables-1-i]);
			//System.out.println("ASen = "+Total_Sen*1.0/(amount_of_n));
			//System.out.println(Total_Sen*1.0/(amount_of_n*amount_of_variables));
			
			
			return 0;
	}
	
	public static int fc(int amount_of_n, int amount_of_variables ) {
		int x [] = new int [amount_of_variables] ;  //Fourier coefficients
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int fPlusUx[]= new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int odd=0;
		int even=0;
		int Total_Sen=0;
		int u []= new int [amount_of_variables] ; 
		
		for(int i=0;i<amount_of_variables;i++){
			u[i]=(int) (Math.random()*2); //random u
	
		}
		
			System.out.print("u = ");
		
		for(int i=0;i<amount_of_variables;i++){
		
				System.out.print(u[i]);
				
			
		}
		
		
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
			for(int i=0;i<amount_of_variables;i++){
				x[i]=k % 2;
				k=k/2;
				cont[i]=0;
			}
			for(int i=0;i<amount_of_variables;i++){
				y[i]=x[amount_of_variables-1-i];
				
			}
			
			for(int i=0;i<amount_of_variables;i++){
				S=S+i*y[i];
			}
			S=S%amount_of_variables;
			f[c]=y[S];
			fPlusUx[c]=f[c];
			for(int i=0;i<amount_of_variables;i++){
				if(u[i]==1)
				{
					fPlusUx[c]=fPlusUx[c]+y[i];
				}
			}
			if(fPlusUx[c]%2==1)
				odd++;
			else
				even++;
	  }
		
		


		    System.out.println("");
			System.out.println("n = "+amount_of_variables);
			System.out.println("result= "+(even-odd));
			
			return (even-odd);
	}
	
	public static int fc2(int amount_of_n, int amount_of_variables, int br) { //brute force one
		int x [] = new int [amount_of_variables] ;  //Fourier coefficients
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int fPlusUx[]= new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int odd=0;
		int even=0;
		int Total_Sen=0;
		int u []= new int [amount_of_variables] ; 
		int u2 []= new int [amount_of_variables] ; 
		int k2=br;
		for(int i=0;i<amount_of_variables;i++){
			u2[i]=k2 % 2;
			k2=k2/2;
	
		}
		
		for(int i=0;i<amount_of_variables;i++){
			u[i]=u2[amount_of_variables-1-i];
			
		}
		
			//System.out.print("u = ");
		
		for(int i=0;i<amount_of_variables;i++){
		
			//	System.out.print(u[i]);
				
			
		}
		
		
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
			for(int i=0;i<amount_of_variables;i++){
				x[i]=k % 2;
				k=k/2;
				cont[i]=0;
			}
			for(int i=0;i<amount_of_variables;i++){
				y[i]=x[amount_of_variables-1-i];
				
			}
			
			for(int i=0;i<amount_of_variables;i++){
				S=S+i*y[i];
			}
			S=S%amount_of_variables;
			f[c]=y[S];
			fPlusUx[c]=f[c];
			for(int i=0;i<amount_of_variables;i++){
				if(u[i]==1)
				{
					fPlusUx[c]=fPlusUx[c]+y[i];
				}
			}
			if(fPlusUx[c]%2==1)
				odd++;
			else
				even++;
	  }
		
		


		  //  System.out.println("");
			//System.out.println("n = "+amount_of_variables);
			//System.out.println("result= "+(even-odd));
			
			return (even-odd);
	}
	
	public static int fc3(int amount_of_n, int amount_of_variables, int br, int ma) { //brute force one
		int x [] = new int [amount_of_variables] ;  //Fourier coefficients
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int fPlusUx[]= new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int odd=0;
		int even=0;
		int Total_Sen=0;
		int u []= new int [amount_of_variables] ; 
		int u2 []= new int [amount_of_variables] ; 
		int k2=br;
		for(int i=0;i<amount_of_variables;i++){
			u2[i]=k2 % 2;
			k2=k2/2;
	
		}
		
		for(int i=0;i<amount_of_variables;i++){
			u[i]=u2[amount_of_variables-1-i];
			//u[i]=0;
		}
		
			//System.out.print("u = ");
		
		
		
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
			for(int i=0;i<amount_of_variables;i++){
				x[i]=k % 2;
				k=k/2;
				cont[i]=0;
			}
			for(int i=0;i<amount_of_variables;i++){
				y[i]=x[amount_of_variables-1-i];
				
			}
			
			for(int i=0;i<amount_of_variables;i++){
				S=S+i*y[i];
			}
			S=S%amount_of_variables;
			f[c]=y[S];
			fPlusUx[c]=f[c];
			for(int i=0;i<amount_of_variables;i++){
				if(u[i]==1)
				{
					fPlusUx[c]=fPlusUx[c]+y[i];
				}
			}
			if(fPlusUx[c]%2==1)
				odd++;
			else
				even++;
	  }
		
		int ab=0;
		for(int i=0;i<amount_of_variables;i++){
			if(ma==(even-odd))
			{
				System.out.print(u[i]);//=u2[amount_of_variables-1-i];
				ab=1;
			}
			if(ma==(odd-even))
			{
				System.out.print(u[i]);//=u2[amount_of_variables-1-i];
				ab=1;
			}
			
		}
		if(ab==1)
			System.out.println("");
		  //  System.out.println("");
			//System.out.println("n = "+amount_of_variables);
		//System.out.println("result= "+(even-odd));
			
			return (even-odd);
	}
	public static int fc4(int amount_of_n, int amount_of_variables, int br) { //brute force one
		int x [] = new int [amount_of_variables] ;  //Fourier coefficients
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int fPlusUx[]= new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int odd=0;
		int even=0;
		int Total_Sen=0;
		int u []= new int [amount_of_variables] ; 
		int u2 []= new int [amount_of_variables] ; 
		int k2=br;
		for(int i=0;i<amount_of_variables;i++){
			u2[i]=k2 % 2;
			k2=k2/2;
	
		}
		
		for(int i=0;i<amount_of_variables;i++){
			u[i]=u2[amount_of_variables-1-i];
			
		} //all vector u here
		
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
			for(int i=0;i<amount_of_variables;i++){
				x[i]=k % 2;
				k=k/2;
				cont[i]=0;
			}
			for(int i=0;i<amount_of_variables;i++){
				y[i]=x[amount_of_variables-1-i];
				
			}
			
			for(int i=0;i<amount_of_variables;i++){
				S=S+i*y[i];
			}
			S=S%amount_of_variables;
			if(S!=0)
				continue;
			int cjjawl=0;
			for(int i=0;i<amount_of_variables;i++){
			
				cjjawl=cjjawl+y[i]*u[i];
				
			}
			if(cjjawl%2==1)
				odd++;
			else
				even++;
	  }
		
		//System.out.println("result= "+(even-odd));
			
			return (even-odd);
	}
	
	public static int fc5(int amount_of_n, int amount_of_variables, int br, int sig) { //brute force one
		int x [] = new int [amount_of_variables] ;  //Fourier coefficients
		int y [] = new int [amount_of_variables] ; 
		int f [] = new int [amount_of_n] ; 
		int f2 [] = new int [amount_of_n] ; 
		int senc [] = new int [amount_of_n] ; 
		int fPlusUx[]= new int [amount_of_n] ; 
		int cont []= new int [amount_of_variables] ; 
		int Max=0;
		int Min=amount_of_variables;
		int odd=0;
		int even=0;
		int Total_Sen=0;
		int u []= new int [amount_of_variables] ; 
		int u2 []= new int [amount_of_variables] ; 
		int k2=br;
		for(int i=0;i<amount_of_variables;i++){
			u2[i]=k2 % 2;
			k2=k2/2;
	
		}
		
		for(int i=0;i<amount_of_variables;i++){
			u[i]=u2[amount_of_variables-1-i];
			
		} //all vector u here
		
		for(int c=0;c<amount_of_n;c++){
			f[c]=-1;
			int S=0;
			int k=c;
			for(int i=0;i<amount_of_variables;i++){
				x[i]=k % 2;
				k=k/2;
				cont[i]=0;
			}
			for(int i=0;i<amount_of_variables;i++){
				y[i]=x[amount_of_variables-1-i];
				
			}
			
			for(int i=0;i<amount_of_variables;i++){
				S=S+i*y[i];
			}
			S=S%amount_of_variables;
			if(S!=sig-1)
				continue;
			int cjjawl=0;
			for(int i=0;i<amount_of_variables;i++){
			
				cjjawl=cjjawl+y[i]*u[i];
				
			}
			if(cjjawl%2==1)
				odd++;
			else
				even++;
	  }
		
		//System.out.println("result= "+(even-odd));
			
			return (even-odd);
	}
	
	public static void main(String[] args) {
		
		//int power=8;
		//int z=sx(power2(power),power);
		/*
		int MaxOfPower = 24; //bits of bool, 2^this = above;
		
		
		for(int c=3;c<MaxOfPower+4;c++){ //find max
			int z=fc(power2(c),c);
			
		}
		*/
		
		/*
		int MaxOfPower = 26; //bits of bool, 2^this = above;
		int max=0;
		for(int c=0;c<99;c++){ //find max
			int z=fc(power2(26),26);
			if(z>max)
				max=z;
		}
		System.out.println("max= "+max);
		*/
		
		/*
		System.out.println("16");
		System.out.println("");
		for(int big=16;big<17;big++)
		{//16=4336 15=5200 14=1412 13=744 12=856 11=300 10=232
			int max=0;
			for(int c=0;c<power2(big);c++){ //find max
				int z=fc3(power2(big),big,c,4336);
				if(z>max)
					max=z;
			}
			//System.out.println(big+"max= "+max);
		}
		
		*/
		/*
		for(int big=1;big<27;big++)
		{
			int max=0;
			for(int c=0;c<power2(big);c++){ //find max
				int z=fc2(power2(big),big,c);
				//System.out.println(z);
				if(z<0)
					z=-1*z;
				if(z>max)
					max=z;
			}
			System.out.println(big+"max= "+max);
		}*/
		
		
		
		/*
		int sig=2;
		for(int big=21;big<27;big++)
		{
			int max=0;
			for(int c=power2(big)/2;c<power2(big);c++){ //find max
				int z=fc5(power2(big),big,c,sig);
				System.out.println(z);
				if(z<0)
					z=-1*z;
				if(z>max)
					max=z;
			}
			System.out.println(big+"max= "+max);
		}
		
		*/
		
		int z= exam("100111111011111"); //check a function input
		//System.out.println(z);
		//int z= mods(27,68,40,9,12);
		
		
		
		int MaxOfPower = 24; //bits of bool, 2^this = above;
		
		
		for(int c=1;c<MaxOfPower+1;c++){ //find max
			int z1=sx(power2(c),c);
			
		}
		  
				
		
	 
		
	}
}
		
