/*
 *
https:www.hackerrank.com/contests/w27/challenges/tailor-shop
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.time.Duration;
import java.time.Instant;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int max = 0 ;
	static int mm = 0;


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int[] a = new int[n];
		// your code goes here

		int t;
		int ct =0;
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();

		}
		Arrays.sort(a);

		for(int i=0; i<n; i++){
			t = (a[i]/p);
			if((a[i]%p != 0))t++;
			a[i] = t;
			if(i != 0){
				if(a[i]-a[i-1] <= 0)
					a[i] = a[i-1]+1;
			}
			ct += a[i];
		}
		System.out.println(ct);
	}






}
