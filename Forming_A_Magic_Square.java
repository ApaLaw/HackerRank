import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Forming_A_Magic_Square {

    // Complete the formingMagicSquare function below.
    static int[][] pre = new int[][]{
    {816, 357, 492},
    {618, 753, 294},
    {492, 357, 816},
    {294, 753, 618},
    {834, 159, 672},
    {438, 951, 276},
    {672, 159, 834},
    {276, 951, 438}
};
static int formingMagicSquare(int[][] s) {
    int min = 45;
    int[] p_row = new int[3];
    int cost, k, i, j;
    int[] p;

    for (i = 0; i < pre.length; i++) {
        p = pre[i];
        cost = 0;
        for (k = 0; k < 3; k++) {
            p_row[0] = (int)(p[k] % 1000 / 100);
            p_row[1] = (int)(p[k] % 100 / 10);
            p_row[2] = p[k] % 10;
            for (j = 0; j < 3; j++) {
                cost += p_row[j] == s[k][j] ? 0 : Math.abs(p_row[j] - s[k][j]);
            }
        }
        min = Math.min(cost, min);
    }

    return min;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
