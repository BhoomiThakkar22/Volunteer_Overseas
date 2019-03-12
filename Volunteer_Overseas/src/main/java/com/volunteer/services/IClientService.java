package com.volunteer.services;

import java.util.Date;
import java.util.List;

import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.Projects;

public interface IClientService {

	public List<Categories> getAllCategories();
	public List<Activities> getAllActivities();
	public Projects getProjectById(int projectid);
	public List<Projects> getAllProjects();
	public List<Projects> getProjectByFilter(String Category,String Country,String Activity);
	public void addApp(String Fullname,Date date,int duration,int phone,String email,int projectid);
	public List<ProjectIncludeChecks> getAllIncluded(int projectid); 
	public List<ProjectIncludeChecks> getAllNotIncluded(int projectid);
	public List<Projects> getAllTrendingProjects();
	public List<Projects> getAllAffordableProjects(); 
}
