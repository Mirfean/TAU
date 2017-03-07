package pl.edu.pjwstk.lab2;


import java.util.List;

public interface Vector {

	List<Integer> add(VectorImpl wektor2);
	VectorImpl add(VectorImpl wektor, VectorImpl wektor2);
	List<Integer> getValues();
	void setValues(List<Integer> values);
	List<Integer> sub(VectorImpl wektor2);
	
	
}
