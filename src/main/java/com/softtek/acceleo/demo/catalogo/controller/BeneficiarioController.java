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

import com.softtek.acceleo.demo.catalogo.bean.BeneficiarioBean;
import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.service.BeneficiarioService;

@Controller
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService beneficiarioService;
	
	Beneficiario beneficiario = new Beneficiario();

	@RequestMapping(value = "/beneficiario", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Beneficiario> getBeneficiarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Beneficiario> listBeneficiario = null;

		if (query==null && _page == 0) {
       		listBeneficiario = beneficiarioService.listBeneficiarios(beneficiario);
			rows = beneficiarioService.getTotalRows();
		} else if (query!= null){
			listBeneficiario = beneficiarioService.listBeneficiariosQuery(beneficiario, query, _page, 10);
			rows = beneficiarioService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listBeneficiario = beneficiarioService.listBeneficiariosPagination(beneficiario, _page, 10);
			rows = beneficiarioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listBeneficiario;
	}
	
	@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Beneficiario getBeneficiario(@PathVariable("id") int id) {
	        
	        beneficiario.setBeneficiarioId(id);
	        
	        Beneficiario beneficiario = null;
	        beneficiario = beneficiarioService.getBeneficiario(id);
			return beneficiario;
	 }



	 @RequestMapping(value = "/beneficiario", method = RequestMethod.POST)
	    public ResponseEntity<Void> createBeneficiario(@RequestBody Beneficiario beneficiario,    UriComponentsBuilder ucBuilder) {
	   
	        beneficiarioService.addBeneficiario(beneficiario);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/beneficiario/{id}").buildAndExpand(beneficiario.getBeneficiarioId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Beneficiario> actualizarBeneficiario(
				@PathVariable("id") int id, 
				@RequestBody Beneficiario beneficiario) {
	        
	        Beneficiario beneficiarioFound = beneficiarioService.getBeneficiario(id);
	         
	        if (beneficiarioFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Beneficiario>(HttpStatus.NOT_FOUND);
	        }
	 
				beneficiarioFound.setParentescoId(beneficiario.getParentescoId());
			
				beneficiarioFound.setCurp(beneficiario.getCurp());
				beneficiarioFound.setNombre(beneficiario.getNombre());
				beneficiarioFound.setApellido_paterno(beneficiario.getApellido_paterno());
				beneficiarioFound.setApellido_materno(beneficiario.getApellido_materno());
				beneficiarioFound.setFecha_nacimiento(beneficiario.getFecha_nacimiento());
			
			beneficiarioFound.setBeneficiarioId(beneficiario.getBeneficiarioId());

		    beneficiarioService.editBeneficiario(beneficiarioFound);
	        return new ResponseEntity<Beneficiario>(beneficiarioFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Beneficiario> deleteBeneficiario(@PathVariable("id") int id) {
			 long rows = 0;	
	    	 
	         Beneficiario beneficiario = beneficiarioService.getBeneficiario(id);
	         if (beneficiario == null) {
	             return new ResponseEntity<Beneficiario>(HttpStatus.NOT_FOUND);
	         }
	  
             if (rows==0){
	             beneficiarioService.deleteBeneficiario(beneficiario);
            	 return new ResponseEntity<Beneficiario>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<Beneficiario>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveBeneficiario", method = RequestMethod.POST)
	public @ResponseBody String saveBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {

		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.addBeneficiario(beneficiario);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editBeneficiario", method = RequestMethod.POST)
	public @ResponseBody String editBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {


		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.editBeneficiario(beneficiario);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchBeneficiario", method = RequestMethod.GET)
	public ModelAndView addBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Beneficiario beneficiario = null;
		if (beneficiarioBean != null)
			beneficiario = prepareModel(beneficiarioBean);
		model.put("beneficiarios",
				prepareListofBean(beneficiarioService.listBeneficiarios(beneficiario)));
		return new ModelAndView("searchBeneficiario", model);
	}

	@RequestMapping(value = "/deleteBeneficiario", method = RequestMethod.POST)
	public ModelAndView deleteBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean,
			BindingResult result) {
		System.out.println("delete " + beneficiarioBean.getBeneficiarioId());
		beneficiarioService.deleteBeneficiario(prepareModel(beneficiarioBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("beneficiario", null);
		model.put("beneficiarios",
				prepareListofBean(beneficiarioService.listBeneficiarios(null)));
		return new ModelAndView("searchBeneficiario", model);
	}

	@RequestMapping(value = "/entryBeneficiario", method = RequestMethod.GET)
	public ModelAndView entryBeneficiario() {
		return new ModelAndView("redirect:/searchBeneficiario");
	}

	private Beneficiario prepareModel(BeneficiarioBean beneficiarioBean) {
		Beneficiario beneficiario = new Beneficiario();

		//beneficiario.setParentescoId(beneficiarioBean.getParentescoId());
		beneficiario.setCurp(beneficiarioBean.getCurp());
		beneficiario.setNombre(beneficiarioBean.getNombre());
		beneficiario.setApellido_paterno(beneficiarioBean.getApellido_paterno());
		beneficiario.setApellido_materno(beneficiarioBean.getApellido_materno());
		beneficiario.setFecha_nacimiento(beneficiarioBean.getFecha_nacimiento());
		beneficiario.setBeneficiarioId(beneficiarioBean.getBeneficiarioId());
		beneficiarioBean.setBeneficiarioId(null);

		return beneficiario;
	}

	private List<BeneficiarioBean> prepareListofBean(List<Beneficiario> beneficiarios) {
		List<BeneficiarioBean> beans = null;
		if (beneficiarios != null && !beneficiarios.isEmpty()) {
			beans = new ArrayList<BeneficiarioBean>();
			BeneficiarioBean bean = null;
			for (Beneficiario beneficiario : beneficiarios) {
				bean = new BeneficiarioBean();

				//bean.setParentescoId(beneficiario.getParentescoId());
				bean.setCurp(beneficiario.getCurp());
				bean.setNombre(beneficiario.getNombre());
				bean.setApellido_paterno(beneficiario.getApellido_paterno());
				bean.setApellido_materno(beneficiario.getApellido_materno());
				bean.setFecha_nacimiento(beneficiario.getFecha_nacimiento());
				bean.setBeneficiarioId(beneficiario.getBeneficiarioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


