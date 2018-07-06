/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los beneficiarios. 
 */
package com.softtek.acceleo.demo.security.controller;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.catalogo.bean.BeneficiarioBean;
import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.BeneficiarioService;

/**
 * Clase BeneficiarioController.
 * @author PSG.
 *
 */
@RestController
public class BeneficiarioController {
	private static final Logger logger = Logger.getLogger(BeneficiarioController.class);
	
	@Autowired
	private BeneficiarioService beneficiarioService;
	
	
	@RequestMapping(value = "/beneficiario", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('BENEFICIARIOSEARCH')")
	public @ResponseBody  List<Beneficiario> getBeneficiarios(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		Beneficiario beneficiario = new Beneficiario();
		
       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		List<Beneficiario> listBeneficiario = null;

		if (query==null && page == 0) {
       		listBeneficiario = beneficiarioService.listBeneficiarios(beneficiario);
			rows = beneficiarioService.getTotalRows();
		} else if (query!= null){
			listBeneficiario = beneficiarioService.listBeneficiariosQuery(beneficiario, query, page, 10);
			rows = beneficiarioService.getTotalRowsSearch(query);
		} else /**if (page != 0)**/{
			listBeneficiario = beneficiarioService.listBeneficiariosPagination(beneficiario, page, 10);
			rows = beneficiarioService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listBeneficiario;
	}
	
	@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('BENEFICIARIOSEARCH')")
	    public @ResponseBody  Beneficiario getBeneficiario(@PathVariable("id") int id) {	        
	        Beneficiario beneficiario = null;
	        
	        beneficiario = beneficiarioService.getBeneficiario(id);
			return beneficiario;
	 }

	 @RequestMapping(value = "/beneficiario", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('BENEFICIARIOCREATE')")
	    public ResponseEntity<Void> createBeneficiario(@RequestBody Beneficiario beneficiario,    UriComponentsBuilder ucBuilder) {
	   
	        beneficiarioService.addBeneficiario(beneficiario);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/beneficiario/{id}").buildAndExpand(beneficiario.getBeneficiarioId()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('BENEFICIARIOUPDATE')")
	    public ResponseEntity<Beneficiario> actualizarBeneficiario(
				@PathVariable("id") int id, 
				@RequestBody Beneficiario beneficiario) {
	        
	        Beneficiario beneficiarioFound = beneficiarioService.getBeneficiario(id);
	         
	        if (beneficiarioFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				beneficiarioFound.setParentescoId(beneficiario.getParentescoId());
			
				beneficiarioFound.setCurp(beneficiario.getCurp());
				beneficiarioFound.setNombre(beneficiario.getNombre());
				beneficiarioFound.setApellido_paterno(beneficiario.getApellido_paterno());
				beneficiarioFound.setApellido_materno(beneficiario.getApellido_materno());
				beneficiarioFound.setFecha_nacimiento(beneficiario.getFecha_nacimiento());
			
			beneficiarioFound.setBeneficiarioId(beneficiario.getBeneficiarioId());

		    beneficiarioService.editBeneficiario(beneficiarioFound);
	        return new ResponseEntity<>(beneficiarioFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/beneficiario/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('BENEFICIARIODELETE')")
	    public ResponseEntity<Beneficiario> deleteBeneficiario(@PathVariable("id") int id) {
	  
             try{
    	         Beneficiario beneficiario = beneficiarioService.getBeneficiario(id);
    	         if (beneficiario == null) {
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }

	             beneficiarioService.deleteBeneficiario(beneficiario);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveBeneficiario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('BENEFICIARIO')")
	public @ResponseBody String saveBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {

		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.addBeneficiario(beneficiario);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editBeneficiario", method = RequestMethod.POST)
	@PreAuthorize("hasRole('BENEFICIARIO')")
	public @ResponseBody String editBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean) {


		Beneficiario beneficiario = prepareModel(beneficiarioBean);
		beneficiarioService.editBeneficiario(beneficiario);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchBeneficiario", method = RequestMethod.GET)
	@PreAuthorize("hasRole('BENEFICIARIO')")
	public ModelAndView addBeneficiario(
			@ModelAttribute("command") BeneficiarioBean beneficiarioBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		Beneficiario beneficiario = null;
		if (beneficiarioBean != null)
			beneficiario = prepareModel(beneficiarioBean);
		model.put("beneficiarios",
				prepareListofBean(beneficiarioService.listBeneficiarios(beneficiario)));
		return new ModelAndView("searchBeneficiario", model);
	}

	@RequestMapping(value = "/entryBeneficiario", method = RequestMethod.GET)
	public ModelAndView entryBeneficiario() {
		return new ModelAndView("redirect:/searchBeneficiario");
	}

	private Beneficiario prepareModel(BeneficiarioBean beneficiarioBean) {
		Beneficiario beneficiario = new Beneficiario();

		/**beneficiarioTmp.setParentescoId(beneficiarioBean.getParentescoId());**/
		beneficiario.setCurp(beneficiarioBean.getCurp());
		beneficiario.setNombre(beneficiarioBean.getNombre());
		beneficiario.setApellido_paterno(beneficiarioBean.getApellidoPaterno());
		beneficiario.setApellido_materno(beneficiarioBean.getApellidoMaterno());
		beneficiario.setFecha_nacimiento(beneficiarioBean.getFechaNacimiento());
		beneficiario.setBeneficiarioId(beneficiarioBean.getBeneficiarioId());
		beneficiarioBean.setBeneficiarioId(null);

		return beneficiario;
	}

	private List<BeneficiarioBean> prepareListofBean(List<Beneficiario> beneficiarios) {
		List<BeneficiarioBean> beans = null;
		if (beneficiarios != null && !beneficiarios.isEmpty()) {
			beans = new ArrayList<>();
			BeneficiarioBean bean = null;
			for (Beneficiario beneficiario : beneficiarios) {
				bean = new BeneficiarioBean();

				/**bean.setParentescoId(beneficiarioTmp.getParentescoId());**/
				bean.setCurp(beneficiario.getCurp());
				bean.setNombre(beneficiario.getNombre());
				bean.setApellidoPaterno(beneficiario.getApellido_paterno());
				bean.setApellidoMaterno(beneficiario.getApellido_materno());
				bean.setFechaNacimiento(beneficiario.getFecha_nacimiento());
				bean.setBeneficiarioId(beneficiario.getBeneficiarioId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


