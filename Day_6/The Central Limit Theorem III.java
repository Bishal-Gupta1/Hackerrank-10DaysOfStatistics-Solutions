import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    }
    public static void main(String[] args) {
        System.out.println(digitScale(500-(80/Math.sqrt(100))*1.96,2));
        System.out.println(digitScale(500+(80/Math.sqrt(100))*1.96,2));
    }
}
