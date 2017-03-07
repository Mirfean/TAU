package pl.edu.pjwstk.lab2;

import java.util.List;

public class VectorImpl {
	
	List<Integer> values;
	
	public VectorImpl(){}
	
	public VectorImpl(List<Integer> v){
		values = v;
	}
	
	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public List<Integer> add(VectorImpl wektor2) {
		if(this.values.size() == wektor2.values.size())
		{
			for(int i=0;i<this.values.size();i++){
				this.values.set(i, this.values.get(i)+wektor2.values.get(i));
			}
		}
		return this.values;
	}

	static public VectorImpl add(VectorImpl wektor, VectorImpl wektor2) {
		VectorImpl wektor3 = new VectorImpl(wektor.add(wektor2));
		return wektor3;
	}
}