package pl.edu.equipment.service;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test //Drugi test
	@DatabaseSetup("/deleteCharacterData.xml")
	@ExpectedDatabase(value = "/addCharacterData2.xml", 
	assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void CharacterAddTest() {
      
		assertEquals(2,eqManager.getAllCharacters().size());
		
		Character character2 = new Character();
		character2.setName("Dude");
		character2.setRace("dude");
		character2.setCarrer("chillman");
		character2.setLvl(7);
		
		eqManager.addCharacter(character2);
      
        assertEquals(3, eqManager.getAllCharacters().size());
    }
	
	@Test		//Pierwszy test(Dlaczego???)
    @DatabaseSetup("/startingData.xml")
    @ExpectedDatabase(value ="/deleteCharacterData.xml",
    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void CharacterDeleteTest() {
        
        assertEquals(3,eqManager.getAllCharacters().size());
        Character toDelete = eqManager.findCharacterByName("Torgal");
        eqManager.deleteCharacter(toDelete);
        assertEquals(2,eqManager.getAllCharacters().size());
    }
	
//	@Test
//	@DatabaseSetup("/deleteCharacterData.xml")
//	@ExpectedDatabase(value = "/giveWeaponData.xml", 
//	assertionMode = DatabaseAssertionMode.NON_STRICT)
//	public void WeaponAddToCharacterTest() {
//        
//		Character character = eqManager.findCharacterByName("Dude");
//
//		Weapon weapon = new Weapon();
//		weapon.setName("AntimatterAxe");
//		weapon.setAttack(1234);
//		weapon.setAttackSpeed(2.2);
//
//		Long weaponId = eqManager.addNewWeapon(weapon);
//
//		eqManager.makeWeaponUsed(character.getId(), weaponId);
//
//		assertEquals(2, eqManager.getAllWeapons().size());
//        
//	}
	
	
	
}
