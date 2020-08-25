import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class The_Full_Counting_sort {

		//UN CASO DA FUERA DE TIEMPO
		
    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
      Map<Integer,List<String>> mp = new HashMap<>();
      for(int i = 0;i<arr.size();i++){
        if(mp.containsKey(Integer.parseInt(arr.get(i).get(0)))){
          List<String> lsaux = mp.get(Integer.parseInt(arr.get(i).get(0)));
          if(i<arr.size()/2){
            lsaux.add("-");
            mp.put(Integer.parseInt(arr.get(i).get(0)),lsaux);
          }else{
            lsaux.add(arr.get(i).get(1));
            mp.put(Integer.parseInt(arr.get(i).get(0)),lsaux);
          }
        }else{
          List<String> ls = new ArrayList<>();
          if(i<arr.size()/2){
            ls.add("-");
            mp.put(Integer.parseInt(arr.get(i).get(0)),ls);
          }else{
            ls.add(arr.get(i).get(1));
            mp.put(Integer.parseInt(arr.get(i).get(0)),ls);
          }
        }
      }
      boolean first = true;
      for(Integer n: mp.keySet()){
        for(String s: mp.get(n)){
          if(first){
            first = false;
            System.out.print(s);
          }else{
            System.out.print(" " + s);
          }
        }
      }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}
