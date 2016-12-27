/*https://www.hackerrank.com/challenges/making-anagrams*/

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		StringBuilder sb = new StringBuilder();
		sb.append(s2);

		if(s1.equalsIgnoreCase(s2) || s1.equalsIgnoreCase(sb.reverse().toString())){
			System.out.println("0");
		}else{
			List<String> l0 = new ArrayList<String>();
			List<String> l1 = new ArrayList<String>();
			for(int j=0;j<s1.length();j++){
				l0.add(s1.charAt(j)+"");

			}
			for(int j=0;j<s2.length();j++){
				l1.add(s2.charAt(j)+"");

			}
			for(int j=0;j<s1.length();j++){
				
				if(l1.remove(s1.charAt(j)+""))
					l0.remove(s1.charAt(j)+"");
			}
			System.out.println(l0.size() + l1.size());
			
		}


	}
}