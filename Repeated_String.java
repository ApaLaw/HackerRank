import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Repeated_String {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
      int r = 0;
      long res = 0;
      for(String c : s.split("")){
        if(c.equals("a")){
          r++;
        }
      }
      res = ((n/s.length())*r);
      if(n%s.length()!=0){
        long escedente = n%s.length();
        String[] ar = s.split("");
        for(int i = 0;i<=escedente;i++){
          if(ar[i].equals("a")){
            res++;
          }
        }
      }
      return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
