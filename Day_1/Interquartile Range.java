import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class customStats{
      
     static double quartile1(double[] nums, int halfLen){
       return median( Arrays.copyOfRange(nums,0,halfLen), halfLen) ;
    }
    
    static double quartile3(double[] nums, int halfLen){ 
       int n=halfLen;
       if((halfLen&1)==1) ++halfLen;
       return median( Arrays.copyOfRange(nums,halfLen,nums.length),n);
    }
    
    static double median(double[] nums,int length ){
        int med = length>>1;
        return ( (length&1)==1 )? nums[med] : (nums[med-1]+nums[med])/2; 
    }
    
    static double oneDigitScale(double d){
        return Math.round(d * 10) / 10.0; 
    }
}
public class Solution {
    
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  len = Integer.parseInt(br.readLine());   
         int[] freqs = new int[len];   
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        StringTokenizer fr = new StringTokenizer(br.readLine()); 
         
        int sum=0;   
        for(int i=0;i<len;++i){
           freqs[i] = Integer.parseInt(fr.nextToken());
           sum+=freqs[i];
        }
        
        double[] dataSet = new double[sum];   
        double Q1,Q3, n;
        for(int k=0,i=0;i<len;++i){
          n = Double.parseDouble(st.nextToken());
          for(int j=0;j<freqs[i];++j,++k) 
            dataSet[k]=n;        
        } 
        Arrays.sort(dataSet);
        
        int halfLen = sum>>1;

        Q3=customStats.quartile3(dataSet,halfLen);
        Q1=customStats.quartile1(dataSet,halfLen); 
        
        System.out.println((Q3-Q1));     
    }
}

