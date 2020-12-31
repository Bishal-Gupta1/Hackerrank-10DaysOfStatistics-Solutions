import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
   
class Pair {
    public final int    index;
    public final double value;
    
    public Pair(int index, double value) {
        this.index = index;
        this.value = value;
    }
   
    public static int[] getRank(double[] arr){
        int rank=0,n=arr.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) 
            pair[i] = new Pair(i, arr[i]);
       
        Arrays.sort(pair, new compareByValue());
        int [] ranks = new int[n];
        for (Pair p : pair) 
            ranks[p.index] = ++rank;
        
        return ranks;
    }
}
class compareByValue implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (Math.abs(p1.value - p2.value) < 0.01) return 0;
        if (p1.value < p2.value) return -1;
        else return 1;
      
    }
}

public class Solution {

    static double spearmanRankCorr(int[] Rx, int [] Ry, int n){
        int Di=0;
        for(int i=0;i<n;++i)
            Di+= Math.pow(Rx[i]-Ry[i],2);
             
        return 1-(6*Di)/(Math.pow(n,3)-n);
    }
    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());  
        StringTokenizer X = new StringTokenizer(br.readLine());
        StringTokenizer Y = new StringTokenizer(br.readLine());
        double[] Xs = new double[n];
        double[] Ys = new double[n];
    
        for(int i=0;i<n;++i){
             Xs[i]=Double.parseDouble(X.nextToken()); 
             Ys[i]=Double.parseDouble(Y.nextToken());
        }
        int[] Rx = Pair.getRank(Xs);
        int[] Ry = Pair.getRank(Ys);
        System.out.println(digitScale(spearmanRankCorr(Rx,Ry,n),3));
       
    }
}
