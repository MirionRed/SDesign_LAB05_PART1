package workshopapp.domain;

import java.util.ArrayList;

public class WorkshopList {
	private ArrayList<Workshop> workshops;
	
	public WorkshopList(){
		workshops = new ArrayList<Workshop>();
	}
	
	public void addWorkshop(String wName, String wDate){
		Workshop aWorkshop = new Workshop(wName, wDate);
		workshops.add(aWorkshop);
	}
	
	public Workshop findWorkshop(String wName){
		boolean found = false;
		int i = 0;
		while(i<workshops.size() && !found){
			if(workshops.get(i).getWName().equals(wName)){
				return workshops.get(i);
			}else{
				i++;
			}
		}
		return null;
	}
	
	public void registerParticipant(String pName, String pIC, String wName){
		Participant aParticipant = new Participant(pName, pIC);
		findWorkshop(wName).registerParticipant(pName, pIC);
	}
	
	public boolean isEmpty(){
		return workshops.isEmpty();
	}
	
	public Participant findParticipant(String wName, String pName){
		Workshop aWorkshop = findWorkshop(wName);
		
		if(aWorkshop.findParticipant(pName) == null){
			return null;
		} else {
			return aWorkshop.findParticipant(pName);
		}
	}
}
