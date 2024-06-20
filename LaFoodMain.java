/*LaFood Project 

Nate Loch and Zac Patterson */

import java.io.*;
import java.util.*; 

class LaFood
{
	public static void main(String [] args) throws IOException
	{
		// reads file and uses A/T/Q to tell the queue what to do 
		
		boolean run = true;
		String fileName;
		int waitTime = 0, parties = 0, bribes = 0;
		
		//sets up keyboard scanner
		Scanner cin = new Scanner(System.in);
		
		//gets file name imput
		System.out.print("\n*** Welcome to the La Food Restaurant Simulator ***\n\nEnter data file name: ");
		fileName = cin.next();
		
		
		//set up scanner obj
		Scanner inFile = new Scanner(new FileReader(fileName));
		
		//creates queue 
		QueueLL Q = new QueueLL();
		
		//Holds value to tell program if a party arrived or tabled
		char category = ' ';
		
		
		while(run == true)
		{
			//collects A, T or Q, each value corresponds to a different branch in the code
			category = inFile.next().charAt(0);			
			
			if(category == 'A')
			{
				Party backParty;
				//Adds a new party object to the queue
				
				backParty = new Party(inFile);
				Q.enqueue(backParty);
				
				
				//Adds the new party's bribe to the running total
				bribes += ((Party)backParty).getBribe();
				
				System.out.println("Please wait at the bar,");
				System.out.print("   ");
				backParty.printParty();
				System.out.print(" (time = " + backParty.getTime() + ")\n");
			}
			else if (category == 'T')
			{
				Party nextParty;
				int currentTime = 0;
				
				nextParty = (Party)Q.dequeue();
				
				
				
				//Add wait time (current - time of arrival) to the running sum, add one to the party counter
				currentTime = inFile.nextInt();
				waitTime += (currentTime - nextParty.getTime());
				parties++;
				
				//the dequeue both returns the object and removes it from the queue
				System.out.println("Table for " + nextParty.getName() + "! (time = " + currentTime + ")");
			}
			//for when the file says to quit, runs end of sim calcs and prints termination text.
			else
			{
				double waitTimeAvg = 0;
				
				run = false;
				if (!(parties == 0))
				{
					waitTimeAvg = (double)waitTime / (double)parties;
				}
				else
				{
					waitTimeAvg = 0;
				}
				
				System.out.println("** Simulation Terminated **\n\nThe average waiting time was: " + waitTimeAvg + "\nTotal bribe money collected: " + bribes + "\nAverage bribe: " + ((double)bribes / (double)(parties)) + "\nThe following parties were never seated:");
				while (!Q.isEmpty())
				{
					((Party)Q.dequeue()).printParty();
					System.out.println();
				}
				System.out.println("\nHave a nice meal!");
			}
		}
	}
}
