import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Cut_the_Sticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
      List<Integer> ls = new ArrayList<>();
      for(int i=0;i<arr.length;i++){
        ls.add(arr[i]);
      }
      Collections.sort(ls);
      int r = 0;
      List<Integer> lsres = new ArrayList<>();
      for(int i =0;i<ls.size() && ls.get(ls.size()-1)!=0;i++){
        int c = 0;
        if(ls.get(i)!=0){
          int valormin= ls.get(i);
          for(int i2=i;i2<ls.size();i2++){
            if(ls.get(i2)!=0){
              ls.set(i2,ls.get(i2)-valormin);
              c++;
            }
          }
          lsres.add(c);
        }
      }
      int[] res = new int[lsres.size()];
      for(int i = 0 ; i<lsres.size();i++){
        res[i] = lsres.get(i);
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
