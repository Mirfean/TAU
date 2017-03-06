package Test.Wektory;

import java.util.List;

public interface WektorImpl {

	List<Integer> add(Wektor wektor2);
	Wektor add(Wektor wektor, Wektor wektor2);
	List<Integer> getValues();
	void setValues(List<Integer> values);
	
	
}
