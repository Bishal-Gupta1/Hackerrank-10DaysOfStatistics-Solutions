import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

class LSM{
    private final double a;
    private final double b;
     
    LSM(double a, double b){
        this.a=a;
        this.b=b;
    }    
    public double yRegressionLine(double X){
        return this.a + (this.b * X);
    } 
}
public class Solution {

    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    }
    
    public static void main(String[] args) throws IOException {
        int n=5;
        int[] X = {95,85,80,70,60};  
        int[] Y = {85,95,70,65,70};
      
        int sumX=0,sumY=0, sumXY=0, sumX2=0;
        for(int i=0;i<n;++i){
            sumX+=X[i];
            sumY+=Y[i];
            sumXY+=(X[i]*Y[i]);
            sumX2+=(X[i]*X[i]);
        } 
        double meanX = (double)sumX/n;
        double meanY = (double)sumY/n;
        double b =(double)((n*sumXY) - (sumX * sumY)) / ((n*sumX2) - (sumX*sumX)) ;
        double a = meanY - (b * meanX) ;
        
        System.out.println(digitScale(new LSM(a,b).yRegressionLine(80),3));
       
    }
}
