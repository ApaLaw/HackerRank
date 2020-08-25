import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sock_merchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
      Map<Integer,Integer> mp = new HashMap<>();
      int r = 0;
      for(int i:ar){
        if(mp.containsKey(i)){
          int aux = mp.get(i);
          mp.put(i,aux+1);
        }else{
          mp.put(i,1);
        }
      }
      for(Integer i:mp.keySet()){
        int cantidad = mp.get(i);
          r += cantidad/2;
      }
      return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
