/**Represents an HBHEAnalysis (Ratio of Hospital beds vs Current health expenditure)
* @author Group 1 CS2212
*/

public class HBHEAnalysis extends Analysis {
	private Data hospBeds, healthExpend;
		/**
    *@param HBHEAnalysis Contructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public HBHEAnalysis(Selection select) {
		super(select);
        hospBeds = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		hospBeds.setDataType("Ratio of Hospital beds");
        hospBeds.setYears(this.calculateYearValues());

        healthExpend = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		healthExpend.setDataType("Current health expenditure");
        healthExpend.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the hospBeds objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setHospBeds(float[] values) {
		hospBeds.setValues(values);
	}
	/**
    *@param sets the healthExpend objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setHealthExpend(float[] values) {
		healthExpend.setValues(values);
	}
	   /**
    *@param used to get the data object hospBeds
    *@return the data object representing hospBeds
    */
	
	public Data getHospBeds() {
		return hospBeds;
	}
	   /**
    *@param used to get the data object healthExpend
    *@return the data object representing healthExpend
    */
	public Data getHealthExpend() {
		return healthExpend;
	}
		  /**
    *@param prints the values and years of the HBHEAnalysis
    *@return the string representation of the HBHEAnalysis
    */
	public String toString(){
        String perYearReport = "";

        for(int i = getHospBeds().getYears().length - 1; i >= 0; i--){
            perYearReport = perYearReport + "Year: " + (getHospBeds().getYears())[i]  + "\n\n" 
            + "  Hospital beds (per 1,000 people): " + (getHospBeds().getValues())[i] + "\n"
            + "  Current health expenditure (% of GDP): " + (getHealthExpend().getValues())[i] + "\n\n";
        }

        String returnString = "Ratio of Hospital beds vs Current health expenditure" + "\n" 
        + "========================\n"
        + perYearReport;
        return returnString;
    }
	
}