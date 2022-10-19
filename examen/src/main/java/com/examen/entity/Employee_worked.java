package com.examen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employe_worked_hours")
public class Employee_worked {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false,foreignKey = @ForeignKey(name = "fk_id_employees"))
	private Employees employee;
	private int worked_hours;
	private Date worked_date;

	public Employee_worked() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	@Override
	public String toString() {
		return "Employee_worked [id=" + id + ", employee=" + employee + ", worked_hours=" + worked_hours
				+ ", worked_date=" + worked_date + "]";
	}

}
