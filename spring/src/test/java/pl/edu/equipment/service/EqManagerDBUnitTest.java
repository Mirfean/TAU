package pl.edu.equipment.service;

import static org.junit.Assert.*;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import org.junit.After;
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
	@DatabaseSetup("/deleteCharacterData.xml")
	@ExpectedDatabase(value = "/afteradd.xml", 
	assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void CharacterAddTest() {
//		assertEquals(3, eqManager.getAllCharacters().size());
//        Character p = new Character();
//        p.setName("Torgal");
//        p.setRace("Human");
//        p.setLvl(10);
//        eqManager.addCharacter(p);
//        
//        Character p2 = new Character();
//        p2.setName("Arhg");
//        p2.setRace("Gnoll");
//        eqManager.addCharacter(p);
        
      Character character2 = new Character();
      character2.setName("Yorwin");
      character2.setRace("Dwarf");
      character2.setCarrer("DragonSlayer");
      character2.setLvl(88);
      eqManager.addCharacter(character2);
      
        assertEquals(4, eqManager.getAllCharacters().size());

    }
	
	@Test
    @DatabaseSetup("/addCharacterData.xml")
    @ExpectedDatabase(value ="/deleteCharacterData.xml",
    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void CharacterDeleteTest() {
		
//        Character character2 = new Character();
//        character2.setName("Yorwin");
//        character2.setRace("Dwarf");
//        character2.setCarrer("DragonSlayer");
//        eqManager.addCharacter(character2);
        
        assertEquals(4,eqManager.getAllCharacters().size());
        Character toDelete = eqManager.findCharacterByName("Torgal");
        eqManager.deleteCharacter(toDelete);
        assertEquals(3,eqManager.getAllCharacters().size());
        
    }
	
}
