import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Extra_Long_Factorials___BigInteger_Problem {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
      BigInteger r = BigInteger.valueOf(1L);
      for(long i = 2;i<=n;i++){
        r= r.multiply(BigInteger.valueOf(i));
      }
      System.out.println(r);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
