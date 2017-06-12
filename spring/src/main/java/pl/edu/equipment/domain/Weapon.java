package pl.edu.equipment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Weapon.findAll", query = "Select i from Weapon i"),
		@NamedQuery(name = "Weapon.unused", query = "Select c from Weapon c where c.isUsed = false")
})
public class Weapon {

	private Long id;
	private String name;
	private int attack;
	private double attackSpeed;
	private Boolean isUsed = false;
	
	public Weapon(){}
	public Weapon(String name,int at,double as)
	{
		super();
		this.name = name;
		this.attack = at;
		this.attackSpeed = as;
	}
	
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public double getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public Boolean getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
	public void makeItUsed()
	{
		this.isUsed = true;
	}
	public void makeItUnused()
	{
		this.isUsed = false;
	}
	
}
