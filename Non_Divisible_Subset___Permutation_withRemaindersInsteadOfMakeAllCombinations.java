import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result2 {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
      int[] remainders = new int[k];
      int count = 0;

      // Count the # of numbers that have each remainder
      for (int i = 0; i < s.size(); i++) {
          remainders[s.get(i) % k]++;
      }

      // Get our counts of each category
      for (int j = 1; j <= (k / 2); j++) {            
          // if the remainders are the same (i.e. k / 2),
          // there can be only 1
          if (j == k - j) {
              count++;
              continue;
          }

          // Otherwise, add the remainder with the
          // highest count
          count += Math.max(remainders[j], remainders[k - j]);    
      }

      // If we had one or more evenly divisible numbers,
      // there can be only 1
      if (remainders[0] > 0)
          count++;

      return count;

    }

}

public class Non_Divisible_Subset___Permutation_withRemaindersInsteadOfMakeAllCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result2.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
