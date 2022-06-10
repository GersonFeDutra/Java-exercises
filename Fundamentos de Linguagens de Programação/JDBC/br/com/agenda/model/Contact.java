package br.com.agenda.model;

import java.util.Date;

/**
 * Estrutura Orientada à Objetos que será conectada ao banco de dados
 * relacional.
 */
public class Contact {

	private int id;
	private int age;
	private String name;
	private Date signDate;
	private Date logDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	@Override
	public String toString() {
		return String.format("<Contact: %s, id: %d, logDate: %s>", name, id, logDate.toString());
	}
}
