/*
 * Problem
 * -------
 * 
 How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to efficiently compute the answer.

Task

Write a program that, given

The amount  to make change for and the number of types  of infinitely available coins
A list of M  coins - C={c1,c2,c3.....cM}
Prints out how many different ways you can make change from the coins to STDOUT.

The problem can be formally stated:

Given a value N, if we want to make change for N cents, and we have infinite supply of each of C={c1,c2,c3.....cM} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

Solving the overlapping subproblems using dynamic programming

You can solve this problem recursively, but not all the tests will pass unless you optimise your solution to eliminate the overlapping subproblems using a dynamic programming solution

Or more specifically;

If you can think of a way to store the checked solutions, then this store can be used to avoid checking the same solution again and again.
Input Format

First line will contain 2 integer N and M respectively. 
Second line contain M integer that represent list of distinct coins that are available in infinite amount.

Constraints
1<=Ci<=50
1<=N<=250
1<=M<=50

The list of coins will contain distinct integers.
Output Format

One integer which is the number of ways in which we can get a sum of N from the given infinite supply of M types of coins.

Sample Input

4 3
1 2 3 
Sample Output

4
Sample Input #02

10 4
2 5 3 6
Sample Output #02

5
 */


import java.io.*;
import java.util.*;

public class Solution {
	
	static List<String>   l = new ArrayList<String>();
	static int amt;
	 
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		amt = scan.nextInt();
		int n = scan.nextInt();
		 int c[] = new int[n];
		for(int i=0;i<n;i++){
			c[i] = scan.nextInt();
		}

		Arrays.sort(c);
		long table[] = new long[amt+1];
		table[0] = 1;
		for(int i=0;i<n;i++){
			for(int j=c[i];j<=amt;j++){
				 
				table[j] += table[j-c[i]];
				
			}
		}

		/*
		 166 23
		 5 37 8 39 33 17 22 32 13 7 10 35 40 2 43 49 46 19 41 1 12 11 28
		 */
		System.out.println(table[amt]);
	}


	

}