import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Equalize_the_Array {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
      Map<Integer,Integer> mp = new HashMap<>();
      for(int i : arr){
        if(mp.containsKey(i)){
          int aux = mp.get(i);
          mp.put(i,aux+1);
        }else{
          mp.put(i,1);
        }
      }
      int max = 0;
      int aux = 0;
      for(Integer c : mp.keySet()){
        if(mp.get(c)>aux){
          aux = mp.get(c);
          max = c;
        }
      }
      int res=0;
      for(Integer c : mp.keySet()){
        if(c!=max){
          res+=mp.get(c);
        }
      }
      return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
