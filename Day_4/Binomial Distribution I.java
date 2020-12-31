import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
   
    static double fact(int n){
       return  n == 0 ? 1 :  n*fact(n-1);
    }
    static double comb(int n, int x){
      return fact(n) / (fact(x) * fact(n-x));
    }
    static double binomialDis(int x, int n, double p){
        return comb(n,x) * Math.pow(p,x) * Math.pow(1-p,n-x);
    }
    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    }
    public static void main(String[] args) {
       double p = 1.09/2.09 ;
       double bP = 0.0;
       for(int i=3;i<=6;++i) bP+=binomialDis(i,6,p);  
       System.out.println(digitScale(bP,3));
    }
}

