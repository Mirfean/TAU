package pl.edu.equipment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.test.context.ContextConfiguration;
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Character.all", query = "Select c from Character c"),
	@NamedQuery(name = "Character.byName", query = "Select c from Character c where c.name = :name")
})
public class Character {

	private Long id;

	private String name = "Noname";
	private String race = "Nothing";
	private String carrer = "None";
	private int lvl = 0;
	private List<Weapon> weapons; //= new ArrayList<Weapon>();

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
	public List<Weapon> getWeapons() {
		return weapons;
	}
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
}
