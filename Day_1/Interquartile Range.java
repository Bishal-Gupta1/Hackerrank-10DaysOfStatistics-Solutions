import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Solution {
    
    static int quartile1(int[] nums, int halfLen){
       return median( Arrays.copyOfRange(nums,0,halfLen) , halfLen) ;
    }
    
    static int quartile3(int[] nums, int halfLen,int len){
        int l=halfLen;
        if((len&1)==1) ++halfLen;
     return median( Arrays.copyOfRange(nums,halfLen,len) , l) ;
    }
    
    static int median(int[] nums,  int n){
        int med = n>>1;
        return (n&1)==1 ? nums[med] :  (nums[med-1]+nums[med])/2; 
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());   
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); 
                
        for(int i=0;i<n;++i)
             nums[i]=Integer.parseInt(st.nextToken());
               
        Arrays.sort(nums);
        int halfLen = n>>1;
        
        System.out.println( quartile1(nums,halfLen));
        System.out.println( median(nums,n));
        System.out.println( quartile3(nums,halfLen,n));
    }
}
