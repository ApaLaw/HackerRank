import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Queens_Attack_II {

    public static int siz;
    
    //CODIGO MOMENTANEO,NO DAN TODOS LOS RESULTADOS

    static int movimientos(int r , int q , int movx,int movy,int res,List<List<Integer>> obstacles){
      System.out.println(movx + " " + movy);
      while(true){
        System.out.println(res);
        List<Integer> ls = new ArrayList<>();
        ls.add(r+movx);
        ls.add(q+movy);
        if(r+movx>=siz || q+movy>=siz || r+movx<0 || q+movy<0 || obstacles.contains(ls) ){
          break;
        }else{
          r+=movx;
          q+=movy;
          res+=1;
        }
      }
      return res;
    }

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
      siz = n;
      int res = 0;
      res+=movimientos(r_q,c_q,1,0,0,obstacles);
      res+=movimientos(r_q,c_q,1,1,0,obstacles);
      res+=movimientos(r_q,c_q,0,1,0,obstacles);
      res+=movimientos(r_q,c_q,-1,0,0,obstacles);
      res+=movimientos(r_q,c_q,0,-1,0,obstacles);
      res+=movimientos(r_q,c_q,-1,-1,0,obstacles);
      res+=movimientos(r_q,c_q,1,-1,0,obstacles);
      res+=movimientos(r_q,c_q,-1,1,0,obstacles);
      return res;
      

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0])-1;

        int c_q = Integer.parseInt(r_qC_q[1])-1;

        List<List<Integer>> obstacles= new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            List<Integer> ls= new ArrayList<>();
            ls.add(Integer.parseInt(obstaclesRowItems[0])-1);
            ls.add(Integer.parseInt(obstaclesRowItems[1])-1);
            obstacles.add(ls);
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
