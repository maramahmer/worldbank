/**Represents an CDEPMAnalysis (CO2 Emissions vs Energy use vs PM2.5 air pollution analysis)
*
*/

public class CDEPMAnalysis extends Analysis {
	private Data CO2Data, energyUseData, PMData;
	/**
    *@param CDEPM Analysis Constructor that initializes the data objects years and type. Passes
    * the selection select to to set the selection
    */
	public CDEPMAnalysis(Selection select) {
		super(select);
        CO2Data = new Data(select.getEndYear() - select.getStartYear() + 1); //data stores as many elements as the range of years
        CO2Data.setDataType("CO2 emissions");
		CO2Data.setYears(this.calculateYearValues());

        energyUseData = new Data(select.getEndYear() - select.getStartYear() + 1); 
        energyUseData.setDataType("Energy Use");
		energyUseData.setYears(this.calculateYearValues());

        PMData = new Data(select.getEndYear() - select.getStartYear() + 1); 
        PMData.setDataType("PM2.5 Emissions");
		PMData.setYears(this.calculateYearValues());
	}
	/**
    *@param sets the CO2 Data objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */

	public void setCO2Data(float[] values) {
		CO2Data.setValues(values);
	}
	/**
    *@param sets the EnergyUseData objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setEnergyUseData(float[] values) {
		energyUseData.setValues(values);
	}
    /**
    *@param sets the PMData objects array of values. Passes 
    * the float[] values as the values to be set on the data object
    */
	public void setPMData(float[] values) {
		PMData.setValues(values);
	}
	 /**
    *@param used to get the data object CO2Data 
    *@return the data object representing CO2 Data 
    */
	
	public Data getCO2Data() {
		return CO2Data;
	}
	 /**
    *@param used to get the data object energyUseData 
    *@return the data object representing energyUseData
    */
	public Data getEnergyUseData() {
		return energyUseData;
	}
	 /**
    *@param used to get the data object PMData 
    *@return the data object representing PMData
    */
	public Data getPMData() {
		return PMData;
	}
	/**
    *@param prints the values and years of the CDEPMAnalysis
    *@return the string representation of the CDEPMAnalysis
    */
	public String toString() {
        String Report = "";

        for (int i = getCO2Data().getYears().length - 1; i >= 0; i--) {
            Report = Report + "Year:" + (getCO2Data().getYears())[i] + "\n\n"
            + "  CO2 emissions (metric tons per capita): " + (getCO2Data().getValues())[i] + "\n" 
            + "  Energy use (kg of oil equivalent per capita): " + (getEnergyUseData().getValues())[i] + "\n"
            + "  PM2.5 air pollution, mean annual exposure (micrograms per cubic meter): " + (getPMData().getValues())[i] + "\n\n";
        }

        String returnString = "CO2 emissions vs Energy use vs PM2.5 air pollution, mean annual exposure" +  "\n" 
        + "========================\n"
        + Report;

        return returnString;
    }
	
	
}

