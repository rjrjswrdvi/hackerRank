/*https://www.hackerrank.com/challenges/anagram*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	for(int i=0;i<n;i++){
    		String s = scan.next();
    		
    		int len = s.length();
    		if(len %2 == 0){
    			String s1 = s.substring(0, len/2);
    			String s2 = s.substring(len/2,len);
    			StringBuilder sb = new StringBuilder();
    			sb.append(s2);
    			
    			if(s1.equalsIgnoreCase(s2) || s1.equalsIgnoreCase(sb.reverse().toString())){
    				System.out.println("0");
    			}else{
    				List<String> l1 = new ArrayList<String>();
    				for(int j=0;j<s1.length();j++){
    					l1.add(s2.charAt(j)+"");
    				}
    				for(int j=0;j<s1.length();j++){
    					l1.remove(s1.charAt(j)+"");
    				}
    				System.out.println(l1.size());
    			}
    		}else{
    			System.out.println("-1");
    		}
    	}
    }
}