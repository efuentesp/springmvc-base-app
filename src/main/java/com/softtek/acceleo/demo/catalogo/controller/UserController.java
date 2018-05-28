package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


import com.softtek.acceleo.demo.catalogo.bean.UserBean;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;

@Controller
public class UserController {
/**
	@Autowired
	private UserService userService;
	
	User user = new User();

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<User> getUsers(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<User> listUser = null;

		if (query==null && _page == 0 ) {
       		listUser = userService.listUserss(user);
			rows = userService.getTotalRows();
		} else if (query!= null){
			
		} else if (_page != 0){
			listUser = userService.listUsersPagination(user, _page, 10);
			rows = userService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listUser;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  User getUser(@PathVariable("id") int id) {
	        
	        user.setId(id);
	        
	        User user = null;
	        user = userService.getUser(id);
			return user;
	 }



	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
	   
	        userService.addUser(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<User> actualizarUser(@PathVariable("id") int id, @RequestBody User user) {
	        
	        
	        User userFound = userService.getUser(id);
	         
	        if (userFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	 
				userFound.setIdUser(user.getIdUser());
				userFound.setUserName(user.getUserName());
				userFound.setPassword(user.getPassword());
				userFound.setEstatus(user.getEstatus());
				userFound.setFechaCreacion(user.getFechaCreacion());
				userFound.setFechaModificacion(user.getFechaModificacion());
			user.setId(null);
	        
	        userService.editUser(userFound);
	        return new ResponseEntity<User>(userFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 long rows = 0;	
	    	 
	         User user = userService.getUser(id);
	         if (user == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	         }
	  
             

             if (rows==0){
	             userService.deleteUser(user);
            	 return new ResponseEntity<User>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<User>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody String saveUser(
			@ModelAttribute("command") UserBean userBean) {


		User user = prepareModel(userBean);
		userService.addUser(user);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public @ResponseBody String editUser(
			@ModelAttribute("command") UserBean userBean) {


		User user = prepareModel(userBean);
		userService.editUser(user);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public ModelAndView addUser(
			@ModelAttribute("command") UserBean userBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		User user = null;
		if (userBean != null)
			user = prepareModel(userBean);
		model.put("users",
				prepareListofBean(userService.listUserss(user)));
		return new ModelAndView("searchUser", model);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(
			@ModelAttribute("command") UserBean userBean,
			BindingResult result) {
		System.out.println("delete " + userBean.getId());
		userService.deleteUser(prepareModel(userBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", null);
		model.put("users",
				prepareListofBean(userService.listUserss(null)));
		return new ModelAndView("searchUser", model);
	}

	@RequestMapping(value = "/entryUser", method = RequestMethod.GET)
	public ModelAndView entryUser() {
		return new ModelAndView("redirect:/searchUser");
	}

	private User prepareModel(UserBean userBean) {
		User user = new User();

		user.setIdUser(userBean.getIdUser());
		user.setUserName(userBean.getUserName());
		user.setPassword(userBean.getPassword());
		user.setEstatus(userBean.getEstatus());
		user.setFechaCreacion(userBean.getFechaCreacion());
		user.setFechaModificacion(userBean.getFechaModificacion());
		user.setId(userBean.getId());
		userBean.setId(null);
		return user;
	}

	private List<UserBean> prepareListofBean(List<User> users) {
		List<UserBean> beans = null;
		if (users != null && !users.isEmpty()) {
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for (User user : users) {
				bean = new UserBean();

                bean.setIdUser(user.getIdUser());
                bean.setUserName(user.getUserName());
                bean.setPassword(user.getPassword());
                bean.setEstatus(user.getEstatus());
                bean.setFechaCreacion(user.getFechaCreacion());
                bean.setFechaModificacion(user.getFechaModificacion());
				bean.setId(user.getId());
				beans.add(bean);
			}
		}
		return beans;
	}
/**/
}


