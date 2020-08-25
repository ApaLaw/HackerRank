import java.math.BigInteger;
import java.util.Scanner;

public class Luxury_Hampers {
	//Intento de solucion
	 private static int gcd(int a, int b) {
		    BigInteger b1 = BigInteger.valueOf(a);
		    BigInteger b2 = BigInteger.valueOf(b);
		    BigInteger gcd = b1.gcd(b2);
		    return gcd.intValue();
		    }

		    public static void main(String[] args) {
		       Scanner sc = new Scanner(System.in);
		       int t = sc.nextInt();
		       int [] a = new int[t];
		       int [] b = new int[t];
		       int sumA = 0;
		       int sumB = 0;

		       int max = 0;
		       int min = Integer.MAX_VALUE;
		       for(int i = 0 ;i<t;i++){
		         int aux = sc.nextInt();
		         a[i] = aux;
		         sumA+=aux;
		         if(aux>max){
		           max = aux;
		         }
		         if(aux<min){
		           min = aux;
		         }
		       }
		       for(int i = 0 ;i<t;i++){
		         int aux = sc.nextInt();
		         b[i] = aux;
		         sumB+=aux;
		         if(aux>max){
		           max = aux;
		         }
		         if(aux<min){
		           min = aux;
		         }
		       }
		       int aca = 0;
		       int acb = 0;
		       for(int i = 0;i<t;i++){
		            if(a[i]==max){
		              aca+=max-1;
		            }else if(a[i]==min){
		              aca+=min;
		            }else{
		              aca+= (int) Math.ceil((double)a[i]/2);
		            }
		            if(b[i]==max){
		              acb+=max-1;
		            }else if(b[i]==min){
		              acb+=min;
		            }else{
		              acb+= (int) Math.ceil((double)b[i]/2);
		            }
		       }
		       System.out.println(aca);
		       System.out.println(sumA);
		       int d = aca*sumB;
		       int d2 = acb*sumA;
		       int aux = gcd(d,d2);
		       int r1 = d/aux;
		       int r2= d2/aux;
		       System.out.println(r1 + "/" + r2);

		    }
}
