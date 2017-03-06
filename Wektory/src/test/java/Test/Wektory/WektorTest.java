package Test.Wektory;

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
		List<Integer> ListTest3 = Arrays.asList(5,10,15);		//Oczekiwany wynik testu #1
		Wektor wek1 = new Wektor(ListTestWek1);					//Testowy Wektor #1
		Wektor wek2 = new Wektor(ListTestWek2);					//Testowy Wektor #2
		
		Assert.assertEquals("Funkcja add",wek1.add(wek2),ListTest3);
	}
	
	@Test
    public void AddTest2() {
		
		List<Integer> ListTestWek1 = Arrays.asList(2,4,6);
		List<Integer> ListTestWek2 = Arrays.asList(3,6,9);
		List<Integer> ListTest3 = Arrays.asList(5,10,15);		
		Wektor wek1 = new Wektor(ListTestWek1);					//Testowy Wektor #1
		Wektor wek2 = new Wektor(ListTestWek2);					//Testowy Wektor #2
		Wektor wek3 = new Wektor(ListTest3);					//Oczekiwany wynik testu #2
		
		Assert.assertEquals("Funkcja add2",wek3.values, Wektor.add(wek1, wek2).values);
	}
	
}