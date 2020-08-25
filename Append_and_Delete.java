	//Idea inicial
	 /*static String appendAndDelete(String s, String t, int k) {
	      int res = 0;
	      int x = s.length();
	      String SiNo= "";
	      if(s.length()<t.length()){
	        x = t.length();
	      }
	      String[] s1 = new String[x];
	      String[] s2 = new String[x];
	      int v = 0;
	      for(String c : s.split("")){
	        s1[v] = c;
	        v++;
	      }
	      v = 0;
	      for(String c : t.split("")){
	        s2[v] = c;
	        v++;
	      }
	      boolean b = false;
	      for(int i = 0;i<x;i++){
	        if(b==true && s1[i]!=null && s2[i]!=null){
	          res+=2;
	        }else if(b==true){
	          res++;
	        }else if(s1[i]==null || s2[i]==null || !s1[i].equals(s2[i])){
	          b=true;
	          res += 2;
	        }
	        System.out.println(res);
	      }
	      if(res!=k){
	        SiNo = "No";
	      }else{
	        SiNo = "Yes";
	      }
	      System.out.println(res);
	      return SiNo;
	    }
	    */
	//Resolucion vista en comentarios(comprobando casos, sin recorrer todos los elementos y hacer un acumulador)
	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.regex.*;

	public class Append_and_Delete {

	    // Complete the appendAndDelete function below.
	    static String appendAndDelete(String s, String t, int k) {
	      int SizeSum = s.length() + t.length();
	      String res = "";
	      int i;
	      for(i = 0; i<s.length() && i<t.length() && s.charAt(i)==t.charAt(i);i++){} // Obtenemos i que es la cantidad de letras iguales
	      System.out.println(i);
	      if(SizeSum <= k + i*2 && SizeSum%2==k%2 || SizeSum < k ){
	        res = "Yes";
	      }else{
	        res = "No";
	      }
	      return res;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String s = scanner.nextLine();

	        String t = scanner.nextLine();

	        int k = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String result = appendAndDelete(s, t, k);

	        bufferedWriter.write(result);
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}
