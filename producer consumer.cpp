

import java.util.Scanner;

import java.util.ArrayList;

public class Main
{

 public static void main(String a[])

 {

     ArrayList<Integer> buffer=new ArrayList</*Integer*/> ();

    Thread t1=new Thread (new P(buffer));

    //  t2=new Thread(new C(buffer));

     t1.start();

    //  t2.start();

 }

}

 

class P implements Runnable

{

    ArrayList<Integer>b=null;

    final int limit=10;

    int i=0;

   

    P(ArrayList<Integer> buffer)

    {

        b=buffer;

    }

   

    public void run()

    {

        while(true)

        {

            try{

                i++;

                produce(i);

            }

            catch(InterruptedException e)

            {

                System.out.println(e);

            }

        }

    }

   

    public void produce(int i) throws InterruptedException
