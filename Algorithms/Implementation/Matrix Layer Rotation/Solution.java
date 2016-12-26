/* https://www.hackerrank.com/challenges/matrix-rotation-algo */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int m = scan.nextInt();
    	int n = scan.nextInt();
    	int rot = scan.nextInt();
    	int[][] a = new int[m+1][n+1];
    	int pos_m = (int)Math.min(m, n)/2;
    	int pos_n = 2*(m+n)-4;
    	String[][] pos = new String[pos_m][pos_n];
    	int rowctr=-1;
    	int colctr;
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			a[i][j] = scan.nextInt();
    		}
    	}
    	// 10 
    	int end = (int)Math.min(m, n)/2;
    	for(int r=0;r<end;r++){
    		int i= r;
    		int j=r+1;
    		int c = 0;
    		while(i!=m-r){
    			pos[r][c++] = (++i) +"-" + j;
    		}
    		while(j!=n-r){
    			pos[r][c++] = i +"-" + (++j);
    		}
    		while(i!=1+r){
    			pos[r][c++] = (--i) +"-"+j;
    		}
    		while(j!=2+r){
    			pos[r][c++] =  i +"-" +(--j);
    		}
    		
    			
    	}
    	int[][] ra = new int[m+1][n+1];
    	int mm = m;
    	int nn = n;
    	// perform rotations
    	for(int i = 0;i<pos_m;i++){
    		for(int j = 0;j<pos_n && nn!=0;j++){
    			int d = 2*(mm+nn)-4;
    			String[] s = pos[i][j].split("-");
    			int ii = Integer.valueOf(s[0]);
    			int jj = Integer.valueOf(s[1]);
    			 s = pos[i][(rot+j)%d].split("-");
    			int ti = Integer.valueOf(s[0]);
    			int tj = Integer.valueOf(s[1]);
    			ra[ti][tj] = a[ii][jj];
    		}

			mm=mm-2;
			nn=nn-2;
			pos_n = 2*(mm+nn)-4;
    	}
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			System.out.print(ra[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}