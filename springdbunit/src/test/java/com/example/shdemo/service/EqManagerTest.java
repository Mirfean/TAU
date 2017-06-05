package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Weapon;
import com.example.shdemo.domain.Character;

@Ignore

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Rollback
//@Commit
@Transactional(transactionManager = "txManager")
public class EqManagerTest {

	@Autowired
	EquipmentManager eqManager;

	private final String CNAME_1 = "Dor";
	private final String RACE_1 = "Orc";
	private final String CARRER_1 = "Bard";
	private final int LVL_1 = 30;

	private final String CNAME_2 = "Nilia";
	private final String RACE_2 = "Halfling";
	private final String CARRER_2 = "Warlock";
	private final int LVL_2 = 67;

	private final String WNAME_1 = "Board with nail";
	private final int ATTACK_1 = 1500;
	private final double ATTACKSPEED_1 = 1.7;

	private final String WNAME_2 = "Dragonkiller";
	private final int ATTACK_2 = 870;
	private final double ATTACKSPEED_2 = 2.2;

	@Test
	public void addClientCheck() {

		List<Character> retrievedClients = eqManager.getAllCharacters();
		for (Character player : retrievedClients) {
			System.out.println("Character: " + player.getName() + " race: " + player.getRace() + " class: " + player.getCarrer()+ " lvl: " + player.getLvl());
			if (player.getRace().equals(RACE_1)) {
				eqManager.deleteCharacter(player);
			}
		}
		retrievedClients = eqManager.getAllCharacters();

		Character player = new Character();
		player.setName(CNAME_1);
		player.setRace(RACE_1);
		player.setCarrer(CARRER_1);
		player.setLvl(LVL_1);

		eqManager.addCharacter(player);

		Character retrievedCharacter = eqManager.findCharacterById(2);

		assertEquals(CNAME_1, retrievedCharacter.getName());
		assertEquals(RACE_1, retrievedCharacter.getRace());
		assertEquals(CARRER_1, retrievedCharacter.getCarrer());
		assertEquals(LVL_1, retrievedCharacter.getLvl());

	}

	@Test
	public void addWeaponCheck() {

		Weapon weapon = new Weapon();
		weapon.setName(WNAME_1);							//		weapon.setMake(MAKE_1);
		weapon.setAttack(ATTACK_1);							//		weapon.setModel(MODEL_1);
		weapon.setAttackSpeed(ATTACKSPEED_1);
		// ... other properties here

		Long WeaponId = eqManager.addNewWeapon(weapon);

		Weapon retrievedWeapon = eqManager.findWeaponById(WeaponId);
		assertEquals(WNAME_1, retrievedWeapon.getName());
		assertEquals(ATTACK_1, retrievedWeapon.getAttack());
		assertEquals(ATTACKSPEED_1, retrievedWeapon.getAttackSpeed());

	}

	@Test
	public void sellWeaponCheck() {

		Character player = new Character();
		player.setName(CNAME_2);
		player.setRace(RACE_2);
		player.setCarrer(CARRER_2);
		player.setLvl(LVL_2);
		eqManager.addCharacter(player);

		Character retrievedPerson = eqManager.findCharacterById(3);

		Weapon weapon = new Weapon();
		weapon.setName(WNAME_2);							//		weapon.setMake(MAKE_1);
		weapon.setAttack(ATTACK_2);							//		weapon.setModel(MODEL_1);
		weapon.setAttackSpeed(ATTACKSPEED_2);

		Long WeaponId = eqManager.addNewWeapon(weapon);

		eqManager.makeWeaponMagic(retrievedPerson.getId(), WeaponId);

		List<Weapon> magicWeapons = eqManager.getMagicWeapons(retrievedPerson);

		assertEquals(1, magicWeapons.size());
		assertEquals(WNAME_2, magicWeapons.get(0).getName());
		assertEquals(ATTACK_2, magicWeapons.get(0).getAttack());
		assertEquals(ATTACKSPEED_2, magicWeapons.get(0).getAttackSpeed());
	}

//	// @Test -
//	public void disposeWeaponCheck() {
//		// Do it yourself
//	}

}
