//Guessing Game Assignment #1
//Due 1/13/23 
//Nate Loch and Zac Patterson 

import java.io.*;
import java.util.*;

class guess
{
    public static void main(String [] args)
    {
        Scanner cin;
        cin=new Scanner(System.in);
		
        int n; int numbers; int ans;
		
        System.out.println("***Welcome to the GUESSING GAME!!!***");
		System.out.println("I have a number between 1 and 100.  Can you guess it?");
		while(true)
		{
			numbers=(int)(1+100*Math.random()); //picks a random number 1-100
			while(true) //while loops till the number is guessed and the loop breaks 
			{ 
				System.out.println("Enter your guess: "); 
				n=cin.nextInt(); //asks and recives a user input
			
				if(n==numbers)
				{
					System.out.println("You win!!!");
					break;
				}
				else if(n>numbers)
				{
					System.out.println("Too big, goober");
					continue;
				}
				else if(n<numbers)
				{
					System.out.println("Too small, bozo");
					continue;
				}
			}
			System.out.print("Would you like to play again? (1 for yes, 0 for no): ");
			ans=cin.nextInt();
			if(ans==1)
			{
				continue;
			}
			else if(ans==0)
			{
				System.out.println("Thanks for playing");
				break;
			}
		}
	}
}