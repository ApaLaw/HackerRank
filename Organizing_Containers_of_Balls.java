import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Organizing_Containers_of_Balls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

      List<Long> capacidades = new ArrayList<>();
      List<Long> objetos = new ArrayList<>();
      for(int i = 0;i<container.length;i++){
        objetos.add(0L);
      }
      for(int i = 0;i<container.length;i++){
        Long capacidad = 0L;
        for(int i2=0;i2<container.length;i2++){
          capacidad += container[i][i2];
          objetos.set(i2,objetos.get(i2)+container[i][i2]);
        }
        capacidades.add(capacidad);
      }
      capacidades.sort(Comparator.naturalOrder());
      objetos.sort(Comparator.naturalOrder());
      boolean res = true;
      for(int i = 0;i<capacidades.size();i++){
        if(!capacidades.get(i).equals(objetos.get(i)) ){
          res = false;
          break;
        }
      }
      if(res){
        return "Possible";
      }else{
        return "Impossible";
      }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
