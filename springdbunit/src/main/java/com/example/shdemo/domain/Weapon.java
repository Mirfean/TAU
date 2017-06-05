package com.example.shdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Weapon.nonmagic", query = "Select c from Weapon c where c.is_magic = false"),
		@NamedQuery(name = "Weapon.findAll", query = "Select c from Weapon c")
})
public class Weapon {

	private Long id;
	private String name;
	private int attack;
	private double attack_speed;
	private Boolean is_magic;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Column(unique = true, nullable = false)
	public void setName(String name) {
		this.name = name;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public double getAttackSpeed() {
		return attack_speed;
	}
	public void setAttackSpeed(double attack_speed) {
		this.attack_speed = attack_speed;
	}
	public Boolean getIsMagic() {
		return is_magic;
	}
	public void setIsMagic(Boolean is_magic) {
		this.is_magic = is_magic;
	}
	

}
