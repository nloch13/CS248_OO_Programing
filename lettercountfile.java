//count the number of Es in a file 

import java.io.*;
import java.util.*;

class lettercountfile
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
	throws IOException
	{
		//get a string/file of text from the user
		String line, filename;
		Scanner cin=new Scanner(System.in);
		System.out.print("Please enter file name: ");
		filename=cin.nextLine();
		
		//open the file 
		Scanner harald;
		harald=new Scanner(new FileReader(filename));
		
		//counts the Es
		int count=0;
		
		while(harald.hasNext())
		{
			line=harald.nextLine();
			count=count+numEs(line);
		}
		
		System.out.println("There are "+count+" Es in your text");
	}
}