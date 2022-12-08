/**Represents an CDGDPAnalysis (Ratio of CO2 emissions vs GDP)
*
*/

public class CDGDPAnalysis extends Analysis {
	private Data CDEmissions, GDP;
	/**
    *@param CDGDPAnalysis Constructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public CDGDPAnalysis(Selection select) {
		super(select);
        CDEmissions = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		CDEmissions.setDataType("C02 Emissions");
        CDEmissions.setYears(this.calculateYearValues());

        GDP = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		GDP.setDataType("GDP");
        GDP.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the CDEmissions objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setCDEmissions(float[] values) {
		CDEmissions.setValues(values);
	}
	/**
    *@param sets the GDP objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setGDP(float[] values) {

		GDP.setValues(values);
	}
	/**
    *@param used to get the data object CDEmissions 
    *@return the data object representing CDEmissions 
    */
	public Data getCDEmissions() {
		return CDEmissions;
	}
	
	/**
    *@param used to get the data object GDP 
    *@return the data object representing GDP 
    */
	public Data getGDP() {
		return GDP;
	}
	/**
    *@param prints the values and years of the CDGDPAnalysis
    *@return the string representation of the CDGDPAnalysis
    */
	public String toString(){
        String perYearReport = "";
        for(int i = getCDEmissions().getYears().length - 1; i>=0; i--){
            perYearReport = perYearReport + "Year: " + (getCDEmissions().getYears())[i] + "\n\n"
            + "  CD Emissions (metric tons per capita): " +(getCDEmissions().getValues()[i] + "\n")
            + "  GDP (per capita): " +(getGDP().getValues()[i] + "\n\n");
        }
        String returnString = "Ratio of CO2 Emissions vs GDP: " + "\n"
        + "===============================\n"
        + perYearReport;
        return returnString;
    }
	
	
	
}

