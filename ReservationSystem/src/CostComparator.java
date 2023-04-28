import java.util.Comparator;

public class CostComparator implements Comparator<Services> {

	@Override
	public int compare(Services s1, Services s2) {
		
		double costCompare = s2.getCost() - s1.getCost();
		
		if(costCompare > 0) {
			return 1;
		}
		return -1;
	}
}
