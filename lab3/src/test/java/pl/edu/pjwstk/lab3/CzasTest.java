package pl.edu.pjwstk.lab3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import org.easymock.Mock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.edu.pjwstk.lab3.Clock;
import pl.edu.pjwstk.lab3.ClockImpl;
import pl.edu.pjwstk.lab3.Czas;

@RunWith(EasyMockRunner.class)
public class CzasTest {
	
	@Rule
    public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
    public Clock clock = new ClockImpl();
	
	@Mock
    private Czas mockCzas;
	
	@Test
	public void mockCzasTest(){
		expect(mockCzas.getCzas()).andReturn("13:10");
		replay(mockCzas);
		assertEquals("13:10",mockCzas.getCzas());
		verify(mockCzas);
	}

	@Test
	public void shouldRingTest01(){
		expect(mockCzas.getCzas()).andReturn("01:10").andReturn("13:10");
        replay(mockCzas);
        assertEquals(clock.shouldRing(), false);
        clock.addAlarmTime("01:10");
        assertEquals(clock.shouldRing(), true);
        assertEquals(clock.shouldRing(), false);
        verify(mockCzas);
	}
	
	@Test
	public void shouldRingTest02(){
		expect(mockCzas.getCzas()).andReturn("01:10").andReturn("15:15").andReturn("13:10");
		replay(mockCzas);
		
	}
	

//	@Test
//	public void addAlarmTimeTest(){
//		expect(mockCzas.getCzas()).andReturn("13:10");
//		replay(mockCzas);
//		alarm.addAlarmTime(mockCzas);
//		assertEquals();
//		
//	}
}
//expect(mockM.getV()).andReturn("M").andReturn("N");
//replay(mockM);
//assertEquals("M", myVec.show());
//assertEquals("N", myVec.show());
//verify(mockM);


