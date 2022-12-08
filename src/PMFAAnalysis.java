/**Represents an PMFA Analysis (PM2.5 pollution vs Forest Area analysis)
* @author Group 1 CS2212
*/
public class PMFAAnalysis extends Analysis {
	private Data PMPollution, forestArea;
	
    /**
    *@param PMFAAnalysis Contructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public PMFAAnalysis(Selection select) {
		super(select);

        PMPollution = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		PMPollution.setDataType("PM2.5 Pollution");
        PMPollution.setYears(this.calculateYearValues());

        forestArea = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		forestArea.setDataType("Forest Area");
        forestArea.setYears(this.calculateYearValues());
	}
	
    /**
    *@param sets the PM2.5 pollution data objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setPMPollution(float[] values) {
		PMPollution.setValues(values);
	}
	
    /**
    *@param sets the Forest Area data objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setForestArea(float[] values) {
		forestArea.setValues(values);
	}
	  /**
    *@param used to get the data object PMPollution
    *@return the data object representing PMPollution
    */
	public Data getPMPollution() {
		return PMPollution;
	}
	  /**
    *@param used to get the data object forestArea
    *@return the data object representing forestArea
    */
	public Data getForestArea() {
		return forestArea;
	}
	 /**
    *@param prints the values and years of the PMFAAnalysis
    *@return the string representation of the PMFAAnalysis
    */
	public String toString(){
        String perYearReport = "";
        for(int i = getPMPollution().getYears().length - 1; i>=0; i--){
            perYearReport = perYearReport + "Year: " + (getPMPollution().getYears())[i] + "\n\n"
            + "  PM 2.5 Pollution (micrograms per cubic meter): " +(getPMPollution().getValues()[i] + "\n")
            + "  Forest Area (% of land area): " +(getForestArea().getValues()[i] + "\n\n");
        }
        String returnString = "PM 2.5 Pollution vs Forest Area: " + "\n"
        + "===============================\n"
        + perYearReport;
        return returnString;
    }
	
}