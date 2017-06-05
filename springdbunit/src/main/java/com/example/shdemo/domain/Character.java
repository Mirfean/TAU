package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("/main/resources/beans.xml")
@Entity
@NamedQueries({ 
	@NamedQuery(name = "character.all", query = "Select p from Character p"),
	@NamedQuery(name = "character.byId", query = "Select p from Character p where p.id = :id")
})
public class Character {

	private Long id;

	private String name;
	private String race;
	private String carrer;
	private int lvl;

	private List<Weapon> weapons;// = new ArrayList<Car>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCarrer() {
		return carrer;
	}
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@OneToMany(orphanRemoval=true)
    //@JoinColumn(name="OWNER")
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
}
