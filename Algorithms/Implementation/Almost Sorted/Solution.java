/*
 * Problem
 * _______
 * 
 * Given an array with  elements, can you sort this array in ascending order using only one of the following operations?

Swap two elements.
Reverse one sub-segment.
Input Format 
The first line contains a single integer, , which indicates the size of the array. 
The next line contains  integers separated by spaces.

n  
d1 d2 ... dn  
Constraints 
 2<=N<=100000
 0<=di<=1000000
  
All  are distinct.

Output Format 
1. If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

a. If you can sort the array by swapping  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .

b. Else if it is possible to sort the array by reversing the segment , output reverse l r in the second line. and  are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from  to .

 represents the sub-sequence of the array, beginning at index  and ending at index , both inclusive.

If an array can be sorted by either swapping or reversing, stick to the swap-based method.

If you cannot sort the array in either of the above ways, output no in the first line.

Sample Input #1

2  
4 2  
Sample Output #1

yes  
swap 1 2
Sample Input #2

3
3 1 2
Sample Output #2

no
Sample Input #3

6
1 5 4 3 2 6
Sample Output #3

yes
reverse 2 5
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	List<Integer> o = new ArrayList<Integer>();
    	List<Integer> l = new ArrayList<Integer>();
    	
    	int ele;
    	for(int i=0;i<n;i++){
    		ele = scan.nextInt();
    		l.add(ele);
    		o.add(ele);
    		
    	}
    	Collections.sort(o);
    	// check if already sorted
    	if(o.equals(l)) {System.out.println("yes");return;}
    	int tmp;
    	List<Integer> bck = new ArrayList<Integer>(l);
    	// check for swapping
    	// swap first and last 
    	
    	tmp = l.get(n-1);
		l.set(n-1, l.get(0));
		l.set(0,tmp);
		if(o.equals(l)) {
			System.out.println("yes");
			System.out.println("swap " + (1) + " " + (n));
			return;
		}else{
			l = new ArrayList<Integer>(bck);
		}
    	int i = n-1;
    	// decrement as long as its lesser
    	while(i>0){
    		if(l.get(i) > l.get(i-1)) i--;
    		else break;
    	}
    	/*
    	 6
		1 5 3 4 2 6
    	 */
    	// increment as long as it higher
    	if(i!=0){
    		int j = i;
    		i = i -1;
    		while(i>-1){
        		if(l.get(i) > l.get(j)) i--;
        		else break;
        	}
    		if(i!=-1){
        		// swap i+1 and j
        		tmp = l.get(i+1);
        		l.set(i+1, l.get(j));
        		l.set(j,tmp);
        		if(o.equals(l)) {
        			System.out.println("yes");
        			System.out.println("swap " + (i+2) + " " + (j+1));
        			return;
        		}
        	}
    		
    		// check if reverse works
    		l = new ArrayList<Integer>(bck);
    		Collections.reverse(bck);
    		if(o.equals(l)) {
    			System.out.println("yes");
    			System.out.println("reverse " + (1) + " " + (n));
    			return;
    		}
    		
    		List<Integer> sl = l.subList(i+1, j+1);
    		Collections.reverse(sl);
    		tmp = 0;
    		for(int t=i+1;t<=j;t++){
    			l.set(t, sl.get(tmp++));
    		}
    		if(o.equals(l)) {
    			System.out.println("yes");
    			System.out.println("reverse " + (i+2) + " " + (j+1));
    			return;
    		}
    	}
    	
    	System.out.println("no");
        
    }
}