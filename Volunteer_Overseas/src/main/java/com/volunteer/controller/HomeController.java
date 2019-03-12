package com.volunteer.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.volunteer.model.Activities;
import com.volunteer.model.Applications;
import com.volunteer.model.Categories;
import com.volunteer.model.ProjectIncludeChecks;
import com.volunteer.model.Projects;
import com.volunteer.services.IClientService;

@Controller
public class HomeController {
	
	@Autowired
	private IClientService clientService;
	
	
	@RequestMapping("contact")
	public ModelAndView contact_us(){
		
		return new ModelAndView("contact_us");
	}
	@RequestMapping("faq")
	public ModelAndView faq(){
		return new ModelAndView("faq");
	}
	
/*	@RequestMapping("homepage")
	public ModelAndView home(){
		List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projects=clientService.getAllProjects();
		System.out.println(projects.size());
		return new ModelAndView("home").addObject("categories",categories).addObject("activities",activities).addObject("projects",projects);
	}*/
	@RequestMapping("homepage")
	public ModelAndView home(){
		List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projectsTrending=clientService.getAllTrendingProjects();
		List<Projects> projectsMostAffordable = clientService.getAllAffordableProjects();
		return new ModelAndView("home").addObject("categories",categories).addObject("activities",activities).addObject("projectsTrending",projectsTrending).addObject("projectsMostAffordable",projectsMostAffordable);
	}

	@RequestMapping("search_result")
	public ModelAndView search_result(HttpServletRequest request){
		String Country=request.getParameter("searchbar-location");
		String Activity=request.getParameter("searchbar-activity");
		String Category=request.getParameter("searchbar-category");
		System.out.println(Country);
		List<Categories> categories=clientService.getAllCategories();
		List<Activities> activities=clientService.getAllActivities();
		List<Projects> projects=clientService.getProjectByFilter(Category,Country,Activity);
		/*if(projects==null){
			System.out.println("in null");
			return new ModelAndView("search_result","location",Country).addObject("categories", categories).addObject("activities",activities).addObject("projects", projects).addObject("activity",Activity).addObject("category",Category);
		}
		else {
			return new ModelAndView("search_result","location",Country).addObject("categories", categories).addObject("activities",activities).addObject("activity",Activity).addObject("category",Category);
		}*/
		return new ModelAndView("search_result","location",Country).addObject("categories", categories).addObject("activities",activities).addObject("projects", projects).addObject("activity",Activity).addObject("category",Category);

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
		System.out.println("done signup");
		return new ModelAndView("redirect:/index/project","id",projectid);
	}
	
	@RequestMapping("index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("index/project")
	public ModelAndView project(HttpServletRequest request){
		int projectid=Integer.parseInt(request.getParameter("id"));
		Projects project=clientService.getProjectById(projectid);
		List<ProjectIncludeChecks> isInclude=clientService.getAllIncluded(projectid);
		List<ProjectIncludeChecks> isNotInclude=clientService.getAllNotIncluded(projectid);
		return new ModelAndView("index").addObject("project",project).addObject("included",isInclude).addObject("notincluded",isNotInclude);
	}
	
	@RequestMapping("login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("search_result/moreFilter")
	public ModelAndView moreFilters(HttpServletRequest request){
		String check=request.getParameter("");
		return new ModelAndView("search_result");
	}
	
}
