package workshopapp.domain;

import java.util.ArrayList;

public class Workshop {
	private String wName;
	private String wDate;
	private ArrayList<Participant> participants;
	
	public Workshop(String wName, String wDate){
		this.wDate = wDate;
		this.wName = wName;
		participants = new ArrayList<Participant>();
	}
	
	public String getWName(){
		return wName;
	}
	
	public String getWDate(){
		return wDate;
	}
	
	public void registerParticipant(String pName, String pIC){
		Participant aParticipant = new Participant(pName, pIC);
		participants.add(aParticipant);
	}
	
	public Participant findParticipant(String name){
		boolean found = false;
		int i = 0;
		while(i<participants.size() && !found){
			if(participants.get(i).getName().equals(name)){
				return participants.get(i);
			}else{
				i++;
			}
		}
		return null;
	}
}
