// The primes program with function!

import java.io.*;
import java.util.*;

class primes2
{
	static boolean isprime(int n)
	{
		if(n<2) return false;
		// loop to check for divisors
		for(int d=2; d<=Math.sqrt(n); d++) //Math.sqrt is square root function 
		{
			// check to see if d divides n
			// n%d is the remainder from n/d
			if(n%d == 0) // then d divides n
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args)
	{
		// build a Scanner to read from the kbd
		Scanner cin;
		cin=new Scanner(System.in);
		
		int n; // number to test for primality
		System.out.print("Enter a number please: ");
		n=cin.nextInt();
		
		// list all primes up to n:
		for(int i=1; i<=n; i++)
			if(isprime(i))
				System.out.println(i);''
		/*
		if(isprime(n))
		{ System.out.println("PRIME!"); }
		else
		{ System.out.println("Not prime."); }
		*/
	}
}
