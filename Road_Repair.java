import java.util.Comparator;
import java.util.List;

public class Road_Repair {
	//JAVA 8
	
	public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
	      long res = 0;
	      crew_id.sort(Comparator.naturalOrder());
	      job_id.sort(Comparator.naturalOrder());
	      for(int i = 0;i<crew_id.size();i++){
	        res += Math.abs(crew_id.get(i)-job_id.get(i));
	      }
	      return res;

	    }

}
