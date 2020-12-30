import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Solution {

    static double oneDigitScale(double d){
        return Math.round(d * 10) / 10.0; 
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0 , wSum=0 , n = Integer.parseInt(br.readLine());   
        
        StringTokenizer x = new StringTokenizer(br.readLine()); 
        StringTokenizer w = new StringTokenizer(br.readLine());         
        int Xi,Wi;
       
        for(int i=0;i<n;++i){
             Xi=Integer.parseInt(x.nextToken()); 
             Wi=Integer.parseInt(w.nextToken());
             sum+=(Xi*Wi);
             wSum+=Wi;
        }
       
        double Mean = (double)sum/wSum ;
        System.out.println( oneDigitScale(Mean) );
       
    }
}
