import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
       
        // find LCM in A
        int _lcm = a[0];
        for(int i=1;i<n;i++){
            _lcm = lcm(_lcm,a[i]);
        }
        // find HCF in B
         
        int _hcf = b[0];
        for(int i=1;i<m;i++){
            _hcf = hcf(_hcf,b[i]);
        }
        
       
        int i= 1, ct =0, tmp;
        while(_lcm <= _hcf){
            tmp = _lcm *i;
            if(_hcf % tmp == 0) ct ++;
            if(tmp >= _hcf)break;
            i++;
        }
        
        System.out.println(ct); 
        
        
    }
    
    private static int lcm(int a, int b){
        return (a*b)/hcf(a,b);
    }
    
    private static int hcf(int a, int b){
       int s1 = Math.min(a,b);
       int s2 = Math.max(a,b);
       int hcf = s1, res;
       while(s1 > 0){
           hcf = s1; 
          
           res = s2-s1; 
           s2 = Math.max(s1,res);
           s1 = Math.min(s1,res); 
          
            
       }
       
        return hcf;
    }
}
