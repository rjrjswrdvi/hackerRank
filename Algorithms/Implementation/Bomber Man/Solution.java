import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		int n = scan.nextInt();
		String s;
		char[][] a = new char[r][c];
		char[][] o = new char[r][c];

		for(int i=0;i<r;i++){
			s=scan.next();
			for(int j=0;j<c;j++) {
				a[i][j] = (s.charAt(j)=='.')?'O':'.';
				o[i][j] = s.charAt(j);
			}

		}
		if(n%2==0){
			// print grid
			for(int i=0;i<r;i++){

				for(int j=0;j<c;j++) 
					System.out.print('O');

				System.out.println();

			}
			return;
		}
		if(n<3){printGrid(o,r,c);return;}
		
		o = cloneArray(a);

		int sec = 0;

		// skip 1 sec
		sec++;

		// skip 2 sec too
		sec++;
		printGrid(o,r,c);
		System.out.println("=======");
		// 3 sec bomb explode. mark exploded bombs as .
		explodeBomb(a,o,r,c,'.');
		printGrid(o,r,c);
		System.out.println("=======");
 		sec++;
 		 
 		if((n+1)%4 == 0){printGrid(o,r,c);return;}
 		
 		// 4 sec place bombs
 		 
 		
 		// 5 sec explode 2 sec bombs
 		a = cloneArray(o);
 		reverseArray(a, r, c);
 		o = cloneArray(a);
 		printGrid(a,r,c);
 		System.out.println("+===");
		explodeBomb(o, a, r, c, '.');
		sec++;
		 
		
		if((n-1)%4 == 0){printGrid(a,r,c);return;}
			 
		 
	}

	private static void reverseArray(char[][] o,int r, int c) {
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++) {
				o[i][j] = (o[i][j]=='.')?'O':'.';
			}

		}
}

	private static void explodeBomb(char[][] a, char[][] o, int r, int c, char d) {
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				
				if(a[i][j] == d && o[i][j] == d){
					// mark neighbors as exploded
					o[i][j]='.';
					if(i !=0){
						 
						o[i-1][j] = '.';
				}
				if(i!=r-1){
					 
						o[i+1][j] = '.';
						
				}
					if(j !=0){
						 
						o[i][j-1] = '.';
				}
				if(j!=c-1){
					
						o[i][j+1] = '.';
						 
				}
					

					
				}
			}
		}

//		for(int i=0;i<r;i++){
//			for(int j=0;j<c;j++){
//				if(o[i][j] == d){
//					o[i][j] = '.';
//				}
//			}
//		}
	}

	static void printGrid(char[][] a, int r,int c){
		// print grid
		for(int i=0;i<r;i++){

			for(int j=0;j<c;j++) 
				System.out.print(a[i][j]);

			System.out.println();

		}
		
	}

	static char[][] cloneArray(char[][] src) {
		int length = src.length;
		char[][] target = new char[length][src[0].length];
		for (int i = 0; i < length; i++) {
			System.arraycopy(src[i], 0, target[i], 0, src[i].length);
		}
		return target;
	}
}