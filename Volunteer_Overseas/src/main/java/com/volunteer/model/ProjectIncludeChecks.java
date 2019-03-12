package com.volunteer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_include_checks")
public class ProjectIncludeChecks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String description;
	
	@Column
	private String is_included;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Projects projectIncludeCheck;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIs_included() {
		return is_included;
	}

	public void setIs_included(String is_included) {
		this.is_included = is_included;
	}

	public Projects getProjectIncludeCheck() {
		return projectIncludeCheck;
	}

	public void setProjectIncludeCheck(Projects projectIncludeCheck) {
		this.projectIncludeCheck = projectIncludeCheck;
	}
	
}
