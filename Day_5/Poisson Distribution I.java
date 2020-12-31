import java.io.*;
import java.util.*;
import java.math.*;


public class Solution {
    static double fact(int n){
        return n==0 ? 1 : n*fact(n-1);
    }
    static double poissonDis(int k, double avg){
        return Math.pow(avg,k)/(Math.pow(2.71828,avg)*fact(k));
    }
    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    } 
    public static void main(String[] args) {
        double avg = 2.5;
        int k=5;
        System.out.println(digitScale(poissonDis(k,avg),3));         
    }
}
