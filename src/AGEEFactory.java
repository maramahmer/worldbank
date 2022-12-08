/**Represents a factory that returns AGEEAnalysis objects
*
*/
public class AGEEFactory extends AnalysisFactory {
	
    /**
    *@param constructor that takes in Selection select as the selection for the AGEEAnalysis object
    */ 
	public AGEEFactory(Selection select) {
		super(select);
	}
	
    /**
    *@param creates and returns AGEEAnalysis with the Selection selection
    *@return AGEEAnalysis with the set selection
    */
	public AGEEAnalysis create(Selection selection) {
		return new AGEEAnalysis(selection);
	}

}
