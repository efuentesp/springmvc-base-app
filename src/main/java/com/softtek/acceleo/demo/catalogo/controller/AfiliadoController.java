/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los afiliados. 
 */
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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

import com.softtek.acceleo.demo.catalogo.bean.AfiliadoBean;
import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.service.AfiliadoService;

/**
 * Clase AfiliadoController.
 * @author PSG.
 *
 */

@RestController
@RequestMapping("protected")
public class AfiliadoController {

	@Autowired
	private AfiliadoService afiliadoService;	
	
	Afiliado afiliado = new Afiliado();

	/**
	 * Obtiene informacion de los afilliados.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Afiliado>.
	 */
	@RequestMapping(value = "/afiliado", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody  List<Afiliado> getAfiliados(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Afiliado> listAfiliado = null;

		if (query==null && _page == 0) {
       		listAfiliado = afiliadoService.listAfiliados(afiliado);
			rows = afiliadoService.getTotalRows();
		} else if (query!= null){
			listAfiliado = afiliadoService.listAfiliadosQuery(afiliado, query, _page, 10);
			rows = afiliadoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAfiliado = afiliadoService.listAfiliadosPagination(afiliado, _page, 10);
			rows = afiliadoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAfiliado;
	}
	
	/**
	 * Obtiene informacion de un afiliado.
	 * @param id.
	 * @return Afiliado.
	 */
		@RequestMapping(value = "/afiliado/{id}", method = RequestMethod.GET, produces = "application/json")
    	//@PreAuthorize("hasRole('ADMIN')")
	    public @ResponseBody  Afiliado getAfiliado(@PathVariable("id") int id) {
	        
		System.out.println("Inicio Afiliado");
	        afiliado.setAfiliadoId(id);
	        
	        Afiliado afiliado = null;
	        afiliado = afiliadoService.getAfiliado(id);
			return afiliado;
	 }


	/**
	 * Crea un nuevo afiliado.
	 * @param afiliado.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/afiliado", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Void> createAfiliado(@RequestBody Afiliado afiliado,    UriComponentsBuilder ucBuilder) {
	   
	        afiliadoService.addAfiliado(afiliado);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/afiliado/{id}").buildAndExpand(afiliado.getAfiliadoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 /**
	  * Actualiza la informacion de un afiliado.
	  * @param id.
	  * @param afiliado.
	  * @return ResponseEntity.
	  */
	 @RequestMapping(value = "/afiliado/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Afiliado> actualizarAfiliado(
				@PathVariable("id") int id, 
				@RequestBody Afiliado afiliado) {
	        
	        Afiliado afiliadoFound = afiliadoService.getAfiliado(id);
	         
	        if (afiliadoFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Afiliado>(HttpStatus.NOT_FOUND);
	        }
	 
				afiliadoFound.setGeneroId(afiliado.getGeneroId());
				afiliadoFound.setBeneficiarioId(afiliado.getBeneficiarioId());
			
				afiliadoFound.setNss(afiliado.getNss());
				afiliadoFound.setNombre(afiliado.getNombre());
				afiliadoFound.setApellido_paterno(afiliado.getApellido_paterno());
				afiliadoFound.setApellido_materno(afiliado.getApellido_materno());
				afiliadoFound.setObservaciones(afiliado.getObservaciones());
				afiliadoFound.setFecha_afiliacion(afiliado.getFecha_afiliacion());
				afiliadoFound.setFoto(afiliado.getFoto());
				afiliadoFound.setActa_nacimiento(afiliado.getActa_nacimiento());
				afiliadoFound.setCorreo(afiliado.getCorreo());
				afiliadoFound.setSemanas_cotizadas(afiliado.getSemanas_cotizadas());
				afiliadoFound.setMonto_pension(afiliado.getMonto_pension());
			
			afiliadoFound.setAfiliadoId(afiliado.getAfiliadoId());

		    afiliadoService.editAfiliado(afiliadoFound);
	        return new ResponseEntity<Afiliado>(afiliadoFound, HttpStatus.OK);
	  } 	
	
		/**
		 * Elimina un afiliado.
		 * @param id.
		 * @return ResponseEntity<Afiliado>.
		 */
		@RequestMapping(value = "/afiliado/{id}", method = RequestMethod.DELETE)
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Afiliado> deleteAfiliado(@PathVariable("id") int id) {
			 long rows = 0;	
	    	 
	         Afiliado afiliado = afiliadoService.getAfiliado(id);
	         if (afiliado == null) {
	             return new ResponseEntity<Afiliado>(HttpStatus.NOT_FOUND);
	         }
	  
             if (rows==0){
	             afiliadoService.deleteAfiliado(afiliado);
            	 return new ResponseEntity<Afiliado>(HttpStatus.OK);

             } else {
            	 return new ResponseEntity<Afiliado>(HttpStatus.PRECONDITION_FAILED);
             }

		}

	/**
	 * Salva informacion de un afiliado.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/saveAfiliado", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String saveAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {

		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.addAfiliado(afiliado);

		return "SUCCESS";
	}
	
	/**
	 * Edita informacion de un afiliado.
	 * @param afiliadoBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editAfiliado", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String editAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {


		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.editAfiliado(afiliado);
		return "SUCCESS";
	}

	/**
	 * Agrega un afiliado.
	 * @param afiliadoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchAfiliado", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
	public ModelAndView addAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Afiliado afiliado = null;
		if (afiliadoBean != null)
			afiliado = prepareModel(afiliadoBean);
		model.put("afiliados",
				prepareListofBean(afiliadoService.listAfiliados(afiliado)));
		return new ModelAndView("searchAfiliado", model);
	}

	/**
	 * Elimina un afiliado.
	 * @param afiliadoBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteAfiliado", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
	public ModelAndView deleteAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean,
			BindingResult result) {
		System.out.println("delete " + afiliadoBean.getAfiliadoId());
		afiliadoService.deleteAfiliado(prepareModel(afiliadoBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("afiliado", null);
		model.put("afiliados",
				prepareListofBean(afiliadoService.listAfiliados(null)));
		return new ModelAndView("searchAfiliado", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryAfiliado", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
	public ModelAndView entryAfiliado() {
		return new ModelAndView("redirect:/searchAfiliado");
	}

	/**
	 * Convierte un objeto de tipo AfiliadoBean a un objeto de tipo Afiliado.
	 * @param afiliadoBean.
	 * @return Afiliado.
	 */
	private Afiliado prepareModel(AfiliadoBean afiliadoBean) {
		Afiliado afiliado = new Afiliado();

		//afiliado.setGeneroId(afiliadoBean.getGeneroId());
		afiliado.setBeneficiarioId(afiliadoBean.getBeneficiarioId());
		afiliado.setNss(afiliadoBean.getNss());
		afiliado.setNombre(afiliadoBean.getNombre());
		afiliado.setApellido_paterno(afiliadoBean.getApellidoPaterno());
		afiliado.setApellido_materno(afiliadoBean.getApellidoMaterno());
		afiliado.setObservaciones(afiliadoBean.getObservaciones());
		afiliado.setFecha_afiliacion(afiliadoBean.getFechaAfiliacion());
		afiliado.setFoto(afiliadoBean.getFoto());
		afiliado.setActa_nacimiento(afiliadoBean.getActaNacimiento());
		afiliado.setCorreo(afiliadoBean.getCorreo());
		afiliado.setSemanas_cotizadas(afiliadoBean.getSemanasCotizadas());
		afiliado.setMonto_pension(afiliadoBean.getMontoPension());
		afiliado.setAfiliadoId(afiliadoBean.getAfiliadoId());
		afiliadoBean.setAfiliadoId(null);

		return afiliado;
	}

	/**
	 * Convierte lista de objetos de tipo Afiliados a lista de objetos de tipo AfiliadoBean.
	 * @param afiliados.
	 * @return List<AfiliadoBean>.
	 */
	private List<AfiliadoBean> prepareListofBean(List<Afiliado> afiliados) {
		List<AfiliadoBean> beans = null;
		if (afiliados != null && !afiliados.isEmpty()) {
			beans = new ArrayList<AfiliadoBean>();
			AfiliadoBean bean = null;
			for (Afiliado afiliado : afiliados) {
				bean = new AfiliadoBean();

				//bean.setGeneroId(afiliado.getGeneroId());
				bean.setBeneficiarioId(afiliado.getBeneficiarioId());
				bean.setNss(afiliado.getNss());
				bean.setNombre(afiliado.getNombre());
				bean.setApellidoPaterno(afiliado.getApellido_paterno());
				bean.setApellidoMaterno(afiliado.getApellido_materno());
				bean.setObservaciones(afiliado.getObservaciones());
				bean.setFechaAfiliacion(afiliado.getFecha_afiliacion());
				bean.setFoto(afiliado.getFoto());
				bean.setActaNacimiento(afiliado.getActa_nacimiento());
				bean.setCorreo(afiliado.getCorreo());
				bean.setSemanasCotizadas(afiliado.getSemanas_cotizadas());
				bean.setMontoPension(afiliado.getMonto_pension());
				bean.setAfiliadoId(afiliado.getAfiliadoId());
				beans.add(bean);
			}
		}
		return beans;
	}
	
}


