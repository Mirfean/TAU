package pl.edu.pjwstk.lab3;

public class AlarmImpl {
	
	String time;
	Boolean active;
	
	AlarmImpl(String t,boolean a){
		time = t;
		active = a;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
