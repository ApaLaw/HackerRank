import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Modified_Kaprekar_Numbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
      int aux = 0;
      for(int i = p ;i<=q;i++){
        String cuadrado = String.valueOf((long) Math.pow(i,2));
        if(cuadrado.length()!=1){
          int beta = Integer.parseInt(cuadrado.substring(0,cuadrado.length()/2));
          int alfa = Integer.parseInt(cuadrado.substring(cuadrado.length()/2));
          if(beta+alfa==i){
            if(aux == 0){
              aux++;
              System.out.print(i);
            }else{
              System.out.print(" " + i);
            }
          }
        }else{
          if(i==1){
            aux++;
            System.out.print(i);
          }
        }
      }
      if(aux==0){
        System.out.print("INVALID RANGE");
      }
      

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
