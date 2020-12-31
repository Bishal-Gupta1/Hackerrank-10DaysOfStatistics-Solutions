import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Solution {
    
    static double pearsonCorr(double[] Xs, double[] Ys, double meanX,double meanY){
        double sqDisX=0.0, sqDisY=0.0;
        double numer=0.0, dinomX=0.0, dinomY=0.0;
        for(int i=0;i<Xs.length;++i){
            sqDisX = (Xs[i] - meanX);
            sqDisY = (Ys[i] - meanY);
            
            numer  += (sqDisX * sqDisY);
            dinomX += (sqDisX * sqDisX);
            dinomY += (sqDisY * sqDisY); 
        }
      return numer / Math.sqrt(dinomX * dinomY);
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
        double sumX=0.0, sumY=0.0;
        for(int i=0;i<n;++i){
             Xs[i]=Double.parseDouble(X.nextToken()); 
             Ys[i]=Double.parseDouble(Y.nextToken());
             sumX+=Xs[i];
             sumY+=Ys[i];  
        }
        double meanX = sumX/n, meanY=sumY/n;  
        System.out.println(digitScale(pearsonCorr(Xs,Ys,meanX,meanY),3));
       
    }
}
