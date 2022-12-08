/**Represents a factory that returns GEECHEAnalysis objects
* @author Group 1 CS2212
*/
public class GEECHEFactory extends AnalysisFactory {
	 /**
    *@param constructor that takes in Selection select as the selection for the GEECHEAnalysis object
    */   
	public GEECHEFactory(Selection select) {
		super(select);
	}
	/**
    *@param creates and returns GEECHEAnalysis with the Selection selection
    *@return GEECHEAnalysis with the set selection
    */	
	public GEECHEAnalysis create(Selection selection) {
		return new GEECHEAnalysis(selection);
	}

}
