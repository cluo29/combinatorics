package combinatorics_sensi;
import java.util.*;
public class checkAA {
	
	public static int exam2(String input, int prime)
	{
		int x [] = new int [32] ;
		Set  set1=new HashSet();
		for(int i=0;i<input.length();i++){
			x[i]=Integer.parseInt(input.substring(i,i+1));
		}
		x[5]=10;
		for(int i=0;i<input.length();i++){
			for(int j=0;j<input.length();j++){
				int sum=x[i]+x[j];
				sum=sum%prime;
				set1.add(sum);
			}
		}
		//for(int i=0;i<set1.size();i++){
			System.out.println(set1);
		//}
		
		return 19;
	}
	public static void main(String[] args) {
		
		int z= exam2("023789",19); //check a function input
	}
}
