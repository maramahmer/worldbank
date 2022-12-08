/**
* The selection class initializes the parameters which will be used to request data from an external database.
* It will also verify if the parameters are valid and will actually return data.
* @author Group 1 CS2212
*/
public class Selection {
	private int yearStart = 0; 
	private int yearEnd = 0;
	private String country, analysisType;
  
    /**
    *@param yStart
    *@param yEnd
    *@param count
    *@param aType
    *Sets the intitial user selection
    */   
	public Selection(int yStart, int yEnd, String count, String aType){
		yearStart = yStart;
		yearEnd = yEnd;
		country = count;
		analysisType = aType;
	}
	
	public Selection() {
		
	}
    /**
    *@param yStart sets the start year for the selection object to the new start year
    */    
	public void setStartYear(int yStart){
		yearStart = yStart;
	}
    /**
    *@param yEnd sets the end year for the selection object to the new end year
    */  
	public void setEndYear(int yEnd){
		yearEnd = yEnd;
	}
    /**
    *@param count sets the country for the selection object to the new country
    */ 
	public void setCountry(String count){
		country = count;
	}
    /**
    *@param aType sets the analysis type for the selection object to the new analysis type
    */
	public void setAnalysisType(String aType){
		analysisType = aType;
	}
  
    /**
    *@return the selected start year of the analysis 
    */
	public int getStartYear(){
		return yearStart;
	}
    /**
    *@return the selected end year of the analysis
    */
	public int getEndYear(){
		return yearEnd;
	}
    /**
    *@return the selected country for the analysis
    */
	public String getCountry(){
		return country;
  }
    /**
    *@return the selected analysis type 
    */
	public String getAnalysisType(){
		return analysisType;
  }


}


