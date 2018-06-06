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


import com.softtek.acceleo.demo.catalogo.bean.ModuloaAccionAuthorityBean;
import com.softtek.acceleo.demo.domain.ModuloaAccionAuthority;
import com.softtek.acceleo.demo.service.ModuloaAccionAuthorityService;

@Controller
public class ModuloaAccionAuthorityController {

	@Autowired
	private ModuloaAccionAuthorityService moduloaaccionauthorityService;
	
	ModuloaAccionAuthority moduloaaccionauthority = new ModuloaAccionAuthority();

	@RequestMapping(value = "/moduloaaccionauthority", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ModuloaAccionAuthority> getModuloaAccionAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<ModuloaAccionAuthority> listModuloaAccionAuthority = null;

		if (query==null && _page == 0 ) {
       		listModuloaAccionAuthority = moduloaaccionauthorityService.listModuloaAccionAuthorityss(moduloaaccionauthority);
			rows = moduloaaccionauthorityService.getTotalRows();
		} else if (query!= null){
			
		} else if (_page != 0){
			listModuloaAccionAuthority = moduloaaccionauthorityService.listModuloaAccionAuthoritysPagination(moduloaaccionauthority, _page, 10);
			rows = moduloaaccionauthorityService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listModuloaAccionAuthority;
	}
	
	@RequestMapping(value = "/moduloaaccionauthority/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  ModuloaAccionAuthority getModuloaAccionAuthority(@PathVariable("id") int id) {
	        
	        moduloaaccionauthority.setIdmoduloaccionauthority(id);
	        
	        ModuloaAccionAuthority moduloaaccionauthority = null;
	        moduloaaccionauthority = moduloaaccionauthorityService.getModuloaAccionAuthority(id);
			return moduloaaccionauthority;
	 }



	 @RequestMapping(value = "/moduloaaccionauthority", method = RequestMethod.POST)
	    public ResponseEntity<Void> createModuloaAccionAuthority(@RequestBody ModuloaAccionAuthority moduloaaccionauthority,    UriComponentsBuilder ucBuilder) {
	   
	        moduloaaccionauthorityService.addModuloaAccionAuthority(moduloaaccionauthority);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/moduloaaccionauthority/{id}").buildAndExpand(moduloaaccionauthority.getIdmoduloaccionauthority()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/moduloaaccionauthority/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<ModuloaAccionAuthority> actualizarModuloaAccionAuthority(@PathVariable("id") int id, @RequestBody ModuloaAccionAuthority moduloaaccionauthority) {
	        
	        
	        ModuloaAccionAuthority moduloaaccionauthorityFound = moduloaaccionauthorityService.getModuloaAccionAuthority(id);
	         
	        if (moduloaaccionauthorityFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<ModuloaAccionAuthority>(HttpStatus.NOT_FOUND);
	        }
	 
				moduloaaccionauthorityFound.setIdmoduloaccionauthority(moduloaaccionauthority.getIdmoduloaccionauthority());
				moduloaaccionauthorityFound.setIdModuloAccion(moduloaaccionauthority.getIdModuloAccion());
				moduloaaccionauthorityFound.setIdAuthority(moduloaaccionauthority.getIdAuthority());
				moduloaaccionauthorityFound.setEstatus(moduloaaccionauthority.getEstatus());
				moduloaaccionauthorityFound.setFechaCreacion(moduloaaccionauthority.getFechaCreacion());
				moduloaaccionauthorityFound.setFechaModificacion(moduloaaccionauthority.getFechaModificacion());
	        
	        moduloaaccionauthorityService.editModuloaAccionAuthority(moduloaaccionauthorityFound);
	        return new ResponseEntity<ModuloaAccionAuthority>(moduloaaccionauthorityFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/moduloaaccionauthority/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<ModuloaAccionAuthority> deleteModuloaAccionAuthority(@PathVariable("id") int id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 long rows = 0;	
	    	 
	         ModuloaAccionAuthority moduloaaccionauthority = moduloaaccionauthorityService.getModuloaAccionAuthority(id);
	         if (moduloaaccionauthority == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<ModuloaAccionAuthority>(HttpStatus.NOT_FOUND);
	         }
	  
             

             if (rows==0){
	             moduloaaccionauthorityService.deleteModuloaAccionAuthority(moduloaaccionauthority);
            	 return new ResponseEntity<ModuloaAccionAuthority>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<ModuloaAccionAuthority>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveModuloaAccionAuthority", method = RequestMethod.POST)
	public @ResponseBody String saveModuloaAccionAuthority(
			@ModelAttribute("command") ModuloaAccionAuthorityBean moduloaaccionauthorityBean) {


		ModuloaAccionAuthority moduloaaccionauthority = prepareModel(moduloaaccionauthorityBean);
		moduloaaccionauthorityService.addModuloaAccionAuthority(moduloaaccionauthority);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editModuloaAccionAuthority", method = RequestMethod.POST)
	public @ResponseBody String editModuloaAccionAuthority(
			@ModelAttribute("command") ModuloaAccionAuthorityBean moduloaaccionauthorityBean) {


		ModuloaAccionAuthority moduloaaccionauthority = prepareModel(moduloaaccionauthorityBean);
		moduloaaccionauthorityService.editModuloaAccionAuthority(moduloaaccionauthority);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchModuloaAccionAuthority", method = RequestMethod.GET)
	public ModelAndView addModuloaAccionAuthority(
			@ModelAttribute("command") ModuloaAccionAuthorityBean moduloaaccionauthorityBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		ModuloaAccionAuthority moduloaaccionauthority = null;
		if (moduloaaccionauthorityBean != null)
			moduloaaccionauthority = prepareModel(moduloaaccionauthorityBean);
		model.put("moduloaaccionauthoritys",
				prepareListofBean(moduloaaccionauthorityService.listModuloaAccionAuthorityss(moduloaaccionauthority)));
		return new ModelAndView("searchModuloaAccionAuthority", model);
	}

	@RequestMapping(value = "/deleteModuloaAccionAuthority", method = RequestMethod.POST)
	public ModelAndView deleteModuloaAccionAuthority(
			@ModelAttribute("command") ModuloaAccionAuthorityBean moduloaaccionauthorityBean,
			BindingResult result) {
		System.out.println("delete " + moduloaaccionauthorityBean.getIdmoduloaccionauthority());
		moduloaaccionauthorityService.deleteModuloaAccionAuthority(prepareModel(moduloaaccionauthorityBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("moduloaaccionauthority", null);
		model.put("moduloaaccionauthoritys",
				prepareListofBean(moduloaaccionauthorityService.listModuloaAccionAuthorityss(null)));
		return new ModelAndView("searchModuloaAccionAuthority", model);
	}

	@RequestMapping(value = "/entryModuloaAccionAuthority", method = RequestMethod.GET)
	public ModelAndView entryModuloaAccionAuthority() {
		return new ModelAndView("redirect:/searchModuloaAccionAuthority");
	}

	private ModuloaAccionAuthority prepareModel(ModuloaAccionAuthorityBean moduloaaccionauthorityBean) {
		ModuloaAccionAuthority moduloaaccionauthority = new ModuloaAccionAuthority();

		moduloaaccionauthority.setIdmoduloaccionauthority(moduloaaccionauthorityBean.getIdmoduloaccionauthority());
		moduloaaccionauthority.setIdModuloAccion(moduloaaccionauthorityBean.getIdModuloAccion());
		moduloaaccionauthority.setIdAuthority(moduloaaccionauthorityBean.getIdAuthority());
		moduloaaccionauthority.setEstatus(moduloaaccionauthorityBean.getEstatus());
		moduloaaccionauthority.setFechaCreacion(moduloaaccionauthorityBean.getFechaCreacion());
		moduloaaccionauthority.setFechaModificacion(moduloaaccionauthorityBean.getFechaModificacion());
		moduloaaccionauthorityBean.setIdmoduloaccionauthority(null);
		return moduloaaccionauthority;
	}

	private List<ModuloaAccionAuthorityBean> prepareListofBean(List<ModuloaAccionAuthority> moduloaaccionauthoritys) {
		List<ModuloaAccionAuthorityBean> beans = null;
		if (moduloaaccionauthoritys != null && !moduloaaccionauthoritys.isEmpty()) {
			beans = new ArrayList<ModuloaAccionAuthorityBean>();
			ModuloaAccionAuthorityBean bean = null;
			for (ModuloaAccionAuthority moduloaaccionauthority : moduloaaccionauthoritys) {
				bean = new ModuloaAccionAuthorityBean();

                bean.setIdmoduloaccionauthority(moduloaaccionauthority.getIdmoduloaccionauthority());
                bean.setIdModuloAccion(moduloaaccionauthority.getIdModuloAccion());
                bean.setIdAuthority(moduloaaccionauthority.getIdAuthority());
                bean.setEstatus(moduloaaccionauthority.getEstatus());
                bean.setFechaCreacion(moduloaaccionauthority.getFechaCreacion());
                bean.setFechaModificacion(moduloaaccionauthority.getFechaModificacion());
				beans.add(bean);
			}
		}
		return beans;
	}

}


