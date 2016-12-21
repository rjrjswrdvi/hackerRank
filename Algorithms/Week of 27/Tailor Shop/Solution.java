/*
 *
https://www.hackerrank.com/contests/w27/challenges/tailor-shop
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
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int max = 0;
        // your code goes here
        List<Integer> used = new ArrayList<Integer>();
        int t;
        int ct =0;
        for(int i=0;i<n;i++){
        	t = a[i]/p;
        	if(a[i]%p != 0) t++;
        	if(t<=max) t = max+1;
        	
        	max = t;
        	used.add(t);
        	ct += t;
        }
        
        System.out.println(ct);
    }
}
