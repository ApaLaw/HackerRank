import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class String_Anagram {
	//COMPILA BIEN, PERO NO DENTRO DE LOS LIMITES DE TIEMPO

	public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
	      int r = 0;
	      Map<Integer,String> mp = new HashMap<>();
	      List<Integer> res = new ArrayList<>();
	      for(int i = 0;i<query.size();i++){
	        r=0;
	        char tempArray[] = query.get(i).toCharArray(); 
	        Arrays.sort(tempArray); 
	        String comprobar = new String(tempArray); 
	        for(int i2 = 0;i2<dictionary.size();i2++){
	          if(!mp.containsKey(i2)){
	            char tempArray2[] = dictionary.get(i2).toCharArray(); 
	            Arrays.sort(tempArray2); 
	            String comprobar2 = new String(tempArray2); 
	            mp.put(i2, comprobar2);
	          }
	          if(query.get(i).length()==dictionary.get(i2).length()){
	            String comprobar2 = mp.get(i2);
	            if(comprobar2.contains(comprobar)){
	              r++;
	            }
	          }
	        }
	        res.add(r);
	      }
	      return res;
	    }
}
