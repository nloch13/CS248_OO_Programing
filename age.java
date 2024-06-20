// the age program 
import java.io.*;
import java.util.*;

class age 
{
	public static void main(String [] args)
	{
		// build scanner to read from keyboard 
		Scanner cin;
		cin=new Scanner(System.in);
		
		int years; //age in years 
		System.out.print("How old are you?");
		years=cin.nextInt();	
		
		if(years<60)
		{
			System.out.println("You are young");
		}
		else 
		{
			System.out.println("You are old");
		}
	}
}
