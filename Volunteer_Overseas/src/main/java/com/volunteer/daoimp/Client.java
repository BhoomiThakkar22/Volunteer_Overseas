package com.volunteer.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.volunteer.dao.IClient;
import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectCosts;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.ProjectStartDates;
import com.volunteer.model.ProjectViewHistory;
import com.volunteer.model.Projects;
import com.volunteer.model.inquiry;

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
		return project;
	}
	
	@SuppressWarnings("unchecked")
	public List<Projects> getMoreFiltersProjects(int category, int country, int activity, List<Integer> startdateid,
			List<Integer> rangeArea, int minage){
		Session session=sessionFactory.getCurrentSession();
	//	Set<ProjectStartDates> projectsdate = new HashSet<ProjectStartDates>();
	//	projectsdate.addAll(startdateid);
		Query query = session.createQuery("from Projects p where p.category.id=:category and p.country.id=:country and p.activity.id=:activity "
				+ "and p.min_age<= :minage and p.id IN :startdate and p.id IN :range");
		query.setParameter("category", category);
		query.setParameter("country", country);
		query.setParameter("activity", activity);
		query.setParameterList("startdate", startdateid);
		query.setParameterList("range", rangeArea);
		query.setParameter("minage", minage);
		List<Projects> project=query.list();
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
	public List<Integer> getStartdateId(String startdate,String startdate2) throws ParseException{
		
		Session session = sessionFactory.getCurrentSession();
		String sdate1 = startdate;
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sdate1);
		String sdate2 = startdate2;
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sdate2);
		Query query= session.createQuery("Select p.projectStartDate.id from ProjectStartDates p where p.start_date BETWEEN :stDate AND :edDate ");
		query.setParameter("stDate", date1);
		query.setParameter("edDate", date2);
		List<Integer> dateId = query.list();
		System.out.println("dateid is"+dateId);
		return dateId;
	}
	@SuppressWarnings("unchecked")
	public List<Integer> getRange(int range1, int range2){
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("Select p.projectCost.id from ProjectCosts p where p.number_of_weeks BETWEEN :sWeek AND :eWeek ");
		query.setParameter("sWeek", range1);
		query.setParameter("eWeek", range2);
		List<Integer> rangeId = query.list();
		System.out.println("week id is"+rangeId);
		return rangeId;
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
	@SuppressWarnings("unchecked")
	public List<ProjectCosts> getAllAffordableCostById(List<Integer> costProjectId){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ProjectCosts p where p.projectCost.id IN :projectId");
		query.setParameterList("projectId", costProjectId);
		List<ProjectCosts> results = query.list();
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<Projects> getAllFeatureDest(){
		 Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from Projects p group by p.city.id order by count(p.city.id) desc");
		 List<Projects> results = query.list();
		 return results;
	 }
	@SuppressWarnings("unchecked")
	public List<ProjectCosts> getProjectCost(int projectid){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ProjectCosts pc where pc.projectCost.id=:projectid");
		query.setParameter("projectid",projectid);
		List<ProjectCosts> results = query.list();
		return results;
	}
	 public ProjectCosts getProjectCostvalue(int id)
	 {
		 Session session = sessionFactory.getCurrentSession();
		 ProjectCosts pc = (ProjectCosts)session.load(ProjectCosts.class, id);
		 System.out.println(pc.getCost());
		 return pc;
	 }
	 public void AddInquiry(String name, String mail, String message){
		 Session session = sessionFactory.getCurrentSession();
		 session.save(new inquiry(name,mail,message));
	 }
}
