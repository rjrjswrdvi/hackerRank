/*
 * https://www.hackerrank.com/contests/w27/challenges/hackonacci-matrix-rotations
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.time.Duration;
import java.time.Instant;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();

	// create map to store value for each angle
	static Map<Integer,Integer> amap = new HashMap<Integer,Integer>();
	static int reuse = 0;

	//	public static void main(String[] args) {
	//		for(int i=1;i<=64;i++)
	//			 System.out.println(hackonacci(i) + " ");
	//	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int max = Integer.MIN_VALUE;
		int[] a = new int[q];
		for(int a0 = 0; a0 < q; a0++){
			int angle = in.nextInt();
			a[a0] = angle;
			angle = angle%360;
			if(max<angle) max = angle;
			amap.put(angle, 0);
			// your code goes here
		}
		//Instant start = Instant.now();
		int[][] h = new int[n+1][n+1];
		BigInteger SEVEN = new BigInteger("7");
		BigInteger TWO = new BigInteger("2");
		long l;
		int[] harr = {0,1,0,0,1,1,1};
		for(int i=1;i<=n;i++){
			for(int j=i;j<=n;j++){
				if(i == 1 && j==1)
				{
					h[i][j] = 1;
					continue;
				}
				h[i][j] = harr[(new BigInteger((long)Math.pow(i*j, 2) +"")).subtract(TWO).remainder(SEVEN).intValue()];
				h[j][i] = h[i][j];
			}
		}

		// find the number of changes for each angle
		for(int i = 90;i<=max;i=i+90){
			amap.put(i, rotate(h,i));

		}

		for(int a0 = 0; a0 < q; a0++){
			int angle = a[a0];
			angle = angle%360;
			System.out.println(amap.get(angle));
		}
//		Instant end = Instant.now();
//		System.out.println(Duration.between(start, end));

	}



	private static void fill(Map<Long, Integer> hmap, long pow) {
		hmap.put(1l, 1);
		int[] a = {0,1,0,0,1,1,1};
		int j=0;
		for(long i=2;i<=pow;i++){
			if(isSquare(i))
				hmap.put(i, a[j]);
			j++;
			if(j==7)j=0;
		}
	}



	/* 90 degree rotation
     41 31 21 11
     42 32 22 12
     43 33 23 13
     44 34 24 14
	 */
	private static int rotate(int[][] h,int angle) {
		int n = h.length-1;
		int ct = 0;
		switch(angle){
		case 90:
			for(int i=1;i<=n;i++){
				for(int j = 1;j<=n;j++){
					// compare [1,1] with [4,1] 
					//	and	   [1,4] with [1,1]
					if(h[i][j] != h[n-j+1][i])ct++;
				}
			}
			break;
		case 180:
			for(int i=1;i<=n;i++){
				for(int j = 1;j<=n;j++){
					// compare [1,1] with [4,4] 
					//	and	   [1,4] with [4,1]
					if(h[i][j] != h[n-i+1][n-j+1])ct++;
				}
			}
			break;
		case 270:
			for(int i=1;i<=n;i++){
				for(int j = 1;j<=n;j++){
					// compare [1,1] with [1,4] 
					//	and	   [1,4] with [4,4]
					if(h[i][j] != h[j][n-i+1])ct++;
				}
			}
			break;
		}
		return ct;
	}
	static long goodMask; // 0xC840C04048404040 computed below
	{
		for (int i=0; i<64; ++i) goodMask |= Long.MIN_VALUE >>> (i*i);
	}

	static boolean isSquare(long x) {

		final long tst = (long) Math.sqrt(x);
		return tst * tst == x;
	}

	private static int hackonacci(int n) {
		if( n == 1) return 1;
		if(n == 2) return 0;
		if(n==3) return 1;

		//System.out.println(n);
		Integer val = hmap.get(n);
		if(val != null){ return val;}
		// Using matrix exponentiation
		//f(n) = 1*f(n-1) + 2*f(n-2) + 3*f(n-3);
		/*
			 |f(n)  |	=	[|1 2 3|]^n-3	*	|f(3)|
			 |f(n-1)|		[|1 0 0|]			|f(2)|
			 |f(n-2)|		[|0 1 0|]			|f(1)|

			 ==>

			 |f(n)  |	=	[|1 2 3|]^n-3	*	|3|
			 |f(n-1)|		[|1 0 0|]			|2|
			 |f(n-2)|		[|0 1 0|]			|1|

			 ==>
			 |f(n)  |	=	M^n-3	*	U
			 |f(n-1)|		
			 |f(n-2)|		

		 */
		int[][] M = {{1,2,3},{1,0,0},{0,1,0}};
		int[][] M_copy = {{1,2,3},{1,0,0},{0,1,0}};

		M = power(M,M_copy,n-3);
		return  ((3*M[0][0] + 2* M[0][1] + M[0][2])%2==0)?0:1;
	}
	private static int[][] multiply(int[][] m, int[][] m_copy) {
		int[][] prod = new int[3][3];
		for(int i=0;i<m.length;i++)
			for(int j=0;j<m.length;j++){
				prod[i][j] = 0;
				for(int k =0;k<m_copy.length;k++){
					prod[i][j] += m[i][k]*m_copy[k][j];
				}
				//prod[i][j] = lastDigit(prod[i][j]);
			}
		return prod;
	}
	private static int lastDigit(int i) {
		String s = i +"";
		s = s.charAt(s.length()-1) +"";
		return Integer.valueOf(s);
	}

	private static int[][] power(int[][] m, int[][] m_copy, int l) {

		if(l == 1){
			return m;
		}
		m = power(m,m_copy,(int)l/2);
		m = multiply(m,m);

		if(l%2 != 0)
			m = multiply(m,m_copy);
		return m;
	}
}
