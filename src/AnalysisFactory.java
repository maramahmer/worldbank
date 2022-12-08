/**
* Analysis factory to set analysis type
* @author Group 1 CS2212
*/
public class AnalysisFactory {
	private Selection selection;
	/**
    * @param select made by user, sets the selection
    */
	public AnalysisFactory(Selection select) {
		selection = select;
	}
	
    /**
    * @param selection made by user
    * creates and returns the type of analysis to be made based on user selection
    */
	public Analysis create(Selection selection) {
		if(selection.getAnalysisType().equals("AGEE"))
			return new AGEEFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("CDEPM"))
			return new CDEPMFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("CDGDP"))
			return new CDGDPFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("FA"))
			return new FAFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("GEECHE"))
			return new GEECHEFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("HBHE"))
			return new HBHEFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("HECMR"))
			return new HECMRFactory(selection).create(selection);
		
		else if(selection.getAnalysisType().equals("PMFA"))
			return new PMFAFactory(selection).create(selection);
		
		return null; //cannot be anything other than one of the selections	
	}
}
