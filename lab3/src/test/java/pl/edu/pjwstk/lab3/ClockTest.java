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
public class ClockTest {
	
	@Rule
    public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
    public ClockImpl clock = new ClockImpl();
	
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
		expect(mockCzas.getCzas()).andReturn("01:10").times(2);
        replay(mockCzas);
        //assertEquals(clock.shouldRing(), false);
        clock.addAlarmTime("01:10");
        clock.czas = mockCzas;
        assertEquals(clock.shouldRing(),true);
        assertEquals(clock.shouldRing(),false);
        verify(mockCzas);
	}
	
	@Test
	public void shouldRingTest02(){
		expect(mockCzas.getCzas()).andReturn("15:15").times(3);
		replay(mockCzas);
		clock.addAlarmTime("15:15");
		assertEquals(clock.shouldRing(),true);
		clock.addAlarmTime("15:15");
		assertEquals(clock.shouldRing(),true);
	}
	
	@Test
	public void addAlarmTimeTest(){
		expect(mockCzas.getCzas()).andReturn("13:10").andReturn("01:10").andReturn("13:10").andReturn("11:11");
		replay(mockCzas);
		clock.addAlarmTime(mockCzas.getCzas());
		clock.addAlarmTime(mockCzas.getCzas());
		assertEquals(clock.AlarmList.get(0).time,mockCzas.getCzas());
		assertNotEquals(clock.AlarmList.get(1).time,mockCzas.getCzas());
		verify(mockCzas);
	}
	
	@Test
	public void clearAlarmTimeTest(){
		expect(mockCzas.getCzas()).andReturn("13:10").times(2).andReturn("11:15").times(3);
		replay(mockCzas);
		clock.addAlarmTime(mockCzas.getCzas());
		assertEquals(clock.AlarmList.get(0).time,mockCzas.getCzas());
		clock.addAlarmTime(mockCzas.getCzas());
		clock.clearAlarmTime(mockCzas.getCzas());
		assertEquals(clock.AlarmList.contains(mockCzas.getCzas()),false);
		verify(mockCzas);
	}	
	
	
//	@Test
//	public void 
	
	
	

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


