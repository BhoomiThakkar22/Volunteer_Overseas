package com.volunteer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project_start_dates")
public class ProjectStartDates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Date start_date;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="project_id")
	private Projects projectStartDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Projects getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Projects projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
}
