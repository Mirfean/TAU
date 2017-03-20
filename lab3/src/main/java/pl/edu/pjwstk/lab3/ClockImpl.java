package pl.edu.pjwstk.lab3;

import java.util.*;

public class ClockImpl implements Clock {
	
	Czas czas;
	List<AlarmImpl> AlarmList = new ArrayList<AlarmImpl>(); 
		
	public List<AlarmImpl> getAlarmList() {
		return AlarmList;
	}

	public boolean shouldRing() {
		for(AlarmImpl alarm: AlarmList){
			if(alarm.time == czas.getCzas() && alarm.active == true)
			{
				alarm.active = false;
				return true;
			}
		}
		return false;
	}
	public void addAlarmTime(String czas) {
		if(AlarmList.contains(czas)){
			AlarmList.get(AlarmList.indexOf(czas)).active = true;
		}else { AlarmList.add(new AlarmImpl(czas,true));}
	}
	public void clearAlarmTime(String czas) {
		
		
		
	}
	
	

}
