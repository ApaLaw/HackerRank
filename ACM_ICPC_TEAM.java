import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACM_ICPC_TEAM {

    // CODIGO MOMENTANEO, NO RESUELTO EN LOS TIEMPOS ESTIMULADOS
    static int[] acmTeam(String[] topic) {
      int max = 0;
      int count = 0;
      for(int i = 0;i<topic.length-1;i++){
        String[] s1 = topic[i].split("");
        for(int i2=i+1 ;i2<topic.length;i2++){
          String[] s2 = topic[i2].split("");
          int aux = 0;
          for(int i3=0;i3<s1.length;i3++){
            if(s1[i3].equals("1")||s2[i3].equals("1")){
              aux++;
            }
          }
          if(aux>max){
            max=aux;
            count=1;
          }else if(aux==max){
            count++;
          }
        }
      }
      int[] res = new int[2];
      res[0]=max;
      res[1]=count;
      return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
