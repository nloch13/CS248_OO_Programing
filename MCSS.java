import java.io.*;
import java.util.*;

class MCSS
{
  static int alg1(int [] list)
  {
    int best=0;
    for(int start=0; start<list.length; start++)
    {
      for(int stop=start; stop<list.length; stop++)
      {
        int sum=0;
        for(int i=start; i<=stop; i++)
        { sum+=list[i]; }
        if(sum>best) { best=sum; }
      }
    }
    return best;
  }

  static int alg2(int [] list)
  {
    int best=0;
    for(int start=0; start<list.length; start++)
    {
      int sum=0;
      for(int stop=start; stop<list.length; stop++)
      {
        sum+=list[stop];
        if(sum>best) { best=sum; }
      }
    }
    return best;
  }

  static int alg3(int [] list)
  {
    int [] red=new int[list.length]; // prefix sum
    red[0]=list[0];
    for(int i=1; i<list.length; i++)
    { red[i]=red[i-1]+list[i]; }

    for(int i=0; i<list.length; i++)
    { System.out.print(list[i]+" "); }
    System.out.println("");
    for(int i=0; i<list.length; i++)
    { System.out.print(red[i]+" "); }
    System.out.println("");
    return 0;
  }

  static int [] makelist(int n,int range) // -range to range
  {
    int [] list=new int[n];
    for(int i=0; i<n; i++)
    {
      list[i]=(int)((2*range+1)*Math.random())-range;
    }
    return list;
  }

  public static void main(String [] args)
  {
    int n;
    Scanner cin=new Scanner(System.in);
    System.out.print("How big is your list? ");
    n=cin.nextInt();
    //int [] list={2,-1,-3,4,2,-3,10}; // the "new" is implied
    int [] list=makelist(n,10);

    for(int i=0; i<list.length; i++)
    { System.out.print(list[i]+" "); }
    System.out.println("Alg 2="+alg2(list));
    System.out.println("Alg 1="+alg1(list));
    System.out.println("");
    System.out.println("Alg 3="+alg3(list));
  }
}
