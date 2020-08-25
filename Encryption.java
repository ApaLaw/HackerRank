import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
      int rows = (int) Math.sqrt(s.length());
      int columns = rows;
      if( Math.sqrt(s.length()) % 1 != 0){
        columns++;
      }
      String[] aux = new String[columns];
      for(int i = 0;i<columns;i++){
        aux[i] = "";
      }
      for(int i = 0;i<s.length();i++){
        aux[i%columns] = aux[i%columns] + s.charAt(i);
      }
      String res = "";
      boolean first = true;
      for(String c : aux){
        if(first){
          first = false;
        }else{
          res = res + " ";
        }
        res = res + c;
      }
      return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
