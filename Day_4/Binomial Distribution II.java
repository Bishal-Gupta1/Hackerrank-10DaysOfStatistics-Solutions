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
       double p = 0.12;
       double bP = 0.0;
       for(int i=0;i<=2;++i) bP+=binomialDis(i,10,p);
       System.out.println(digitScale(bP,3));
       bP=0.0;
       for(int i=2;i<=10;++i) bP+=binomialDis(i,10,p);
       System.out.println(digitScale(bP,3));       
    }
}
