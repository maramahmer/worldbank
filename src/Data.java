/**
* Data Class
* @author Group 1 CS2212
*/
public class Data {
	private int[] years;
	private float[] values;
    private String dataType;
    
	/**
    * @param range of data
	* sets arrays to the size of data elements
    */
	public Data(int range) {
		years = new int[range];
		values = new float[range];
	}

	/**
    * @return data type string
    */
    public String getDataType() {
		return dataType;
	}

	/**
    * @param data type string input
	* sets data type
    */
    public void setDataType(String s){
        dataType = s;
    }

	/**
    * @param year array
	* sets array to years to be populated
    */	
	public void setYears(int[] yrs) {
		years = yrs;
	}

	/**
    * @param value array
	* sets array to values calculated
    */
	public void setValues(float[] vls) {
		values = vls;
	}

	/**
    * @return int array
    */
	public int[] getYears() {
		return years;
	}
	
    /**
    *@return float array
    */
	public float[] getValues() {
		return values;
	}
	
}
