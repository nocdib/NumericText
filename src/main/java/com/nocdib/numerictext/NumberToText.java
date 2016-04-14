package com.nocdib.numerictext;

/**
 * <h1>Number To Text</h1>
 * NumberToText converts any whole number ranging from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 inclusive.
 * @author nocdib
 * @version 0.5
 * @since   2016-04-13
 */
public class NumberToText {

	private long mNum;
	private String mText;

	private static final long ONE_HUNDRED = 100L;
	private static final long ONE_THOUSAND = 1_000L;
	private static final long ONE_MILLION = 1_000_000L;
	private static final long ONE_BILLION = 1_000_000_000L;
	private static final long ONE_TRILLION = 1_000_000_000_000L;
	private static final long ONE_QUADRILLION = 1_000_000_000_000_000L;
	private static final long ONE_QUINTILLION = 1_000_000_000_000_000_000L;

	/**
	 * The constructor that accepts the number to be converted to English text
	 * @param num This is the number of type long
	 */
	public NumberToText(long num){
		mNum = num;
		mText = getText(mNum);
	}

	/**
	 * Converts the number into English text.
	 * @param num This is the number of type long
	 */
	protected String getText(long num){
		this.mNum = num;
		String numberText = "";
		// return "zero" if the number is 0
		if(num == 0){
			return this.mText = "Zero";
		}
		// return the Long.MIN_VALUE manually
		if(num == Long.MIN_VALUE){
			return this.mText = "Negative Nine Quintillion Two Hundred Twenty-Three Quadrillion Three Hundred Seventy-Two Trillion"
					            + " Thirty-Six Billion Eight Hundred Fifty-Four Million Seven Hundred Seventy-Five "
					            + "Thousand Eight Hundred Eight";
		}
		// append "negative" if the number is less than 0
		if(num<0){
			numberText += "Negative";
			num = Math.abs(num);
		}
		
		if(num/Math.pow(10, 18)>=1){
			numberText += " " + quintillion(num);
		}else if(num/Math.pow(10, 15)>=1){
			numberText += " " + quadrillion(num); 
		}else if(num/Math.pow(10, 12)>=1){
			numberText += " " + trillion(num);
		}else if(num/Math.pow(10, 9)>=1){
			numberText += " " + billion(num);
		}else if(num/Math.pow(10, 6)>=1){
			numberText += " " + million(num);
		}else if(num/Math.pow(10, 3)>=1){
			numberText += " " + thousand(num);
		}else if(num/Math.pow(10, 2)>=1){
			numberText += " " + hundred(num);
		}else if(num/Math.pow(10, 1)>=1){
			numberText += " " + ten(num);
		}else{
			numberText += " " + one(num);
		}
		return this.mText = numberText.trim();
	}

	/**
	 * Returns the instance variable mNum.
	 * @return mNum: The long representation of the number.
	 */
	public long getNum(){
		return this.mNum;
	}

	/**
	 * Returns the instance variable mText.
	 * @return mText: The text representation of the number.
	 */
	@Override
	public String toString(){
		return this.mText.trim();
	}

	/**
	 * Returns the text representation of numbers 1 - 9.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String one(long num){
		int number = (int) Math.abs(num);
		switch(number){
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:	
				break;
		}
		return "";	
	}

	/**
	 * Returns the text representation of numbers 10 - 99.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String ten(long num){
		int number = (int) Math.abs(num);
		// if the number is less than 10 then pass it on
		if(number < 10){
			return one(number);
		}
		// if the number is 10-19
		if(number >= 10 && number < 20){
			switch(number){
				case 19:
					return "Nineteen";
				case 18:
					return "Eighteen";
				case 17:
					return "Seventeen";
				case 16:
					return "Sixteen";
				case 15:
					return "Fifteen";
				case 14:
					return "Fourteen";
				case 13:
					return "Thirteen";
				case 12:
					return "Twelve";
				case 11:
					return "Eleven";
				case 10:
					return "Ten";
				default:	
					break;
			}
		}else{	//The number is between 20 and 99
			switch(number/10){
				case 9:
					return ("Ninety" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 8:
					return ("Eighty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 7:
					return ("Seventy" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 6:
					return ("Sixty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 5:
					return ("Fifty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 4:
					return ("Fourty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 3:
					return ("Thirty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				case 2:
					return ("Twenty" + (number % 10 > 0 ? "-":" ") + one(number % 10)).trim();
				default:
					break;
			}
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 100 - 999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String hundred(long num){
		int number = (int) Math.abs(num);
		// if the number is less than 100 then pass it on
		if(number < ONE_HUNDRED){
			return ten(number);
		}
		// if the number is 100-999
		if(number >= ONE_HUNDRED && number < ONE_THOUSAND){
			return (one(num/ONE_HUNDRED) + " Hundred " + ten(number % ONE_HUNDRED)).trim();
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000 - 9,999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String thousand(long num){
		int number = (int) Math.abs(num);
		// if the number is less than 1000 then pass it on
		if(number < ONE_THOUSAND){
			return hundred(number);
		}
		// if the number is 1000-999,999
		if (number >= ONE_THOUSAND && number < ONE_MILLION){
			return (hundred(num/ONE_THOUSAND) + " Thousand " + hundred(number % ONE_THOUSAND)).trim();
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000,000 - 999,999,999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String million(long num){
		int number = (int) Math.abs(num);
		// if the number is less than 1,000,000 then pass it on
		if(number < ONE_MILLION){
			return (thousand(number)).trim();
		}
		// if the number is 1,000,000-999,999,999
		if (number >= ONE_MILLION && number < ONE_BILLION) {
			return ((hundred(num / ONE_MILLION) + " Million " + thousand(number % ONE_MILLION)).trim());
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000,000,000 - 999,999,999,999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String billion(long num){
		num = Math.abs(num);
		// if the number is less than 1,000,000,000 then pass it on
		if(num < ONE_BILLION){
			return (million(num)).trim();
		}
		// if the number is 1,000,000,000-999,999,999,999
		if (num >= ONE_BILLION && num < ONE_TRILLION){
			return (hundred(num/ONE_BILLION) + " Billion " + million(num % ONE_BILLION)).trim();
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000,000,000,000 - 999,999,999,999,999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String trillion(long num){
		num = Math.abs(num);
		// if the number is less than 1,000,000,000,000 then pass it on
		if(num < ONE_TRILLION){
			return (billion(num)).trim();
		}
		// if the number is 1,000,000,000,000-999,999,999,999,999
		if (num >= ONE_TRILLION && num < ONE_QUADRILLION){
			return (hundred(num/ONE_TRILLION) + " Trillion " + billion(num % ONE_TRILLION)).trim();
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000,000,000,000,000 - 999,999,999,999,999,999.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String quadrillion(long num){
		num = Math.abs(num);
		// if the number is less than 1,000,000,000,000,000 then pass it on
		if(num < ONE_QUADRILLION){
			return (trillion(num)).trim();
		}
		// if the number is 1,000,000,000,000-999,999,999,999,999
		if (num >= ONE_QUADRILLION && num < ONE_QUINTILLION){
			return (hundred(num/ONE_QUADRILLION) + " Quadrillion " + trillion(num % ONE_QUADRILLION)).trim();
		}
		return "";
	}

	/**
	 * Returns the text representation of numbers 1,000,000,000,000,000 - 9,223,372,036,854,775,807.
	 * @param num Number of type long
	 * @return The text representation of the number.
	 */
	private String quintillion(long num){
		num = Math.abs(num);
		// if the number is less than 1,000,000,000,000,000,000 then pass it on
		if(num < ONE_QUINTILLION){
			return (quadrillion(num)).trim();
		}
		// if the number is 1,000,000,000,000 up to the Long.MAX_VALUE
		if (num >= ONE_QUINTILLION){
			return (hundred(num/ONE_QUINTILLION) + " Quintillion " + quadrillion(num % ONE_QUINTILLION)).trim();
		}
		return "";
	}

}