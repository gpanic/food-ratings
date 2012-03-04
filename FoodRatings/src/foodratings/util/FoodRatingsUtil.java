package foodratings.util;

import java.util.List;

import foodratings.client.Ocena;

public class FoodRatingsUtil {
	
	public static double getAverageRating(List<Ocena> ratings) {
		double avg=0;
		for(Ocena o:ratings) {
			avg+=o.getOcena();
		}
		avg/=ratings.size();
		return avg;
	}

}
