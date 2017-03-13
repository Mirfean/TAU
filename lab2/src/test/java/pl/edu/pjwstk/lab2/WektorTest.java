package pl.edu.pjwstk.lab2;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WektorTest {
	
	@Test
    public void AddTest() {	
		List<Integer> ListTestWek1 = Arrays.asList(2,4,6);
		List<Integer> ListTestWek2 = Arrays.asList(3,6,9);
		List<Integer> ListTest3 = Arrays.asList(8,16,24);		//Oczekiwany wynik testu #1
		VectorImpl wek1 = new VectorImpl(ListTestWek1);					//Testowy Wektor #1
		VectorImpl wek2 = new VectorImpl(ListTestWek2);					//Testowy Wektor #2
		
		assertNotNull(wek1.add(wek2));
		assertEquals("Metoda add",wek1.add(wek2),ListTest3);
	}
	
	@Test
    public void AddTest2() {
		
		List<Integer> ListTestWek1 = Arrays.asList(2,4,6);
		List<Integer> ListTestWek2 = Arrays.asList(3,6,9);
		List<Integer> ListTest3 = Arrays.asList(5,10,15);		
		VectorImpl wek1 = new VectorImpl(ListTestWek1);					//Testowy Wektor #1
		VectorImpl wek2 = new VectorImpl(ListTestWek2);					//Testowy Wektor #2
		VectorImpl wek3 = new VectorImpl(ListTest3);					//Oczekiwany wynik testu #2
		assertEquals("Metoda add2",wek3.values, VectorImpl.add(wek1, wek2).values);
	}
	
	@Test (expected=NullPointerException.class)
    public void SubTestNull() {
		List<Integer> ListTest1 = Arrays.asList(2,4,6);
		//List<Integer> ListTest2 = Arrays.asList(3,6,9);
		List<Integer> ListTest3 = Arrays.asList(5,10,15);		
		VectorImpl wek1 = new VectorImpl(ListTest1);					//Testowy Wektor #1
		VectorImpl wek2 = new VectorImpl();								//Testowy Wektor #2 (Null)
		VectorImpl wek3 = new VectorImpl(ListTest3);					//Oczekiwany wynik testu #2
		assertEquals("Metoda sub",wek3.sub(wek2),wek1);
	}
	
	@Test
    public void SubTest() {
		
		List<Integer> ListTest1 = Arrays.asList(2,4,6);
		List<Integer> ListTest2 = Arrays.asList(3,6,9);
		List<Integer> ListTest3 = Arrays.asList(5,10,15);		
		VectorImpl wek1 = new VectorImpl(ListTest1);					//Testowy Wektor #1
		VectorImpl wek2 = new VectorImpl(ListTest2);					//Testowy Wektor #2
		VectorImpl wek3 = new VectorImpl(ListTest3);					//Wektor #1 + #2
		wek3.setValues(wek3.sub(wek2));													// #3 - #2 should be #1
		assertEquals("Metoda sub",wek3.values,wek1.values);
	}
	
	
	
}