/**
* General Analysis class for selection type and years
* @author Group 1 CS2212
*/

public class Analysis {
	private Selection selection;
	private int[]years;
	
	/**
    * @param select the selection which will be used for analysis
    */
	public Analysis(Selection select) {
		selection = select;
	}
	
    /**
    * getter method for analysis selection type 
    * @return selection type
    */
	public Selection getSelection() {
		return selection;
	}
	
    /**
    * @return calculates int array of year values to be used in analysis
    */
	public int[] calculateYearValues() {
		int[] product = new int[(selection.getEndYear() - selection.getStartYear()) + 1]; //Creates the an array to hold the years selected for the analysis
		
		for(int i = selection.getEndYear(); i >= selection.getStartYear(); i--) { //stores years from End date to start date
			product[selection.getEndYear() - i] = i; 
		}
		years = product;
		return product;
	}
	
    /**
    * @return the array of years which will be used for the analysis
    */
	public int[] getYears(){
		return years;
	}
	
}
