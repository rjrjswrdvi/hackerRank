/*https://www.hackerrank.com/challenges/sherlock-and-anagrams*/

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class MyComparator implements java.util.Comparator<String> {


	public MyComparator() {
		super();
	}

	public int compare(String s1, String s2) {

		return s1.length() - s2.length();
	}
}
public class Solution {
	static Map<String,Long> map = new HashMap<String,Long>();
	static List<String> sub = new ArrayList<String>();
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int t=0;t<n;t++){
			String s = scan.next();
			if(map.containsKey(s)){System.out.println(map.get(s)); continue;}

			long ct = 0;
		 
			// store all substrings
			//			
			int len = s.length();

			for(int l = 0;l<len;l++){
				sub = new ArrayList<String>();
				for(int pos = 0;pos<len-l;pos++){
					sub.add(s.substring(pos,pos+l+1));
				}
				// find count
				for(int i=0;i<sub.size();i++){
					for(int j=i+1;j<sub.size();j++){
						//ct += isAnagram(sub.get(i),sub.get(j));
						ct += check_anagram(sub.get(i).toCharArray(),sub.get(j).toCharArray());
					}
				}
			}

			map.put(s, ct);
			System.out.println(ct);
		}
	}

	private static int isAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return 0;
		StringBuilder sb = new StringBuilder();
		sb.append(s2);
		if(s1.equalsIgnoreCase(sb.reverse().toString())) return 1; 
		List<String> l1 = new ArrayList<String>();
		for(int j=0;j<s1.length();j++){
			l1.add(s2.charAt(j)+"");
		}
		for(int j=0;j<s1.length();j++){
			l1.remove(s1.charAt(j)+"");
		}
		if(l1.size() == 0){

			return 1;}
		return 0;
	}

	static int check_anagram(char a[], char b[])
	{
	   int first[] = new int[26];
	   int second[] = new int[26];
	   int c = 0;

	   while (c<a.length) {
	      first[a[c]-'a']++;
	      c++;
	   }
	   c = 0;
	   while (c<b.length) {
	      second[b[c]-'a']++;
	      c++;
	   }

	   for (c = 0; c < 26; c++) {
	      if (first[c] != second[c])
	         return 0;
	   }

	   return 1;
	}
	
}