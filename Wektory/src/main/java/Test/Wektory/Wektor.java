package Test.Wektory;

import java.util.List;

public class Wektor {
	
	List<Integer> values;
	
	public Wektor(){}
	
	public Wektor(List<Integer> v){
		values = v;
	}
	
	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public List<Integer> add(Wektor wektor2) {
		if(this.values.size() == wektor2.values.size())
		{
			for(int i=0;i<this.values.size();i++){
				this.values.set(i, this.values.get(i)+wektor2.values.get(i));
			}
		}
		return this.values;
	}

	static public Wektor add(Wektor wektor, Wektor wektor2) {
		Wektor wektor3 = new Wektor(wektor.add(wektor2));
		return wektor3;
	}
}