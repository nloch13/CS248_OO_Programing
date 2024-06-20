//count the number if Es

import java.io.*;
import java.util.*;

class lettercount
{
	static int numEs(String s)
	{
		int cnt=0;
		for(int i=0; i<s.length(); i++)
		{
			char letterthatshere=s.charAt(i);
			if(letterthatshere=='E' || letterthatshere=='e')
			{cnt++;}
		}
		return cnt;
	}
	
	public static void main(String [] args)
	{
		//get a string/line of text from the user
		String line;
		Scanner cin=new Scanner(System.in);
		System.out.print("Please enter some text: ");
		line=cin.nextLine();
		
		//counts the Es
		int count;
		count=numEs(line);
		
		System.out.println("There are "+count+" Es in your text");
	}
}