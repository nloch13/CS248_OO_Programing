//Sorting
//Due 3/31/2023
//Zac Patterson and Nate Loch

import java.io.*;
import java.util.*;


class SortingMain extends Sorts
{
    public static void main(String[] args)
    {
        // build scanner
        Scanner scan; 
        scan = new Scanner(System.in);



        int sizeofArray = 0;


        System.out.println("What size array would you like sorted?"); 
        sizeofArray = scan.nextInt();


        System.out.println(" ");


        Integer [] deepCopy = new Integer [sizeofArray];


        //bubble sort array
        Integer [] bubbleSortedCopy = new Integer [sizeofArray];


        //insertion sort array
        Integer [] insertionSortedCopy = new Integer [sizeofArray]; 
        
        //selection sort array 
        Integer [] selectionSortedCopy = new Integer [sizeofArray];

        //quick sort array 
        Integer [] quickSortedCopy = new Integer [sizeofArray];

        //merge sort array 
        Integer [] mergeSortedCopy = new Integer [sizeofArray];


        for (int i=0; i < sizeofArray; i++)
        {
            deepCopy[i] = (int)(i+sizeofArray*Math.random()); 
            bubbleSortedCopy[i] = deepCopy[i];
            insertionSortedCopy[i] = deepCopy[i];
            selectionSortedCopy[i] = deepCopy[i]; 
            quickSortedCopy[i] = deepCopy[i];
            mergeSortedCopy[i] = deepCopy[i];
        }



        if (sizeofArray <= 100)
        {
            System.out.print("Original Array: "); 
            for (int i=0; i < sizeofArray; i++)
            {
                System.out.print(deepCopy[i] + " ");
            }

        }


        System.out.println(" ");


        double startTime=0;


        startTime = System.currentTimeMillis(); 
        Sorts.bubble(bubbleSortedCopy); 
        double bubbleTime = System.currentTimeMillis() - startTime;


        startTime = System.currentTimeMillis(); 
        Sorts.insertion (insertionSortedCopy);
        double insertionTime = System.currentTimeMillis() - startTime;


        startTime = System.currentTimeMillis(); 
        Sorts.selection(selectionSortedCopy);
        double selectionTime = System.currentTimeMillis() - startTime;



        startTime = System.currentTimeMillis(); 
        Sorts.quick(quickSortedCopy);
        double quickTime = System.currentTimeMillis() - startTime;


        startTime = System.currentTimeMillis(); 
        Sorts.merge(mergeSortedCopy);
        double mergeTime = System.currentTimeMillis() - startTime;


        if (sizeofArray <= 100)
        {
            System.out.println(" ");
            System.out.print("Bubble Sorted Array: "); 
            for (int i=0; i< sizeofArray; i++)
            {
                System.out.print(bubbleSortedCopy[i] + " ");

            }
            System.out.println("\n"); 
            System.out.print("Insertion Sorted Array: ");

            for (int i=0; i < sizeofArray; i++)
            {
                System.out.print(insertionSortedCopy[i] + " ");
            }
            System.out.println("\n");
            System.out.print("Selection Sorted Array");
            for (int i=0; i < sizeofArray; i++)
            {
                System.out.print(selectionSortedCopy[i] + " ");
            }
            System.out.println("\n");
            System.out.print("Quick Sorted Array: ");
            for (int i=0; i < sizeofArray; i++)
            {
                System.out.print(quickSortedCopy[i] + " ");
            }
            System.out.println("\n");
            System.out.print("Merge Sorted Array: ");
            for (int i=0; i < sizeofArray; i++)
            {
                System.out.print(mergeSortedCopy[i] + " ");
            }
        }


        System.out.println(" ");
        System.out.println("Bubble sorted time: " + bubbleTime);
        System.out.println("Insertion sorted time: " + insertionTime);
        System.out.println("Selection sorted time: " + selectionTime);
        System.out.println("Quick sorted time: " + quickTime);
        System.out.println("Merge sorted time: " + mergeTime);


    }
}
