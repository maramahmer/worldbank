/**Represents a factory that returns HBHEAnalysis objects
* @author Group 1 CS2212
*/
public class HBHEFactory extends AnalysisFactory {
	/**
    *@param constructor that takes in Selection select as the selection for the HBHEAnalysis object
    */   
	public HBHEFactory(Selection select) {
		super(select);
	}
	/**
    *@param creates and returns HBHEAnalysis with the Selection selection
    *@return HBHEAnalysis with the set selection
    */	
	public HBHEAnalysis create(Selection selection) {
		return new HBHEAnalysis(selection); 
	}

}
