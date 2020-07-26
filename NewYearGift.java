/*
  Problem Statement:- 
  Creating a new year gift which contains some sweets.
  when we are creating a gift we will give number of chocolates and number of candies to be kept in that gift box.
  when we instantiated the chocolates class we want to get the chocolates names in ascending or descending order.
  when we instantiated the candies class we want to get the number of candies in the gift.
*/
package com.codebind;
import java.util.*;
//Sweets class is taken as parent class which creates a gift by instantiating Sweets class 
class Sweets
{
 static int no_of_chocolates;
 static int no_of_candies;
 public Sweets() {}
//Overloads the Sweets class constructor
 public Sweets(int choco,int candi)
 {
  no_of_chocolates=choco;
  no_of_candies=candi;
 }
 
}
class Choclates extends Sweets
{
 String temp;
 Scanner sc=new Scanner(System.in);
 String names[]=new String[no_of_chocolates];
 public void input()
 {
 Scanner sc=new Scanner(System.in);
 for(int i=0;i<no_of_chocolates;i++)
 {
  System.out.println("enter choclate name");
  names[i]=sc.nextLine();
 }
 for(int i=0;i<no_of_chocolates;i++)
  System.out.println(names[i]);
 }
 //Sorting the chocolates data according to chocolates names 
 public void sort(String ch)
 {
  for(int i=0; i<no_of_chocolates; i++)
        {
            for(int j=1; j<no_of_chocolates; j++)
            {
                if(names[j-1].compareTo(names[j])>0)
                {
                    temp=names[j-1];
                    names[j-1]=names[j];
                    names[j]=temp;
                }
            }
        }
  //if user wants to sort the data in ascending order then if block will be executed
  if(ch.compareTo("a")<0)
   for(int i=0;i<no_of_chocolates;i++)
    System.out.println(names[i]);
  else
   for(int i=(no_of_chocolates-1);i>=0;i--)
    System.out.println(names[i]);
 }
}
//Defining Candies class to return the no_of_candies
class Candies extends Sweets
{
 public void count()
 {
  if(no_of_candies<=10 && no_of_candies>0)
   System.out.println("no. of candies lies in between 1 and 10 "+no_of_candies);
  else if(no_of_candies<=50 && no_of_candies>10)
   System.out.println("no. of candies lies in between 50 and 10 "+no_of_candies);
  else
   System.out.println("no. of candies"+no_of_candies);
   
 }
}
public class App
{
 public static void main(String arg[])
 {
  Scanner sc=new Scanner(System.in);
  int nchoc,ncand,ch;
  System.out.println("enter no. of gifts");
  int n=sc.nextInt();
  System.out.println(n);
  for(int i=0;i<n;i++)
  {
   System.out.println("Keep choclates and candies into gift box");
   System.out.println("enter no. of choclates");
   nchoc=sc.nextInt();
   System.out.println("enter no. of candies");
   ncand=sc.nextInt();
   //Creating a gift by instantiating the Sweets object
   Sweets s1=new Sweets(nchoc,ncand);
   while(true)
   {
   System.out.println("1.Total weight\n2.sorting the choclates\n3.no. of candies\n4.exit");
   ch=sc.nextInt();
   if(ch==1)
    System.out.println(nchoc+ncand);
   else if(ch==2)
   {
    Choclates c1=new Choclates();
    c1.input();
    System.out.println("enter 'a' for ascending order\n enter 'd' for descending order");
    String a=sc.next();
    c1.sort(a); 
   }
   else if(ch==3)
   {
    if(ncand==0)
     System.out.println("zero candies");
    else
    {
     Candies c2=new Candies();
     c2.count();
    }
   }
   else {
	   break;
   }
   }
   System.out.println((i+1)+"gift completed");
  }
   
 }
}