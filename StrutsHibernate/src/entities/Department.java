package entities;
// Generated 2016/06/17 10:09:56 by Hibernate Tools 3.6.0.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Department generated by hbm2java
 */
public class Department implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String deparment;
	private Set members = new HashSet(0);

	public Department() {
	}

	public Department(BigDecimal id) {
		this.id = id;
	}

	public Department(BigDecimal id, String deparment, Set members) {
		this.id = id;
		this.deparment = deparment;
		this.members = members;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDeparment() {
		return this.deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

}
