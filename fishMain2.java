import java.io.*;
import java.util.*;

class FishMain2
{
  static void frenzy(Fish [] school)
  {
    int target=(int)(school.length*Math.random());
    school[target].sharkAttack();
  }

  public static void main(String [] args)
  throws IOException
  {
    Scanner fishfile=new Scanner(new FileReader("fishfile.txt"));
    int n=fishfile.nextInt();

    Fish [] school=new Fish[n];

    for(int i=0; i<school.length; i++)
    {
      school[i]=new Fish(fishfile);
    }

    System.out.println("Mr. Ray's roster:");
    for(int i=0; i<school.length; i++)
    {
      System.out.println(school[i]);
    }

    // Shark frenzy!
    System.out.println("PSA: Shark attack in progress.");
    final int frenzySize=35; // !!
    for(int i=0; i<frenzySize; i++)
    {
      frenzy(school);
    }

    System.out.println("Mr. Ray's roster:");
    for(int i=0; i<school.length; i++)
    {
      System.out.println(school[i]);
    }

  }
