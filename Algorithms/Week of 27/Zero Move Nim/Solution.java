import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for(int a0 = 0; a0 < g; a0++){
			int n = in.nextInt();
			Integer[] p = new Integer[n];
			Integer[] p_copy = new Integer[n];
			int b = 0;
			int val;
			for(int p_i=0; p_i < n; p_i++){
				p[p_i] = in.nextInt();
				if(p[p_i]%2==0)
					val = p[p_i]-1;
				else
					val = p[p_i]+1;
				 b = b ^ (val);
				 
			}
			if(b == 0)
				System.out.println("L");
			else
				System.out.println("W");
			 


		}
	}
}