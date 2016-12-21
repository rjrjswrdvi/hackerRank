/*
 * https://www.hackerrank.com/contests/w27/challenges/drawing-book/
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int nt=0;
        if(p == 1 || p == n){
        	System.out.println(nt);return;
        } 
         
        // your code goes here
        Stack<Integer> st = new Stack<Integer>();
        for(int i=n;i>0;i--){
        	st.add(i);
        }
        
        int mp = n/2;
        int val_mp = st.search(p);
        int pi = st.search(p);
        if(pi<= mp){
        	nt = (int) Math.abs(Math.ceil((double)(pi-1)/2));
        }else{
        	nt = (int) Math.abs(Math.ceil((n-pi)/2));
        }
        System.out.println(nt);
        
        
    }
}
