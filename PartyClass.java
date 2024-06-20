import java.util.*;

class Party
{
	
	//Parties have 3 parts: Party time, Arrival size, and Name
	int size, time, bribe;
	String name;
	
	//constructor
	public Party(Scanner inFile)
	{
		//collects three elements from the file, moves cursur to next line
		time = inFile.nextInt();
		size = inFile.nextInt();
		bribe = inFile.nextInt();
		name = inFile.nextLine();
	}
	
	//accessors
	public int getSize()
	{
		return size;
	}
	public int getTime()
	{
		return time;
	}
	public String getName()
	{
		return name;
	}
	public void printParty()
	{

		System.out.print("party" + name + " of " + size + " people (bribe = " + bribe + ")");

	}
	public int getBribe()
	{
		return bribe;
	}
}