import java.io.*;
import java.util.*;

public class esp
{
    public static void main(String [] args)
    throws IOException
    {
        System.out.println("***Welcome to the Exam Statistics Program!!!***");
        String line, filename;
        Scanner cin=new Scanner(System.in);
        System.out.print("Please enter the name of your data file(hint... its esp.txt): ");
        filename=cin.nextLine();
        
        Scanner esp;
        esp=new Scanner(new FileReader("esp.txt"));

        // Get number of scores
        int n=esp.nextInt();

        int [] sc=new int[n];

        for(int i=0; i<sc.length; i++)
        {
            sc[i]=esp.nextInt();
        }

        int numScores, score, minScore = Integer.MAX_VALUE, maxScore = Integer.MIN_VALUE, totalScore = 0;
        int numA = 0, numB = 0, numC = 0, numD = 0, numF = 0;

        // Get scores and analyze them
        for (int i=0; i<n; i++) 
        {
            //score = esp.nextInt();

            // Update min and max scores
            if (sc[i]<minScore) {
                minScore=sc[i];
            }
            if (sc[i]>maxScore) {
                maxScore=sc[i];
            }

            // Update total score
            totalScore+=sc[i];

            // Update letter grade count
            if (sc[i]>=90) 
            {
                numA++;
            } 
            else if (sc[i]>=80) 
            {
                numB++;
            } 
            else if (sc[i]>=70) 
            {
                numC++;
            } 
            else if (sc[i]>=60) 
            {
                numD++;
            } 
            else 
            {
                numF++;
            }
        }

        // Print results
        System.out.println("Minimum score: " + minScore);
        System.out.println("Maximum score: " + maxScore);
        System.out.println("Average score: " + (double) totalScore / n);
        System.out.println("Number of scores by letter grade:");
        System.out.println("A: " + numA);
        System.out.println("B: " + numB);
        System.out.println("C: " + numC);
        System.out.println("D: " + numD);
        System.out.println("F: " + numF);
        System.out.println("There are " +n+ " scores.");

    }
}
