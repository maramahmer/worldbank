/**Represents an AGEEAnalysis (Average Forest Area)
*
*/

public class FAAnalysis extends Analysis {
	private Data forestArea;
	/**
    *@param FAAnalysis Contructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public FAAnalysis(Selection select) {
		super(select);
        forestArea = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		forestArea.setDataType("Forest Area");
        forestArea.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the forestArea objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setForestArea(float[] values) {
		forestArea.setValues(values);
	}
	   /**
    *@param used to get the data object forestArea 
    *@return the data object representing forestArea
    */
	public Data getForestArea() {
		return forestArea;
	}
	  /**
    *@param prints the values and years of the FAAnalysis
    *@return the string representation of the FAAnalysis
    */
	public String toString(){
        String perYearReport = "";
        for(int i = getForestArea().getYears().length - 1; i>=0; i--){
            perYearReport = perYearReport + "Year: " + getForestArea().getYears()[i] + "\n\n"
            + "  Forest Area (% of Land Area): " +(getForestArea().getValues()[i] + "\n\n");
        }
        String returnString = forestArea.getDataType() + "\n"
        + "===============================\n"
        + perYearReport;
        return returnString;
	}

}
