package com.examen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false,insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_id_gender"))
	private Gender gender;
	@ManyToOne
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false,foreignKey = @ForeignKey(name = "fk_id_job"))
	private Job job_id;
	private String name;
	private String last_name;
	private Date birthdate;
	


	public Employees( Gender gender, Job job_id, String name, String last_name, Date birthdate) {
		super();
		this.id = id;
		this.gender = gender;
		this.job_id = job_id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}

	public Employees() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public Job getJob_id() {
		return job_id;
	}

	public void setJob_id(Job job_id) {
		this.job_id = job_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", gender=" + gender + ", job_id=" + job_id + ", name=" + name + ", last_name="
				+ last_name + ", birthdate=" + birthdate + "]";
	}


}
