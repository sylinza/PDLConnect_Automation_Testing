package com.pdl.utilities;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtil {
	
	public static ArrayList<Integer> randomListOfNumberInt(int testingRecordCount,int totalRecordCount) {
		
		ArrayList<Integer> listUniqueRecord = new ArrayList<>();
		for (int i = 1; i <= testingRecordCount; i++) {
		
			Random rd= new Random();
			int rdCountInt = rd.nextInt(totalRecordCount);
			
			if(rdCountInt<2) {
				rdCountInt++;
			}

			if (rdCountInt > 0 && rdCountInt <= totalRecordCount) {

				listUniqueRecord.add(rdCountInt);

				// Collections.sort(this.list);
				int listSize = listUniqueRecord.size();

				CollactionUnit.sortListInt(listUniqueRecord);
			int	 listSizeWithUnique = listUniqueRecord.size();

				if (listSize > listSizeWithUnique) {
					i = i - 1;
				}

			}

		}
		return listUniqueRecord;
	}

}
