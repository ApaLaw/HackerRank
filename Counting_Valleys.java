import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Counting_Valleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
      int nivel = 0;
      int valle = 0;
      int res = 0;
      String[] aux = s.split("");
      for(String c : aux){
        if(c.equals("D")){
          valle=1;
          nivel--;
        }else{
          nivel++;
          if(valle==1 && nivel == 1){
            res++;
            valle=0;
          }
        }
      }
      return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
