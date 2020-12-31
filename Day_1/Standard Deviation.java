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
        int  n = Integer.parseInt(br.readLine());   
        double sum = 0;
        StringTokenizer x = new StringTokenizer(br.readLine());
        double[] num = new double[n];
        
        for(int i=0;i<n;++i){
             num[i]=Double.parseDouble(x.nextToken());  
             sum+=num[i];            
        }
        double mean = sum/n ;
        
        sum=0;
        for(int i=0;i<n;++i)
               sum+=Math.pow(num[i] - mean , 2);
                         
        System.out.println(oneDigitScale(Math.sqrt(sum/n)));
       
    }
}
