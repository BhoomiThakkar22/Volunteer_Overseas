package com.volunteer.serviceimp;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.volunteer.dao.IClient;
import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.Projects;
import com.volunteer.services.IClientService;

@Service
@Transactional
public class ClientServiceImp implements IClientService {

	private IClient client;
	
	@Transactional
	public List<Categories> getAllCategories(){
		return client.getAllCategories();
	}

	@Transactional
	public List<Activities> getAllActivities(){
		return client.getAllActivities();
	}
	@Transactional
	public List<Projects> getAllProjects(){
		return client.getAllProjects();
	}
	@Transactional
	public Projects getProjectById(int projectid){
		Projects project= client.getProjectById(projectid);
		System.out.println(project.getId());
		return project;
	}
	@Transactional
	public List<Projects> getProjectByFilter(String Category,String Country,String Activity){
		
		int category =client.getCategoryId(Category);
		int country =client.getCountryId(Country);
		int activity=client.getActivityId(Activity);
		if(category!=0 || country!=0 || activity!=0){
			List<Projects> project=client.getProjectByFilter(category,country,activity);
			return project;
		}
		else{
			return null;
		}
		
	}
	
	public void addApp(String Fullname,Date date,int duration,int phone,String email,int projectid){
		client.addApp(Fullname,date,duration,phone,email,projectid);
	}
	
	public IClient getClient() {
		return client;
	}

	public void setClient(IClient client) {
		this.client = client;
	}
	
	public List<ProjectIncludeChecks> getAllIncluded(int projectid){
		return client.getAllIncluded(projectid);
	}
	public List<ProjectIncludeChecks> getAllNotIncluded(int projectid){
		return client.getAllNotIncluded(projectid);
	}
	public List<Projects> getAllTrendingProjects(){
		return client.getAllTrendingProjects();
	}
	public List<Projects> getAllAffordableProjects(){
		return client.getAllAffordableProjects();
	}
}
