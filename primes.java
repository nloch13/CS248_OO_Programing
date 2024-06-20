//The Primes Program

import java.io.*;
import java.util.*;

class primes
{
	public static void main(String [] args)
	{
		// build scanner to read from keyboard 
		Scanner cin;
		cin=new Scanner(System.in);
		
		int n; //number to test for primality  
		System.out.print("Enter a number please:");
		n=cin.nextInt();
		
		boolean isprime=true;
		//loop to check for divisors 
		for(int d=2; d<n; d++)
		{
			//check to see if d divides n
			//n%d is the remander of n/d
			if(n%d == 0) //then d divides n%d
			{
				isprime=false;
			}
		}
		if(isprime)
		{System.out.println("Your number is prime");}
		else 
		{System.out.println("Your number is not prime");}
	}
	}
