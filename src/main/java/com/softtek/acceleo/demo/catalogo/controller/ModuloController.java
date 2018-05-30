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


import com.softtek.acceleo.demo.catalogo.bean.ModuloBean;
import com.softtek.acceleo.demo.domain.Modulo;
import com.softtek.acceleo.demo.service.ModuloService;

@Controller
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	Modulo modulo = new Modulo();

	@RequestMapping(value = "/modulo", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Modulo> getModulos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<Modulo> listModulo = null;

		if (query==null && _page == 0 ) {
       		listModulo = moduloService.listModuloss(modulo);
			rows = moduloService.getTotalRows();
		} else if (query!= null){
			
		} else if (_page != 0){
			listModulo = moduloService.listModulosPagination(modulo, _page, 10);
			rows = moduloService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listModulo;
	}
	
	@RequestMapping(value = "/modulo/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Modulo getModulo(@PathVariable("id") int id) {
	        
	        modulo.setId(id);
	        
	        Modulo modulo = null;
	        modulo = moduloService.getModulo(id);
			return modulo;
	 }



	 @RequestMapping(value = "/modulo", method = RequestMethod.POST)
	    public ResponseEntity<Void> createModulo(@RequestBody Modulo modulo,    UriComponentsBuilder ucBuilder) {
	   
	        moduloService.addModulo(modulo);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/modulo/{id}").buildAndExpand(modulo.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/modulo/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Modulo> actualizarModulo(@PathVariable("id") int id, @RequestBody Modulo modulo) {
	        
	        
	        Modulo moduloFound = moduloService.getModulo(id);
	         
	        if (moduloFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
	        }
	 
				moduloFound.setIdModulo(modulo.getIdModulo());
				moduloFound.setModulo(modulo.getModulo());
				moduloFound.setEstatus(modulo.getEstatus());
				moduloFound.setFechaCreacion(modulo.getFechaCreacion());
				moduloFound.setFechaModificacion(modulo.getFechaModificacion());
			modulo.setId(null);
	        
	        moduloService.editModulo(moduloFound);
	        return new ResponseEntity<Modulo>(moduloFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/modulo/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Modulo> deleteModulo(@PathVariable("id") int id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 long rows = 0;	
	    	 
	         Modulo modulo = moduloService.getModulo(id);
	         if (modulo == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<Modulo>(HttpStatus.NOT_FOUND);
	         }
	  
             

             if (rows==0){
	             moduloService.deleteModulo(modulo);
            	 return new ResponseEntity<Modulo>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<Modulo>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveModulo", method = RequestMethod.POST)
	public @ResponseBody String saveModulo(
			@ModelAttribute("command") ModuloBean moduloBean) {


		Modulo modulo = prepareModel(moduloBean);
		moduloService.addModulo(modulo);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editModulo", method = RequestMethod.POST)
	public @ResponseBody String editModulo(
			@ModelAttribute("command") ModuloBean moduloBean) {


		Modulo modulo = prepareModel(moduloBean);
		moduloService.editModulo(modulo);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchModulo", method = RequestMethod.GET)
	public ModelAndView addModulo(
			@ModelAttribute("command") ModuloBean moduloBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Modulo modulo = null;
		if (moduloBean != null)
			modulo = prepareModel(moduloBean);
		model.put("modulos",
				prepareListofBean(moduloService.listModuloss(modulo)));
		return new ModelAndView("searchModulo", model);
	}

	@RequestMapping(value = "/deleteModulo", method = RequestMethod.POST)
	public ModelAndView deleteModulo(
			@ModelAttribute("command") ModuloBean moduloBean,
			BindingResult result) {
		System.out.println("delete " + moduloBean.getId());
		moduloService.deleteModulo(prepareModel(moduloBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("modulo", null);
		model.put("modulos",
				prepareListofBean(moduloService.listModuloss(null)));
		return new ModelAndView("searchModulo", model);
	}

	@RequestMapping(value = "/entryModulo", method = RequestMethod.GET)
	public ModelAndView entryModulo() {
		return new ModelAndView("redirect:/searchModulo");
	}

	private Modulo prepareModel(ModuloBean moduloBean) {
		Modulo modulo = new Modulo();

		modulo.setIdModulo(moduloBean.getId());
		modulo.setModulo(moduloBean.getModulo());
		modulo.setEstatus(moduloBean.getEstatus());
		modulo.setFechaCreacion(moduloBean.getFechaCreacion());
		modulo.setFechaModificacion(moduloBean.getFechaModificacion());
		modulo.setId(moduloBean.getId());
		moduloBean.setId(null);
		return modulo;
	}

	private List<ModuloBean> prepareListofBean(List<Modulo> modulos) {
		List<ModuloBean> beans = null;
		if (modulos != null && !modulos.isEmpty()) {
			beans = new ArrayList<ModuloBean>();
			ModuloBean bean = null;
			for (Modulo modulo : modulos) {
				bean = new ModuloBean();

                bean.setId(modulo.getIdModulo());
                bean.setModulo(modulo.getModulo());
                bean.setEstatus(modulo.getEstatus());
                bean.setFechaCreacion(modulo.getFechaCreacion());
                bean.setFechaModificacion(modulo.getFechaModificacion());
				bean.setId(modulo.getId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


