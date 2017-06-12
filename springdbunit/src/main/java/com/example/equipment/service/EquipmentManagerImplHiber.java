package com.example.shdemo.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Weapon;
import com.example.shdemo.domain.Character;

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
	
	@Override
	public void addCharacter(Character character) {
		character.setId(null);
		sessionFactory.getCurrentSession().persist(character);
		sessionFactory.getCurrentSession().flush();
	}
    @Override
    public void updateCharacter(Character character) {
        sessionFactory.getCurrentSession().update(character);
    }

	@Override
	public void deleteCharacter(Character character) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class,
				character.getId());
		for (Weapon weapon : character.getWeapons()) {
			weapon.setIsMagic(false);
			sessionFactory.getCurrentSession().update(weapon);
		}
		sessionFactory.getCurrentSession().delete(character);
	}

	@Override
	public List<Weapon> getMagicWeapons(Character character) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class,
				character.getId());
		// lazy loading here - try this code without (shallow) copying
		List<Weapon> weapons = new ArrayList<Weapon>(character.getWeapons());
		return weapons;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Character> getAllCharacters() {
		return sessionFactory.getCurrentSession().getNamedQuery("character.all")
				.list();
	}

	@Override		//Ostro zmienic!!!!
	public Character findCharacterById(int id) {
		return (Character) sessionFactory.getCurrentSession().getNamedQuery("character.byId").setInteger("id", id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Weapon> getAllWeapons() {
		return sessionFactory.getCurrentSession().getNamedQuery("Weapon.findAll").list();
	}
	

	@Override
	public Long addNewWeapon(Weapon weapon) {
		weapon.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(weapon);
	}

	public void makeWeaponMagic(Long characterId, Long weaponId) {
		Character character = (Character) sessionFactory.getCurrentSession().get(
				Character.class, characterId);
		Weapon weapon = (Weapon) sessionFactory.getCurrentSession()
				.get(Weapon.class, weaponId);
		weapon.setIsMagic(true);
		if (character.getWeapons() == null) {
			character.setWeapons(new LinkedList<Weapon>());
		}
		character.getWeapons().add(weapon);
	}

	@SuppressWarnings("unchecked")
	public List<Weapon> getNonMagicWeapons() {
		return sessionFactory.getCurrentSession().getNamedQuery("Weapon.nonmagic").list();
	}
	
	public void deleteWeapon(Character character, Weapon weapon) {
		character = (Character) sessionFactory.getCurrentSession().get(Character.class,
				character.getId());
		weapon = (Weapon) sessionFactory.getCurrentSession().get(Weapon.class,
				weapon.getId());
		Weapon toRemove = null;
		// lazy loading here (person.getCars)
		for (Weapon weapon2 : character.getWeapons())
			if (weapon2.getId().compareTo(weapon.getId()) == 0) {
				toRemove = weapon2;
				break;
			}
		if (toRemove != null)
			character.getWeapons().remove(toRemove);
			weapon.setIsMagic(false);
	}

	public Weapon findWeaponById(Long id) {
		return (Weapon) sessionFactory.getCurrentSession().get(Weapon.class, id);
	}
	
	
	
	
	
	
	
	
	

}
