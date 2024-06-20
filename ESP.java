//The Exam Statistics Program
//Nate Loch and Zac Patterson 
//Due 1/20/23

import java.io.*;
import java.util.*;

public class ESP 
{
    public static void main(String [] args)
    throws IOException
    {
        System.out.println("***Welcome to the Exam Statistics Program!!!***");
        String line, filename;
        Scanner cin=new Scanner(System.in);
        System.out.print("Please enter the name of your data file: ");
        filename=cin.nextLine();
        
        Scanner esp;
        esp=new Scanner(new FileReader(filename));

        // Get number of scores
        int n=esp.nextInt();

        int [] sc=new int[n];

        for(int i=0; i<sc.length; i++)
        {
            sc[i]=esp.nextInt();
        }

        int numScores, score, minScore = Integer.MAX_VALUE, maxScore = Integer.MIN_VALUE, totalScore = 0;
        int A = 0, B = 0, C = 0, D = 0, F = 0;

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
                A++;
            } 
            else if (sc[i]>=80) 
            {
                B++;
            } 
            else if (sc[i]>=70) 
            {
                C++;
            } 
            else if (sc[i]>=60) 
            {
                D++;
            } 
            else 
            {
                F++;
            }
        }

        // Print results
		System.out.println("There are " +n+ " scores.");
        System.out.println("Minimum score: " + minScore);
        System.out.println("Maximum score: " + maxScore);
        System.out.println("Average score: " + (double) totalScore / n);
        System.out.println("Number of scores by letter grade:");
        System.out.println("A: " + A);
        System.out.println("B: " + B);
        System.out.println("C: " + C);
        System.out.println("D: " + D);
        System.out.println("F: " + F);
    }
}