import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)a[i] = scan.nextInt();
        
        boolean found = false;
        int sp = 0;
        int ep = n-1;
        int mp;
        
        while(!found && sp< n && ep < n){
            if(V == a[sp]) {System.out.println(sp);break;}
            if(V == a[ep]) {System.out.println(ep);break;}
            
            mp = (ep+sp)/2;
            if(V <= a[mp]){
                ep = mp;
            }else{
                sp = mp +1;
            }
        }
    }
}
