/**Represents an AGEEAnalysis (Average Government expenditure on education analysis)
*
*/
public class AGEEAnalysis extends Analysis{
	private Data govExpendEdu;
	
	/**
    *@param AGEEAnalysis Constructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public AGEEAnalysis(Selection select) {
		super(select);
		govExpendEdu = new Data(select.getEndYear() - select.getStartYear() + 1);
		govExpendEdu.setYears(calculateYearValues());
		govExpendEdu.setDataType("Average of Government expenditure on education");
		
	}
	
	/**
    *@param sets the government expenditure on education data objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setGovExpendEdu(float[] values) {
		govExpendEdu.setValues(values);
	}
	
    /**
    *@param used to get the data object govExpendEdu 
    *@return the data object representing government expenditure on education 
    */
	public Data getGovExpendEdu() {
		return govExpendEdu;
	}
	
    /**
    *@param prints the values and years of the AGEEAnalysis
    *@return the string representation of the AGEEAnalysis
    */
	public String toString(){
        String perYearReport = "";
        
        for(int i = getGovExpendEdu().getYears().length - 1; i >= 0; i--){
            perYearReport = perYearReport + "Year: " + (getGovExpendEdu().getYears())[i]  + "\n\n" 
            + "  Government expenditure on education(% of GDP): " + (getGovExpendEdu().getValues())[i] + "\n\n";
        }

        String returnString = govExpendEdu.getDataType() + "\n" 
        + "========================\n"
        + perYearReport;
        return returnString;
    }
	
	
}
