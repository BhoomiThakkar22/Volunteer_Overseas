package com.volunteer.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectCosts;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.Projects;
import com.volunteer.services.IClientService;

@Controller
public class HomeController {
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping("contact")
	public ModelAndView contact_us(HttpServletRequest request){
		return new ModelAndView("contact_us");
	}
	
	@RequestMapping("savecontact")
	public String saveContact(HttpServletRequest request){
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String message = request.getParameter("message");
		clientService.AddInquiry(name,mail,message);
		return "redirect:/contact";
	}
	
	@RequestMapping("faq")
	public ModelAndView faq(){
		return new ModelAndView("faq");
	}
	
	@RequestMapping("homepage")
	public ModelAndView home(){
		List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projectsTrending=clientService.getAllTrendingProjects();
		List<Projects> projectsMostAffordable = clientService.getAllAffordableProjects();
		List<Integer> costProjectId = clientService.getAllAffordableCost(projectsMostAffordable);
		List<ProjectCosts> costs= clientService.getAllAffordableCostById(costProjectId);
		List<Projects> projectFeaturedest = clientService.getAllFeatureDest();
		return new ModelAndView("home").addObject("categories",categories)
				.addObject("activities",activities).addObject("projectsTrending",projectsTrending)
				.addObject("projectsMostAffordable",costs)
				.addObject("projectFeaturedest", projectFeaturedest);
	}
	@SuppressWarnings("unused")
	@RequestMapping("search_result")
	public ModelAndView search_result(HttpServletRequest request){
		String Country=request.getParameter("searchbar-location");
		String Activity=request.getParameter("searchbar-activity");
		String Category=request.getParameter("searchbar-category");
		List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projects=clientService.getProjectByFilter(Category,Country,Activity);
		int size = projects.size();
		if(size == 0){
			return new ModelAndView("search_result","location",Country)
					.addObject("categories", categories).addObject("activities",activities)
					.addObject("activity",Activity)
					.addObject("category",Category).addObject("size", size);
		}
		else{
			List<Integer> costProjectId = clientService.getAllAffordableCost(projects);
			List<ProjectCosts> costs= clientService.getAllAffordableCostById(costProjectId);	
			return new ModelAndView("search_result","location",Country)
				.addObject("categories", categories).addObject("activities",activities)
				.addObject("projects", costs).addObject("activity",Activity)
				.addObject("category",Category).addObject("size", size);
			
		}
	}
	@RequestMapping("search_result/moreFilter")
	public ModelAndView moreFilters(HttpServletRequest request,Model modal) throws ParseException{
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String year=request.getParameter("year");
		String lmonth=request.getParameter("lmonth");
		String lday=request.getParameter("lday");
		String lyear=request.getParameter("lyear");
		String modelcategory = request.getParameter("modelcategory");
		String modellocation = request.getParameter("modellocation");
		String modelactivity = request.getParameter("modelactivity");
		String range = request.getParameter("amount");
		String startdate= year+"-"+ month+"-"+ day;
		String startdate2= lyear+"-"+ lmonth+"-"+ lday;
	    int minage = Integer.parseInt(request.getParameter("minage"));
	    List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projects=clientService.getProjectByFilter(modelcategory,modellocation,modelactivity,startdate,startdate2,range,minage);
	    if(projects == null){
	    	String size = "No";
	    	return new ModelAndView("search_result","size",size).
					addObject("location",modellocation).                            
					addObject("category",modelcategory).
					addObject("activity",modelactivity).
					addObject("categories",categories).
					addObject("activities",activities);
	    }else{ 
	    int size = projects.size();
	    List<Integer> costProjectId = clientService.getAllAffordableCost(projects);
		List<ProjectCosts> costs= clientService.getAllAffordableCostById(costProjectId);
			return new ModelAndView("search_result","projects",costs).
					addObject("location",modellocation).                            
					addObject("category",modelcategory).
					addObject("activity",modelactivity).
					addObject("categories",categories).
					addObject("activities",activities).
					addObject("size", size);
	    }
	}
	@RequestMapping("index/signup")
	public ModelAndView apply_now(HttpServletRequest request) throws ParseException{
		int projectid=Integer.parseInt(request.getParameter("projectid"));
		String Fullname = request.getParameter("Full_name");
		String sDate1=request.getParameter("datepicker1");
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		int duration = Integer.parseInt(request.getParameter("dur1"));
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("mail");
		clientService.addApp(Fullname,date,duration,phone,email,projectid);
		return new ModelAndView("redirect:/index/project","id",projectid);
	}
	@RequestMapping("index")
	public ModelAndView project(HttpServletRequest request){
		int projectid=Integer.parseInt(request.getParameter("id"));
		Projects project=clientService.getProjectById(projectid);
		List<ProjectIncludeChecks> isInclude=clientService.getAllIncluded(projectid);
		List<ProjectIncludeChecks> isNotInclude=clientService.getAllNotIncluded(projectid);
		List<ProjectCosts> projectDuration = clientService.getProjectCost(projectid);
		return new ModelAndView("index").addObject("project",project)
				.addObject("included",isInclude).addObject("notincluded",isNotInclude)
				.addObject("projectDurationCost",projectDuration);
	}
	@RequestMapping("login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}
}
