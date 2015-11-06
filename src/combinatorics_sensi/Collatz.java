package combinatorics_sensi;

public class Collatz {

	
		
		public static void main(String[] args) {
			int max=0;

			for(int i=3;i<113382;i++)
			{
				int k=0;
				int n=i;
						while(true){
							k=k+1;
						if(n%2==1)
						{
							n=3*n+1;
							n=n/2;
						}
						else
						{
							n=n/2;
						}
						if(n<3)
							break;
						
					}
						if(k>max)
						{
							max=k;
							System.out.println(i);
						}
				
				
			}
		}
		}

	

