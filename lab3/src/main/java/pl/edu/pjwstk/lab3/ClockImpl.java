package pl.edu.pjwstk.lab3;

import java.util.*;

public class ClockImpl implements Clock {
	
	List<Czas> AlarmList = new ArrayList<Czas>(); 
		
	public List<Czas> getAlarmList() {
		return AlarmList;
	}

	public boolean shouldRing() {
		return true;
	}
	public void addAlarmTime(String czas) {
		
	}
	public void clearAlarmTime(String czas) {
		
	}
	
	

}
