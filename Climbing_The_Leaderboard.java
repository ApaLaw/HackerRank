import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Climbing_The_Leaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
      int an =0;
      int a = 1;
      int[] ar = new int[alice.length];
      for(int i2=alice.length-1;i2>=0;i2--){
        int xa = scores.length;
        for(int i=an;i<scores.length;i++){
         if(alice[i2]>=scores[i] && i!=0){
           ar[i2]=a+1;
           xa = i;
           break;
         }else if(alice[i2]>=scores[i]){
           ar[i2]=a;
           xa = i;
           break;
         }else if(ar[i2]==0 && i==scores.length-1){
           if(scores[i]!=alice[i2]){
             ar[i2]=a+2;
           }else{
             ar[i2]=a+1;
           }
           xa = i;
           
         }else{
           if(i!=0 && scores[i]<scores[i-1] ){
             a++;
           }
         }
       }
       an = xa;

      }
      return ar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

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
