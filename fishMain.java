import java.io.*;
import java.util.*;

class FishMain
{
  public static void main(String [] args)
  {
    Fish f,f2;
    f=new Fish("Angela","blue","angelfish",5);
    f2=new Fish("Stephanie","green","stegasaurus",10);

    System.out.println("There are "+f.count+" total fish.");
    // Note: f.count, f2.count, and Fish.count are all the same thing.

    System.out.println(f);
    System.out.println(f2);

    System.out.println(f.getName()+" has color "+f.getColor());

    System.out.println("Oh no! Sharks are attacking!");
    if(f.getFins()<f2.getFins())
      { f2.sharkAttack(); }
    else
      { f.sharkAttack(); }
    System.out.println(f);
    System.out.println(f2);

    System.out.println("Radioactive lunch time.");
    f.seaweed();
    f2.seaweed();
    System.out.println(f);
    System.out.println(f2);
  }