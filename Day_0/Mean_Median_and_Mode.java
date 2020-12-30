import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Solution {

    static int calMode(int[] num){
        Map<Integer,Integer> nMap = new TreeMap(); 
       
        for(int n : num){ 
          if(nMap.containsKey(n)) nMap.put(n,nMap.get(n)+1);  
          else nMap.put(n,1);
        }
        int res=0, max = Collections.max(nMap.values());    

        for (Map.Entry e : nMap.entrySet()) {
            if (e.getValue()==max) {
                 res = (int)e.getKey();
                 break;
            }
        }
        
        return res;       
    } 
    
    static double calMedian(int[] num, int n){
        
        int med = n/2;
        return (n&1)==1 ? num[med] : oneDigitScale((double)(num[med-1]+num[med])/2);
    
    }
    
    static double oneDigitScale(double d){
        return Math.round(d * 10) / 10.0; 
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0, n = Integer.parseInt(br.readLine());   
        double Mean; 
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); 
                
        for(int i=0;i<n;++i){
             num[i]=Integer.parseInt(st.nextToken());
             sum+=num[i]; 
        }
       
        Mean = (double)sum/n ;
        Arrays.sort(num);
        
        System.out.println( oneDigitScale(Mean) );
        System.out.println( calMedian(num,n) );
        System.out.println( calMode(num) );
    }
}
