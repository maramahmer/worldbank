/**Represents a factory that returns HECMRAnalysis objects
* @author Group 1 CS2212
*/
public class HECMRFactory extends AnalysisFactory {
/**
    *@param constructor that takes in Selection select as the selection for the HECMRAnalysis object
    */   
	public HECMRFactory(Selection select) {
		super(select);
	}
	/**
    *@param creates and returns HECMRAnalysis with the Selection selection
    *@return HECMRAnalysis with the set selection
    */	
	public HECMRAnalysis create(Selection selection) {
		return new HECMRAnalysis(selection);
	}
}
