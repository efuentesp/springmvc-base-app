/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los User. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.UserService;
import com.softtek.spring.seguridad.JwtAuthenticationProvider;

/**
 * Clase UserController.
 * @author PSG.
 *
 */
@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
/**/
	@Autowired
	private UserService userService;
	
	@Autowired
	JwtAuthenticationProvider jwtap;	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<User> getUsers(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		User user = new User();

       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		

		List<User> listUser = null;

		if (query==null && page == 0 ) {
       		listUser = userService.listUserss(user);
			rows = userService.getTotalRows();
		} /**else if (query!= null){
			
		}**/ else /**if (page != 0)**/{
			listUser = userService.listUsersPagination(user, page, 10);
			rows = userService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listUser;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  User getUser(@PathVariable("id") int id) {
	        User user = null;
	        user = userService.getUser(id);
			return user;
	 }



	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
	   
			//Se almacena la informacion del user, con un password temporal al cual no se le genero un token.
			userService.addUser(user);
			
			//Se consulta la informacion del user persistido anteriormente, esto con la finalidad de obtener el iduser
			List<User> lstUser = userService.consultarUser(user.getUserName());
			if( lstUser == null || lstUser.isEmpty() ) {
				logger.info("Error: No se pudo obtener la informacion del usuario.");
			}else {
				User userPrst = lstUser.get(0);
				
				String token = jwtap.makerToken(userPrst);
				userPrst.setPassword(token);
				
				//Se actualiza la informacion del user persistido anteriormente, se sustituye el password temporal, por el token generado con base a la informacion del user.
				userService.editUser(userPrst);
			}
		 	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getIdUser()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<User> actualizarUser(@PathVariable("id") int id, @RequestBody User user) {
	        
	        
	        User userFound = userService.getUser(id);
	         
	        if (userFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
			userFound.setIdUser(user.getIdUser());
			userFound.setUserName(user.getUserName());
			userFound.setPassword(user.getPassword());
			userFound.setRol(user.getRol());
			/**userFound.setEstatus(user.getEstatus());
			userFound.setFechaCreacion(user.getFechaCreacion());
			userFound.setFechaModificacion(user.getFechaModificacion());**/
			user.setIdUser(null);
	        
	        userService.editUser(userFound);
	        return new ResponseEntity<>(userFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
	    	 logger.info("Fetching & Deleting User with id " + id);
	    	 
             try{
    	         User user = userService.getUser(id);
    	         if (user == null) {
    	             logger.info("Unable to delete. Cuenta with id " + id + " not found");
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             userService.deleteUser(user);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody String saveUser(
			@ModelAttribute("command") UserBean userBean) {
		
		User user = prepareModel(userBean);
		user.setPassword("temporal");
		
		//Se almacena la informacion del user, con un password temporal al cual no se le genero un token.
		userService.addUser(user);
		
		//Se consulta la informacion del user persistido anteriormente, esto con la finalidad de obtener el iduser
		List<User> lstUser = userService.consultarUser(user.getUserName());
		if( lstUser == null || lstUser.isEmpty() ) {
			logger.info("Error: No se pudo obtener la informacion del usuario.");
		}else {
			User userPrst = lstUser.get(0);
			userPrst.setPassword(userBean.getPassword());
			
			String token = jwtap.makerToken(userPrst);
			userPrst.setPassword(token);
			
			//Se actualiza la informacion del user persistido anteriormente, se sustituye el password temporal, por el token generado con base a la informacion del user.
			userService.editUser(userPrst);
		}
		
		

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

		Map<String, Object> model = new HashMap<>();
		User user = null;
		if (userBean != null)
			user = prepareModel(userBean);
		model.put("users",
				prepareListofBean(userService.listUserss(user)));
		return new ModelAndView("searchUser", model);
	}

	@RequestMapping(value = "/entryUser", method = RequestMethod.GET)
	public ModelAndView entryUser() {
		return new ModelAndView("redirect:/searchUser");
	}

	private User prepareModel(UserBean userBean) {
		User user = new User();

		user.setIdUser(userBean.getId());
		user.setUserName(userBean.getUserName());
		user.setPassword(userBean.getPassword());
		user.setRol(userBean.getRol());
		/**user.setEstatus(userBean.getEstatus());
		user.setFechaCreacion(userBean.getFechaCreacion());
		user.setFechaModificacion(userBean.getFechaModificacion());
		user.setId(userBean.getId());**/
		userBean.setId(null);
		return user;
	}

	private List<UserBean> prepareListofBean(List<User> users) {
		List<UserBean> beans = null;
		if (users != null && !users.isEmpty()) {
			beans = new ArrayList<>();
			UserBean bean = null;
			for (User user : users) {
				bean = new UserBean();

                bean.setId(user.getIdUser());
                bean.setUserName(user.getUserName());
                bean.setPassword(user.getPassword());
                /**bean.setEstatus(user.getEstatus());
                bean.setFechaCreacion(user.getFechaCreacion());
                bean.setFechaModificacion(user.getFechaModificacion());
				bean.setId(user.getId());**/
				beans.add(bean);
			}
		}
		return beans;
	}
/**/
}


