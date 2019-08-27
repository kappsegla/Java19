package methods;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Recursive {

    public static long fib(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    //https://stackoverflow.com/questions/49397611/inefficient-recursive-code-to-produce-fibonacci-number-in-java

    static int n1 = 0, n2 = 1, n3 = 0;  //Memorization of last two calculated values

    static void printFibonacci(int count) {
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            printFibonacci(count - 1);
        }
    }

    //Recursion template
    static void recursionTemplate(int count) {
        //We need something to stop our calls.
        if (count <= 0)
            return;
        //Place code here for counting down
        //System.out.println("Print before " + count);

        recursionTemplate(count - 1);
        //System.out.println("Print after " + count);
        //Place code here for counting up
    }


    public static void main(String[] args) {
        System.out.println("The 0th fibonacci number is: " + fib(0));
        System.out.println("The 7th fibonacci number is: " + fib(7));
        System.out.println("The 12th fibonacci number is: " + fib(12));
        //System.out.println("The 12th fibonacci number is: " + fib(48));

        //printFibonacci(20);

        recursionTemplate(10);

    }

//    A child couldn't sleep, so her mother told her a story about a little frog,
//        who couldn't sleep, so the frog's mother told her a story about a little bear,
//            who couldn't sleep, so the bear's mother told her a story about a little weasel...
//                who fell asleep.
//            ...and the little bear fell asleep;
//        ...and the little frog fell asleep;
//    ...and the child fell asleep.
}
