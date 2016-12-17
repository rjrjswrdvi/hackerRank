
/*
 * Problem
 * -------
 Red John has committed another murder. But this time, he doesn't leave a red smiley behind. What he leaves behind is a puzzle for Patrick Jane to solve. He also texts Teresa Lisbon that if Patrick is successful, he will turn himself in. The puzzle begins as follows.

There is a wall of size 4xN in the victim's house. The victim also has an infinite supply of bricks of size 4x1 and 1x4 in her house. There is a hidden safe which can only be opened by a particular configuration of bricks in the wall. In every configuration, the wall has to be completely covered using the bricks. There is a phone number written on a note in the safe which is of utmost importance in the murder case. Gale Bertram wants to know the total number of ways in which the bricks can be arranged on the wall so that a new configuration arises every time. He calls it M. Since Red John is back after a long time, he has also gained a masters degree in Mathematics from a reputed university. So, he wants Patrick to calculate the number of prime numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should call Red John on the phone number from the safe and he will surrender if Patrick tells him the correct answer. Otherwise, Teresa will get another murder call after a week.

You are required to help Patrick correctly solve the puzzle.

Input Format

The first line of input will contain an integer T followed by T lines each containing an integer N.

Output Format

Print exactly one line of output for each test case. The output should contain the number P.

Constraints 
1<=T<=20 
1<=N<=40

Sample Input

2
1
7
Sample Output

0
3
 */
package dynamicprogramming.redjohnisback;
import java.io.*;
import java.util.*;

public class Solution {
	 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	Scanner scan = new Scanner(System.in);
    	int l = scan.nextInt();
    	int[] a = new int[l];
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<l;i++){
    		a[i] = scan.nextInt();
    	}
    	
    	int[] ways = new int[l];
    	
    	for(int i=0;i<a.length;i++){
    		if(a[i] < 4) 
    		{ 
    			ways[i] =  1;
    		}else{
                ways[i] = getWays(a[i]);
    		}
    		if(max<ways[i]) max = ways[i];
    	}
    	List<Integer> primes = sieveOfEratosthenes(max);
    	for(int i=0;i<a.length;i++)
    		System.out.println(getPrimeCt(primes,ways[i]));
    	 
    }
    

	private static int getWays(int i) {
		
		int ct = 1; // i bricks are placed vertically
		int d = i/4; // max number of groups containing 4 bricks in a group
					 // that can be placed horizontally
		int n,b,c;int min,max;
		// find the number of ways 't' group of 4 bricks placed horizontally
		// along with (i- (4*t) ) bricks placed vertically
		for(int t =1;t<=d;t++){
			b = t;
			c = i-(4*t);
			n = b+c;
			if(c==0) {ct++;continue;}
			// find n!/(b!*c!)
			min = Math.min(b, c); 
			c = min;
			b = n;
			for(int k=1;k<min;k++){
				n *= (b-k);
				c *= (min-k);
			}
			ct+=n/c;
		}
		return ct;
	}


	private static int getPrimeCt(List<Integer> primes, int i) {
		int ct = 0;
		for(int t:primes)
			if(t<=i) ct++;
			else break;
		return ct;
	}

	
	
	static List<Integer> sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
		List<Integer> primes = new ArrayList<Integer>();
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                 primes.add(i);
        }
        return primes;
    }

	 
}