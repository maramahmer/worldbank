/**Represents a factory that returns CDEPMAnalysis objects
*
*/
public class CDEPMFactory extends AnalysisFactory {
	
    /**
    *@param constructor that takes in Selection select as the selection for the CDEPMFactory object
    */ 
	public CDEPMFactory(Selection select) {
		super(select);
	}
	
    /**
    *@param creates and returns CDEPMAnalysis with the Selection selection
    *@return CDEPMAnalysis with the set selection
    */
	public CDEPMAnalysis create(Selection selection) {
		return new CDEPMAnalysis(selection);
	}

}
