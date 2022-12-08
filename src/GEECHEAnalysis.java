/**Represents an GEECHEAnalysis (Ratio of Government expenditure on education vs Current health expenditure)
* @author Group 1 CS2212
*/

public class GEECHEAnalysis extends Analysis {
	private Data govExpend, healthExpend;

	/**
    *@param GEECHEAnalysis Contructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public GEECHEAnalysis(Selection select) {
		super(select);
        govExpend = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		govExpend.setDataType("Government Expenditure per Capita");
        govExpend.setYears(this.calculateYearValues());

        healthExpend = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		healthExpend.setDataType("Current Health Expenditure");
        healthExpend.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the govExpend objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setGovExpend(float[] values) {
		govExpend.setValues(values);
	}
	/**
    *@param sets the healthExpend objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setHealthExpend(float[] values) {
		healthExpend.setValues(values);
	}
	   /**
    *@param used to get the data object GovExpend 
    *@return the data object representing govExpend
    */
	public Data getGovExpend() {
		return govExpend;
	}
	   /**
    *@param used to get the data object HealthExpend 
    *@return the data object representing healthExpend
    */
	public Data getHealthExpend() {
		return healthExpend;
	}
		  /**
    *@param prints the values and years of the GEECHEAnalysis
    *@return the string representation of the GEECHEAnalysis
    */
	public String toString(){
        String perYearReport = "";
        for(int i = getGovExpend().getYears().length - 1; i>=0; i--){
            perYearReport = perYearReport + "Year: " + getGovExpend().getYears()[i] + "\n\n"
            + "  Government expenditure on education (% of GDP): " +(getGovExpend().getValues())[i] + "\n"
            + "  Current health expenditure (% of GDP): " + (getHealthExpend().getValues())[i] + "\n\n" ;
        }
        String returnString = "Ratio of Government expenditure on education vs Current health expenditure" + "\n"
        + "===============================\n"
        + perYearReport;
        return returnString;
	}
	
	
}

