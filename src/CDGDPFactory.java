/**Represents a factory that returns CDGDPAnalysis objects
*
*/
public class CDGDPFactory extends AnalysisFactory {
		
    /**
    *@param constructor that takes in Selection select as the selection for the CDGDPAnalysis object
    */     
	public CDGDPFactory(Selection select) {
		super(select);
	}

    /**
    *@param creates and returns CDGDPAnalysis with the Selection selection
    *@return CDGDPAnalysis with the set selection
    */	
	public CDGDPAnalysis create(Selection selection) {
		return new CDGDPAnalysis(selection);
	}


}
