package ha;

import java.util.*;

public class SequencePeriod {
	public static int power2(int n)
	{
		if(n==0)
			return 1;
		else
			return power2(n-1)*2;
	}
//List<Integer> sequenceOfPlayerActions = new ArrayList<Integer>();
	public static List<Integer> sx(int amount_of_variables,List<Integer> sequenceOfPlayerActions) {
		int S=0;
		int y [] = new int [amount_of_variables] ; 
		for(int i=0;i<amount_of_variables;i++){
			y[i]=sequenceOfPlayerActions.get(i);
		}
		
		for(int i=0;i<amount_of_variables;i++){
			S=S+i*y[i];
		}
		S=S%amount_of_variables;
		List<Integer> sequenceOfPlayerActions2 = new ArrayList<Integer>();
		for(int i=0;i<amount_of_variables-1;i++){
			sequenceOfPlayerActions2.add(y[i+1]);
		}
		sequenceOfPlayerActions2.add(y[S]);
			return sequenceOfPlayerActions2;
}
	public static void main(String[] args) {
		double weightC=0.5;
		for(int big=1;big<27;big++)
		{
			List<Integer> results= new ArrayList<Integer>();
			for(int i=0;i<power2(big);i++){
				int x [] = new int [big];
				int x2[]= new int [big];
				int k=i;
				int weights=0;
				for(int j=0;j<big;j++)
				{
					x[j]=k % 2;
					k=k/2;
					if(x[j]==1)
						weights++;
				}
				if(weights<weightC*big)
					continue;
				for(int j=0;j<big;j++)
				{
					x2[j]=x[big-j-1];
					
				}
				List<Integer> sequenceOfPlayerActions= new ArrayList<Integer>();
			
				for(int j=0;j<big;j++)
				{
					sequenceOfPlayerActions.add(x2[j]);
					
				}
				Set D=new HashSet(); //new a D
				D.add(sequenceOfPlayerActions);
				List<Integer> sequence=sequenceOfPlayerActions;
				
				
				while(true)
				{
					int sizebefore=D.size();
					sequence= sx(big,sequence);
					D.add(sequence);
					if(sizebefore==D.size())
					{
						results.add(D.size());
						//System.out.println(big+" , period = "+D.size());
						break;
					}
				}
			
			}
			int max=0;
			int min=power2(big);
			int sum=0;
			int bigone=0;
			for(int i=0;i<results.size();i++)
			{
				sum=sum+results.get(i);
				if(results.get(i)>max)
					max=results.get(i);
				if(results.get(i)<min)
					min=results.get(i);
			}
			for(int i=0;i<results.size();i++)
			{
				
				if(results.get(i)>sum*1.0/results.size())
					bigone=bigone+1;
				
			}
			System.out.println(min);
			/*System.out.println(big+" , avg period = "+sum*1.0/results.size());
			System.out.println("bigger than avg = "+bigone+ " in "+results.size());
			System.out.println(big+" , max = "+max);
			System.out.println(big+" , min = "+min);*/
		}
		
	}
	
}
