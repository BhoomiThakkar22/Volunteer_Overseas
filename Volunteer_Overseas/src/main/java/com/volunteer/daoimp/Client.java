package com.volunteer.daoimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.volunteer.dao.IClient;
import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.ProjectViewHistory;
import com.volunteer.model.Projects;

public class Client implements IClient {
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Categories> getAllCategories() {		
		return sessionFactory.getCurrentSession().createQuery("from Categories").list() ;
	}
	
	@SuppressWarnings("unchecked")
	public List<Activities> getAllActivities() {		
		return sessionFactory.getCurrentSession().createQuery("from Activities").list() ;
	}
	
	@SuppressWarnings("unchecked")
	public List<Projects> getAllProjects(){
		return sessionFactory.getCurrentSession().createQuery("from Projects").list() ;
	}
	
	public Projects getProjectById(int projectid){
		return (Projects)sessionFactory.getCurrentSession().load(Projects.class, projectid);
	}
	
	@SuppressWarnings("unchecked")
	public List<Projects> getProjectByFilter(int category,int country,int activity){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Projects p where p.category.id=:category and p.country.id=:country and p.activity.id=:activity");
		query.setParameter("category", category);
		query.setParameter("country", country);
		query.setParameter("activity", activity);
		List<Projects> project=query.list();
		System.out.println(project.size());
		return project;
	}
	
	@SuppressWarnings("unchecked")
	public int getCategoryId(String Category){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("Select id from Categories where name= :Category");
		query.setParameter("Category", Category);
		List<Integer> results=query.list();
		if(results!=null){
			int temp=results.get(0);
			return temp;
		}
		else {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int getCountryId(String Country){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("Select id from Countries where name= :Country");
		query.setParameter("Country", Country);
		List<Integer> results=query.list();
		if(results!=null){
			int temp=results.get(0);
			return temp;
		}
		else {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int getActivityId(String Activity){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("Select Activity.id from Activities Activity where Activity.name= :Activity");
		query.setParameter("Activity", Activity);
		List<Integer> results=query.list();
		if(results!=null){
			int temp=results.get(0);
			return temp;
		}
		else {
			return 0;
		}
	}
	
	public void addApp(String fullname, Date date, int duration, int phone, String email,int projectid)
	{
		Session session = sessionFactory.getCurrentSession();
		Applications app=new Applications();
		app.setName(fullname);
		app.setDuration(duration);
		app.setEmail(email);
		app.setProject_startdate(date);
		app.setPhone(phone);
		Projects p = getProjectById(projectid);
		app.setProjectApplication(p);
		session.save(app);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectIncludeChecks> getAllIncluded(int projectid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ProjectIncludeChecks pic where pic.is_included=:isInclude and pic.projectIncludeCheck.id=:projectid");
		query.setParameter("isInclude", "yes");
		query.setParameter("projectid", projectid);
		List<ProjectIncludeChecks> results=query.list();
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<ProjectIncludeChecks> getAllNotIncluded(int projectid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ProjectIncludeChecks pic where pic.is_included=:isInclude and pic.projectIncludeCheck.id=:projectid");
		query.setParameter("isInclude", "no");
		query.setParameter("projectid", projectid);
		List<ProjectIncludeChecks> results=query.list();
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<Projects> getAllTrendingProjects(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select pvh.projectViewHistory,count(pvh.projectViewHistory.id) as c from ProjectViewHistory pvh group by pvh.projectViewHistory.id order by c desc");
		List<Object[]> trending = (List<Object[]>)query.list();
		List<Projects> project = new ArrayList<Projects>();
		for(Object[] projects: trending){
	         Projects p = (Projects)projects[0];
	         project.add(p);
	     }		
		return project;
	}
	@SuppressWarnings("unchecked")
	public List<Projects> getAllAffordableProjects(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select pvh.projectViewHistory,count(pvh.projectViewHistory.id) as c from ProjectViewHistory pvh where pvh.projectViewHistory.is_affordable=:isAffordable group by pvh.projectViewHistory.id order by c desc");
		query.setParameter("isAffordable", "yes");
		List<Object[]> affordable = (List<Object[]>)query.list();
		List<Projects> project = new ArrayList<Projects>();
		for(Object[] projects: affordable){
	         Projects p = (Projects)projects[0];
	         project.add(p);
	     }		
		return project;
	}
}
