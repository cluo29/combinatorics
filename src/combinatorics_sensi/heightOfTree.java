//heiht OF Tree 1127.1

package combinatorics_sensi;
import java.util.*;
public class heightOfTree {
	public static int check3(String h){
		String p=h;
		int howany=0;
		int e [] = new int [1280] ;
		while(true){
	      	int pointerInString=p.indexOf(";"); 
	      	
	      	if(pointerInString<0)
	      		//every element is analysed in input
	      		break;
	      	howany++;

	      	String nu=p.substring(0, pointerInString);
	      	int inu=Integer.parseInt(nu);
	      	System.out.println(inu);
	      	p=p.substring(1+pointerInString);
		}
		return 0;
	}
	public static int avoideven(int n){
		List<Set> G = new ArrayList<Set>();
		int h [] = new int [1280];
		for (int i=0;i<1000;i++)
		{
			if(i%2==0)
				h[i]=2;
			else
				h[i]=1;
		}
		h[0]=0;
		for(int i=2;i<1000;i++) //start from i
		{
			Set D=new HashSet(); //new a D
			for(int j=1;j<i;j++)
			{
				int z=h[i]+h[j]+i-j; //distance of two leaf
				
				if(z==n)
				{
					//if n or n+1 created
					int flag=0;
					//try another way
					for (int k=0;i-k>1;k++)
					{
						//try another way on i-k
						if(h[i-k]<i-k&&h[i-k]<0.5*n-1.6)
						{
							h[i-k]=h[i-k]+2;
							for (int m=i-k+1;m<1000;m++)
							{ 
								//i-k+1 will be 1
								if(m%2==0)
									h[m]=2;
								else
									h[m]=1;
							}
							
							while(G.size()>i-k-2)//drop i-k-1
							{
								//System.out.println(G.size());
								Set R=G.get(G.size()-1);
								G.remove(R);
								for(int x=0;x<G.size();x++){
									Set y=G.get(x);
									//System.out.println(y);
								}
							}
							j=0;
							flag=1;
							i=i-k;
							break;
						}
					}
					if(flag==0)
					{
						System.out.println(n+"una");
						
						return 0;
					}
					if(flag==1)
					{
						D.clear();
						continue;
					}
					
				}
				if(z-h[i]<n)
					D.add(z-h[i]);
			}
			if(G.contains(D))
			{
				
				for (int m=0;m<i+1;m++)
				{
					System.out.println(m+"="+h[m]);
				}
				System.out.println("oh mama, loop!D=");
				System.out.println(D);
				System.out.println("when n=");
				System.out.println(n);
				System.out.println("when i=");
				System.out.println(i);
				System.out.println("when G=");
				for(int x=0;x<G.size();x++){
					
					Set y=G.get(x);
					System.out.println("i"+(x+2)+y);
				}
				//loop
				return 2;
			}
			else
			{
				G.add(D);
			}
				
		}
		System.out.println(n+"avoidable");
		return 1;
	}

	public static int avoid(int n){
		List<Set> G = new ArrayList<Set>();
		int h [] = new int [1280] ;
		for (int i=0;i<100;i++)
			h[i]=1;
		h[0]=0;
		for(int i=2;i<100;i++) //start from i
		{
			//System.out.println(i+" is checkin");
			Set D=new HashSet(); //new a D
			for(int j=1;j<i;j++)
			{
				int z=h[i]+h[j]+i-j; //distance of two leaf
				
				if(z==n||z==n+1)
				{
					//if n or n+1 created
					int flag=0;
					//try another way
					for (int k=0;i-k>1;k++)
					{
						//try another way on i-k
						if(h[i-k]<i-k&&h[i-k]<0.5*n-0.6)
						{
							h[i-k]++;
							for (int m=i-k+1;m<100;m++)
							{ 
								//i-k+1 will be 1
								h[m]=1;
							}

							/*for (int m=0;m<i+1;m++)
							{
								System.out.println(m+"="+h[m]);
							}*/
							while(G.size()>i-k-2)//drop i-k-1
							{
								//System.out.println(G.size());
								Set R=G.get(G.size()-1);
								G.remove(R);
								for(int x=0;x<G.size();x++){
									Set y=G.get(x);
									//System.out.println(y);
								}
							}
							j=0;
							flag=1;
							i=i-k;
							break;
						}
					}
					if(flag==0)
					{
						System.out.println(n+"una");
						for (int m=0;m<18;m++)
						{
							System.out.println(m+"="+h[m]);
						}
						return 0;
					}
					if(flag==1)
					{
						D.clear();
						continue;
					}
					
				}
				if(z-h[i]<n)
					D.add(z-h[i]);
			}
			if(G.contains(D))
			{
				
				for (int m=0;m<i+1;m++)
				{
					System.out.println(m+"="+h[m]);
				}
				System.out.println("oh mama, loop!D=");
				System.out.println(D);
				System.out.println("when n=");
				System.out.println(n);
				System.out.println("when i=");
				System.out.println(i);
				System.out.println("when G=");
				for(int x=0;x<G.size();x++){
					
					Set y=G.get(x);
					System.out.println("i"+(x+2)+y);
				}
				//loop
				return 2;
			}
			else
			{
				G.add(D);
			}
				
		}
		System.out.println(n+"avoidable");
		return 1;
	}


public static void main(String[] args) {
	///*
	int z=0;
		for (int i=2;i<40;i++)
		{
			z= avoid(i); //check a function input
			//int y=3;
		}
	//*/
	//int pl=check3("16;3;");
	//z= avoid(10); 
}
}
