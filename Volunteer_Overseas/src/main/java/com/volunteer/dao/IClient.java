package com.volunteer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.Projects;
@Repository
public interface IClient {

	public List<Categories> getAllCategories();
	public List<Activities> getAllActivities();
	public Projects getProjectById(int projectid);
	public List<Projects> getAllProjects();
	public List<Projects> getProjectByFilter(int category,int country,int activity);
	public int getCategoryId(String Category);
	public int getCountryId(String Country);
	public int getActivityId(String Activity);
	public void addApp(String fullname, Date date, int duration, int phone, String email,int projectid);
	public List<ProjectIncludeChecks> getAllIncluded(int projectid);
	public List<ProjectIncludeChecks> getAllNotIncluded(int projectid);
	public List<Projects> getAllTrendingProjects();
	public List<Projects> getAllAffordableProjects();
}
