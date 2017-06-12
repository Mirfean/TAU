package pl.edu.equipment.service;

import static org.junit.Assert.*;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.equipment.service.EquipmentManager;
import pl.edu.equipment.domain.Character;
import pl.edu.equipment.domain.Weapon;
import org.apache.log4j.Logger;

@ContextConfiguration(locations = {"classpath:beans3.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class EqManagerDBUnitTest {


	@Autowired
	EquipmentManager eqManager;

	@Test
	@DatabaseSetup("/fullData.xml")
	@ExpectedDatabase(value = "/addCharacterData.xml", 
	assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void getCharacterCheck() {
		assertEquals(1, eqManager.getAllCharacters().size());
        Character p = new Character();
        p.setName("Torgal");
        p.setRace("Human");
        eqManager.addCharacter(p);
        assertEquals(2, eqManager.getAllCharacters().size());

    }
}
