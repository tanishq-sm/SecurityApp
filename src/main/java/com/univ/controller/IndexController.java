package com.univ.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.univ.model.RegModel;
import com.univ.service.RegService;



@Controller
public class IndexController {
	
	@Autowired
	private RegService regService;	
	
	HttpSession hs=null;
@RequestMapping("/")
public ModelAndView index()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}
@RequestMapping("/home")
public ModelAndView index1()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}
@RequestMapping("/about")
public ModelAndView about()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("about");
	return mv;
}
@RequestMapping("/service")
public ModelAndView service()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("service");
	return mv;
}
// when we will click on login
@RequestMapping("/login")
public ModelAndView login()
{
	ModelAndView mv=new ModelAndView();
	if(hs!=null) //old session check
	{
		hs.invalidate();	//destroy old session
		hs=null;
	}
	mv.setViewName("login");
	return mv;
}

// this will work when we will give user name and password
@RequestMapping(path="/login", method = RequestMethod.POST)
public ModelAndView login1(@ModelAttribute("log") RegModel log,   
        HttpServletRequest req,Model model)
{
	
	ModelAndView mv=new ModelAndView();
	if (log.getUnm().isBlank()) {
		mv.setViewName("redirect:/login");
	}

	List<RegModel> lt = this.regService.loginCheck(log);
	hs=req.getSession(false);
	if(hs!=null)//old session check
    {
		hs.invalidate();
		hs=null;
    }
	
    hs=  req.getSession(true);  //create new session
    RegModel cd=(RegModel)lt.get(0); 
    String unm=cd.getUnm();
    hs.setAttribute("unm",unm); //put user name in a session
	mv.setViewName("index");   // set a view name
	return mv;
}

@RequestMapping("/guard")
public ModelAndView guard()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("guard");
	return mv;
}
//when we will click on reg link
@RequestMapping("/reg")
public ModelAndView reg1()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("registration");
	return mv;
}

//this will when we will submit registration page
@RequestMapping(path="/reg", method = RequestMethod.POST)
public ModelAndView reg(@ModelAttribute("reg") RegModel reg,   
		        HttpServletRequest req,Model model)
{
ModelAndView mv=new ModelAndView();	
	if (reg.getCname().isBlank()) {
		mv.setViewName("redirect:/registration");
	}
	int x = this.regService.createUser(reg);
	if(x>0)
	mv.setViewName("login");
	else
	mv.setViewName("registration");
	return mv;
}


}
