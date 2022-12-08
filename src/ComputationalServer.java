/**
* Computational server
* @author Group 1 CS2212
*/
public class ComputationalServer{
	private static ComputationalServer computationalServer = null;
	private Selection userSelection;
	private Analysis typedAnalysis, results;
	private DataCollector collector;

    /**
    * @param select made by user
    * If a computational server has not been initalized, initialize it
    * Else return initialized computational server
    */
	public static ComputationalServer getInstance(Selection select){
  		if(computationalServer == null)
  			computationalServer = new ComputationalServer(select);
    
    	return computationalServer;
	}
  
    /**
    * @param select made by user
    * Calls methods of computational server
    */
	private ComputationalServer(Selection select){ //call all methods of ComputationalServer here
		userSelection = select;
	}
	/**
    * @param select made by user
    * Sets analysis and final populated result
    */
	public void doSelection(Selection select) {
		typedAnalysis = new AnalysisFactory(select).create(select);
		results = new DataCollector().populateAnalysis(typedAnalysis); //final populated result	
	}

	/**
    * returns computed results
    * @return object of type Analysis
    */
	public Analysis getResults() {
		return results;
	}

	/**
    * Creates new analysis factory
    * @return object of type Analysis
    */
	public Analysis getEmptyAnalysis() {
		return typedAnalysis;
	}

	/**
    * Verification class to ensure country, years are valid
    * @return boolean true for valid selection, false for invalid
    */
	public boolean verify() {
		String country = userSelection.getCountry();
		int endYear = userSelection.getEndYear();
		int startYear = userSelection.getStartYear();
		
		if(country.equals("USA")){
			if((endYear >= 1981) && (endYear <= 2021) && (startYear >= 1981) && (startYear <= 2021) && (startYear >= endYear))
				return true;
			else
				return false;
		}
		
		else if(country.equals("ITA")){
			if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
				return true;
			else
				return false;
		}
		
		else if(country.equals("UGA")){
			if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
				return true;
			else
				return false;
		}
		
		else if(country.equals("IND")){
	        if((endYear >= 1975) && (endYear <= 2021) && (startYear >= 1975) && (startYear <= 2021) && (startYear >= endYear))
	            return true;
	        else
	            return false;
	    }
		
		else if(country.equals("JPN")){
	        if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
	            return true;
	        else
	            return false;
	    }
		
		else if(country.equals("CHN")){
	        if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
	            return true;
	        else
	            return false;
	    }
		
		else if(country.equals("BRA")){
	        if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
	            return true;
	        else
	            return false;
	    }
		
		else if(country.equals("CAN")){
            if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
                return true;
            else
                return false;
        }
		
		else if(country.equals("FRA")){
            if((endYear >= 1962) && (endYear <= 2021) && (startYear >= 1962) && (startYear <= 2021) && (startYear >= endYear))
                return true;
            else
                return false;
        }
		
		else
			return false;
		
		
		
	}
	
  
  	 
}