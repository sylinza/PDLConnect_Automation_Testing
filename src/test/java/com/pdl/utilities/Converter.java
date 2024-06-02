package com.pdl.utilities;

import java.text.DecimalFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Converter {
	public static final Logger logger = LogManager.getLogger(Converter.class);
	
	
	
	public static String DecimalFormatDoubletoString(Double amount) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return df.format(amount);
	}
	public static String Decimal4FormatDoubletoString(Double amount) {
		DecimalFormat df = new DecimalFormat("0.0000");
		
		return df.format(amount);
	}
	public static double stringToDollar(String amount) {
	 
		return Double.valueOf(amount.substring(1));
	}
	public static double stringToDollarWithout$(String amount) {
		return Double.valueOf(amount);
	}
	public static double stringToDoubleWithout$(String amount) {
		return Double.valueOf(amount);
	}
	
	public static double stringToDollarwithout$(String amount) {
		return Double.valueOf(amount);
	}
	public static Integer stringToInt(String amount) {
		return Integer.valueOf(amount);
	}
	public static Long stringToLong(String amount) {
		return Long.valueOf(amount);
	}
	
	public static double stringToDollarNegative(String amount) {
		return Double.valueOf(amount.substring(2,amount.indexOf('.')+3));
	}
	public static double stringToDollarNegativeOne(String amount) {
		return Double.valueOf(amount.substring(2,amount.indexOf('.')+2));
	}
	public static String stringToDollarNo$OneDec(String amount) {
		int n=amount.length();
		
		
		if(n-amount.indexOf('.')==2) {
			amount =amount.concat("0");
			return amount;
		}
		
		return amount;
				
	}
	public static String stringToDollarNo$OneDec1(String amount) {
		int n=amount.length();
		System.out.print("lingth of teh amount from cognos "+n);
		System.out.print("index . "+ amount.indexOf('.'));
		if(n-amount.indexOf('.')==2) {
			amount =amount.concat("0");
			return amount;
		}
		
		return amount;
				
	}
	
	
	public static String stringNumberWithoutDotToOrWithOneDecToTwoDec(String numberWithOutDoteOrwith1dec) {
		
		// 1 to 1:00 ,  1.1 to 1.10 , 1.223542 to 1.22
		
		logger.info("Before: "+numberWithOutDoteOrwith1dec);
		if(numberWithOutDoteOrwith1dec.equals("null")) {
			numberWithOutDoteOrwith1dec="0";
		}
	
			int sizeOfNumber=numberWithOutDoteOrwith1dec.length();
			logger.info("Size Of Number: "+sizeOfNumber);
			
			if(numberWithOutDoteOrwith1dec.contains(".")) {
				
		
				int indexOFDote= numberWithOutDoteOrwith1dec.indexOf('.');
				 logger.info("indexOFDote: "+indexOFDote);
			if(sizeOfNumber==(indexOFDote+2)) {
				numberWithOutDoteOrwith1dec=numberWithOutDoteOrwith1dec+"0";
			}else if (sizeOfNumber>(indexOFDote+3)) {
				numberWithOutDoteOrwith1dec=numberWithOutDoteOrwith1dec.substring(0, indexOFDote+3);
			}	
			}else {
				// TODO Auto-generated catch block
				logger.info("There is no dote in the number. ");
				numberWithOutDoteOrwith1dec=numberWithOutDoteOrwith1dec+".00";
			}
		
			logger.info("After: "+numberWithOutDoteOrwith1dec);
	
		return numberWithOutDoteOrwith1dec;		
	}
	
	
	//0>0.00
	public static double stringToDollarTwo(String amount) {
		
		return Double.valueOf(amount.substring(1,amount.indexOf('.')+3));
	}
	public static double stringToDollarOne(String amount) {
		return Double.valueOf(amount.substring(1,amount.indexOf('.')+2));
	}
	
	public static Double asDoubleFromObject(Object o) {
	    Double val = null;
	    if (o instanceof Number) {
	        val = ((Number) o).doubleValue();
	    }
	    return val;
	}
	public static String negativeWith$(String numberNegwith$) {
		 if(numberNegwith$.contains("$")) {
			 numberNegwith$=numberNegwith$.replace("$", "");
		 }
		 if(numberNegwith$.contains(",")) {
			 numberNegwith$=numberNegwith$.replace(",", "");
		 }
		 
		 if(  numberNegwith$.contains("(")) {
       	 int indexOfLastChar= numberNegwith$.length()-1;
       	
       	 numberNegwith$=numberNegwith$.substring(1, indexOfLastChar);
         }else {
       	  numberNegwith$=numberNegwith$;
         }
           logger.info(numberNegwith$);
           return numberNegwith$;
	}
	public static String negativeWithAddMinus$(String numberNegwith$) {
		 if(numberNegwith$.contains("$")) {
			 numberNegwith$=numberNegwith$.replace("$", "");
		 }
		 if(numberNegwith$.contains(",")) {
			 numberNegwith$=numberNegwith$.replace(",", "");
		 }
		 
		 if(  numberNegwith$.contains("(")) {
      	 int indexOfLastChar= numberNegwith$.length()-1;
      	
      	 numberNegwith$="-"+numberNegwith$.substring(1, indexOfLastChar);
        }else {
      	  numberNegwith$=numberNegwith$;
        }
          logger.info(numberNegwith$);
          return numberNegwith$;
	}
	public static String negativePositiveWith$andMore(String negativePositive) {
		
		if(negativePositive.contains(".")) {
			 int indexOfLastChar=negativePositive.length()-1;
			 if(indexOfLastChar==(negativePositive.indexOf(".")+2)) {
				
				 negativePositive=negativePositive;
			 }else if( indexOfLastChar==(negativePositive.indexOf(".")+1)){
				 negativePositive=negativePositive+"0";
			 }else if( indexOfLastChar>(negativePositive.indexOf(".")+2)) {
				 logger.info("Number from the sheet:  "+negativePositive);
				 negativePositive=negativePositive;
			
		}
		} else  {
			 negativePositive=negativePositive+".00";
		 }
		return negativePositive;
	}

	public static double stringToDollarTwoNo$(String amount) {
		return Double.valueOf(amount.substring(0,amount.indexOf('.')+3));
	}
}
