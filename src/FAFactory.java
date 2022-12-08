/**Represents a factory that returns FAAnalysis objects
*
*/
public class FAFactory extends AnalysisFactory {
	 /**
    *@param constructor that takes in Selection select as the selection for the FAAnalysis object
    */   
	public FAFactory(Selection select) {
		super(select);
	}
	/**
    *@param creates and returns FAAnalysis with the Selection selection
    *@return FAAnalysis with the set selection
    */	
	public FAAnalysis create(Selection selection) {
		return new FAAnalysis(selection);
	}

}
