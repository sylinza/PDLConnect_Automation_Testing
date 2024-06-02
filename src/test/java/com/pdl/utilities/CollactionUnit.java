package com.pdl.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CollactionUnit {
	public static final Logger logger = LogManager.getLogger(CollactionUnit.class);
	
	
	public static void sortListString(ArrayList<String> arrayListString) {
		Set<String> hashSetList= new HashSet<String>(arrayListString);
		logger.info("Unique value HashSetList"+hashSetList);
	}
	public static void sortListLong(ArrayList<Long> arrayListLong) {
		Set<Long> hashSetListLong= new HashSet<Long>(arrayListLong);
		logger.info("Unique value HashSetList"+hashSetListLong);
	}
		
	public static void sortListInt(ArrayList<Integer> arrayListLong) {
		Set<Integer> hashSetListInteger= new HashSet<Integer>(arrayListLong);
		//logger.info("Unique value HashSetList"+hashSetListInteger);
	}
}
