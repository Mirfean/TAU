package pl.edu.pjwstk.lab3;

import java.util.Calendar;

public interface Clock {
	
	public boolean shouldRing();
	public void addAlarmTime(String czas);
	public void clearAlarmTime(String czas);
	
	
}
