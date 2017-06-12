package pl.edu.equipment.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.equipment.domain.Character;
import pl.edu.equipment.domain.Weapon;

@Component
@Transactional
public class EquipmentManagerImplHiber implements EquipmentManager {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCharacter(Character character) {
		character.setId(null);
		sessionFactory.getCurrentSession().persist(character);
		//sessionFactory.getCurrentSession().flush();
	}

	public void deleteCharacter(Character character) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class,
				character.getId());
		//Lazy loading
		for (Weapon w : character.getWeapons()) {
			w.setIsUsed(false);
			sessionFactory.getCurrentSession().update(w);
		}
		sessionFactory.getCurrentSession().delete(character);
	}
	
	public List<Weapon> weaponsOfCharacter(Character character) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class, character.getId());
		List<Weapon> weapons = new ArrayList<Weapon>(character.getWeapons());
		return weapons;
	}
	//Query
	@SuppressWarnings("unchecked")
	public List<Character> getAllCharacters() {
		return sessionFactory.getCurrentSession().getNamedQuery("Character.all").list();
	}

	//Query
	public Character findCharacterByName(String name) {
		return (Character) sessionFactory.getCurrentSession().getNamedQuery("Character.byName").setString("name", name).uniqueResult();
	}
	
	
	public Long addNewWeapon(Weapon weapon) {
		weapon.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(weapon);
	}
	
	public void makeWeaponUsed(Long characterId, Long weaponId) {
		Character character = (Character) sessionFactory.getCurrentSession().get(Character.class, characterId);
		Weapon weapon = (Weapon) sessionFactory.getCurrentSession().get(Weapon.class, weaponId);
	
		weapon.setIsUsed(true);
		character.getWeapons().add(weapon);
		
	}
	//Query weapon
	@SuppressWarnings("unchecked")
	public List<Weapon> getUnusedWeapons() {
		return sessionFactory.getCurrentSession().getNamedQuery("Weapon.usused").list();
	}
	
	public void lostWeapon(Character character, Weapon weapon) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class,
				character.getId());
		weapon = (Weapon) sessionFactory.getCurrentSession().get(Weapon.class,
				weapon.getId());
		Weapon toRemove = null;
		for (Weapon weapon2 : character.getWeapons())
			if (weapon2.getId().compareTo(weapon.getId()) == 0) {
				toRemove = weapon2;
				break;
			}
		if (toRemove != null) { character.getWeapons().remove(toRemove); }
			weapon.setIsUsed(false);
}

	@SuppressWarnings("unchecked")
	public List<Weapon> getUsedWeapons(Character character) {
		return sessionFactory.getCurrentSession().getNamedQuery("Weapon.used").list();
	}
	
	public Weapon findWeaponById(Long id) {
		return (Weapon) sessionFactory.getCurrentSession().get(Weapon.class, id);
	}
	
}
