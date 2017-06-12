package pl.edu.equipment.service;

import java.util.List;

import pl.edu.equipment.domain.Character;
import pl.edu.equipment.domain.Weapon;

public interface EquipmentManager {
	
	void addCharacter(Character character);
	List<Character> getAllCharacters();
	void deleteCharacter(Character character);
	Character findCharacterByName(String name);
	
	Long addNewWeapon(Weapon weapon);
	List<Weapon> getUsedWeapons(Character character);		//++
	List<Weapon> getUnusedWeapons();
	void lostWeapon(Character character, Weapon weapon);
	Weapon findWeaponById(Long id);

	List<Weapon> weaponsOfCharacter(Character character);
	void makeWeaponUsed(Long characterId, Long weaponId);
}
