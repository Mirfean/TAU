package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Character;
import com.example.shdemo.domain.Weapon;

public interface EquipmentManager {
	
	void addCharacter(Character character);
	List<Character> getAllCharacters();
	void deleteCharacter(Character character);
	Character findCharacterById(int id);
	
	Long addNewWeapon(Weapon weapon);
	void deleteWeapon(Character character, Weapon weapon);
	Weapon findWeaponById(Long id);

	List<Weapon> getAllWeapons();
	List<Weapon> getMagicWeapons(Character character);		//Wcześniej ownedCars
	void makeWeaponMagic(Long characterId, Long weaponId);

    void updateCharacter(Character character);
}
