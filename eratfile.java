//Sieve of Eratosthenes

import java.io.*;
import java.util.*;

class eratfile 
{
	public static void main(String [] args)
	throws IOException
	{
		//get the prime limit 
		int n;
		System.out.println("enter prime limit please");
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		
		//set up the array
		boolean [] z;
		z=new boolean[n+1];
		z[0]=z[1]=false;
		for(int i=0; i<z.length; i++)
		{ z[i]=true; }
		
		//do the crossing off to find primes
		for(int p=2; p<Math.sqrt(n); p++)
		{
			if(z[p]) //make sure p hasnt been crossed off 
			{
				for(int q=2*p; q<=n; q=q+p)
				{ z[q]=false; } //cross off q
			}
		}
		//open file for writing 
		PrintWriter outfile;
		outfile=new PrintWriter(new FileWriter("primes.txt"));
		
		//list primes 
		for(int i=0; i<z.length; i++)
		{ 
			if(z[i])
			{
				outfile.print(i+" ");
			}
		}
		outfile.println(" ");
		
		outfile.close(); //save
	}
}