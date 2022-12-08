/**Represents a factory that returns PMFAAnalysis objects
* @author Group 1 CS2212
*/
public class PMFAFactory extends AnalysisFactory{
/**
    *@param constructor that takes in Selection select as the selection for the PMFAAnalysis object
    */   
	public PMFAFactory(Selection select) {
		super(select);
	}
	/**
    *@param creates and returns PMFAAnalysis with the Selection selection
    *@return PFMAAnalysis with the set selection
    */	
	public PMFAAnalysis create(Selection selection) {
		return new PMFAAnalysis(selection);
	}
}
