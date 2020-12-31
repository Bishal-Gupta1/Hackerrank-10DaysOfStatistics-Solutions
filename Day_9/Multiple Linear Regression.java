import java.io.*;
import java.util.*;
import java.math.*;

class MatrixOperation {
    public static double[][] transpose(double[][] matrix) {
        int r= matrix.length, c=matrix[0].length;
        double [][] tMatrix = new double[c][r] ; 
        for (int i=0;i<r;i++) 
            for (int j=0;j<c;j++) 
               tMatrix[j][i]= matrix[i][j];
        
        return tMatrix;
    }
    public static double[][] multiply(double [][] A, double [][] B) {    
        int r= A.length, c=B[0].length;
        double [][] mul =new double[r][c] ;   
        for (int i = 0; i<r; ++i) {
            for (int j = 0; j<c; ++j){
                for (int k = 0; k < B.length; ++k){ 
                    mul[i][j] += A[i][k] * B[k][j];
                }
            }        
        }                  
        return mul;
    }
    
    public static double[][] inverse(double[][] matrix){
        // using Gauss Jordan method to find inverse   
        int order = matrix.length;
        int newCol = order<<1;  
        double[][] augMatrix = new double[order][newCol];
        double temp;
        //creating augmented matrix
        for (int i = 0; i < order; i++){
            augMatrix[i][i + order] = 1;
            for (int j = 0; j < order; j++)
                augMatrix[i][j] = matrix[i][j];
        } 
        // Interchange the row of matrix,
        // interchanging of row will start from the last row
        for (int i = order - 1; i > 0; i--) {
            if (augMatrix[i - 1][0] < augMatrix[i][0]) {
                for (int j = 0; j < 2 * order; j++) {
                    temp = augMatrix[i][j];
                    augMatrix[i][j] = augMatrix[i - 1][j];
                    augMatrix[i - 1][j] = temp;
                }
            }  
        }
        // Replace a row by sum of itself and a
        // constant multiple of another row of the matrix
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (j != i) { 
                    temp = augMatrix[j][i] / augMatrix[i][i];
                    for (int k = 0; k < 2 * order; k++) {
                        augMatrix[j][k] -= augMatrix[i][k] * temp;
                    }
                }
            }
        }
        // Multiply each row by a nonzero integer.
        // Divide row element by the diagonal element
        for (int i = 0; i < order; i++) { 
            temp = augMatrix[i][i];
            for (int j = 0; j < 2 * order; j++) {
                augMatrix[i][j] = augMatrix[i][j] / temp;
            }
        }
        //extracting value of inverse matrix from above resultant matrix
        for (int i = 0; i < order; i++) 
            for (int j = order; j < newCol; j++) 
                 matrix[i][j-order]=augMatrix[i][j];
        
    return matrix;
}

}
public class Solution {

    static double digitScale(double d, int scale ){
        double factor = Math.pow(10,scale);
        return Math.round(d * factor) / factor; 
    }
    
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       StringTokenizer st = new StringTokenizer(br.readLine());
       int m = Integer.parseInt(st.nextToken());
       int n = Integer.parseInt(st.nextToken());
       double[][] X = new double[n][m+1];
       double[][] Y = new double[n][1];
      
       for(int i=0;i<n;++i){
            st = new StringTokenizer(br.readLine());
            X[i][0]=1;
            for(int j=1;j<=m;++j){
              X[i][j]=Double.parseDouble(st.nextToken());  
            }
            Y[i][0]=Double.parseDouble(st.nextToken());  
       } 
       
       double XT[][]  = MatrixOperation.transpose(X);
       double XtX[][] = MatrixOperation.multiply(XT,X);
       double res[][] = MatrixOperation.multiply(MatrixOperation.inverse(XtX),XT);
       double B[][]   = MatrixOperation.multiply(res,Y);
       
      
       int q = Integer.parseInt(br.readLine());
       int r = B.length;
       double ans = B[0][0];
       for (int i = 0; i < q; i++) { 
            st = new StringTokenizer(br.readLine());
            for (int row = 1; row < r; row++) {
                ans += Double.parseDouble(st.nextToken()) * B[row][0];
            }
            System.out.println(ans);
            ans = B[0][0];
        }
        
    }
}
