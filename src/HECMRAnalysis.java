/**Represents an HECMRAnalysis (Current health expenditure per capita vs Mortality rate)
* @author Group 1 CS2212
*/

public class HECMRAnalysis extends Analysis {
	private Data healthExpendCap, mortalityRate;
		/**
    *@param HECMRAnalysis Contructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public HECMRAnalysis(Selection select) {
		super(select);
        healthExpendCap = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		healthExpendCap.setDataType("Current health expenditure per capita");
        healthExpendCap.setYears(this.calculateYearValues());

		mortalityRate = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
		mortalityRate.setDataType("mortality rate");
        mortalityRate.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the healthExpendCap objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setHealthExpendCap(float[] values) {
		healthExpendCap.setValues(values);
	}
	/**
    *@param sets the mortalityRate objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setMortalityRate(float[] values) {
		mortalityRate.setValues(values);
	}
	  /**
    *@param used to get the data object healthExpendCap
    *@return the data object representing healthExpendCap
    */
	public Data getHealthExpendCap() {
		return healthExpendCap;
	}
	  /**
    *@param used to get the data object mortalityRate
    *@return the data object representing mortalityRate
    */
	public Data getMortalityRate() {
		return mortalityRate;
	}
	  /**
    *@param prints the values and years of the HECMRAnalysis
    *@return the string representation of the HECMRAnalysis
    */
	public String toString(){
        String perYearReport = "";
        for(int i = getMortalityRate().getYears().length - 1; i >= 0; i--){
            perYearReport = perYearReport + "Year: " + (getMortalityRate().getYears())[i] + "\n\n"
            + "  Current health expenditure per capita (current US$): " +(getHealthExpendCap().getValues()[i] + "\n")
            + "  Mortality rate, infant (per 1000 live births): " +(getMortalityRate().getValues()[i] + "\n\n");
        }
        String returnString = "Current health expenditure per capita vs Mortality rate " + "\n"
        + "===============================\n"
        + perYearReport;
        return returnString;
    }
		
}
