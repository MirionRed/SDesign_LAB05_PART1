package workshopapp.domain;

public class Participant {
	private String pName;
	private String pIC;
	
	public Participant (String pName, String pIC){
		this.pIC = pIC;
		this.pName = pName;
	}
	
	public String getName(){
		return pName;
	}
	
	public String getIC(){
		return pIC;
	}
}
