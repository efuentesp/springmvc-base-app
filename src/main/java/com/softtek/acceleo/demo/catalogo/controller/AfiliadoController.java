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

import com.softtek.acceleo.demo.catalogo.bean.AfiliadoBean;
import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.service.AfiliadoService;

@Controller
public class AfiliadoController {

	@Autowired
	private AfiliadoService afiliadoService;
	
	Afiliado afiliado = new Afiliado();

	@RequestMapping(value = "/afiliado", method = RequestMethod.GET, produces = "application/json")
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
	
	@RequestMapping(value = "/afiliado/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Afiliado getAfiliado(@PathVariable("id") int id) {
	        
	        afiliado.setAfiliadoId(id);
	        
	        Afiliado afiliado = null;
	        afiliado = afiliadoService.getAfiliado(id);
			return afiliado;
	 }



	 @RequestMapping(value = "/afiliado", method = RequestMethod.POST)
	    public ResponseEntity<Void> createAfiliado(@RequestBody Afiliado afiliado,    UriComponentsBuilder ucBuilder) {
	   
	        afiliadoService.addAfiliado(afiliado);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/afiliado/{id}").buildAndExpand(afiliado.getAfiliadoId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/afiliado/{id}", method = RequestMethod.PUT)
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
	
		
		@RequestMapping(value = "/afiliado/{id}", method = RequestMethod.DELETE)
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


	@RequestMapping(value = "/saveAfiliado", method = RequestMethod.POST)
	public @ResponseBody String saveAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {

		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.addAfiliado(afiliado);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editAfiliado", method = RequestMethod.POST)
	public @ResponseBody String editAfiliado(
			@ModelAttribute("command") AfiliadoBean afiliadoBean) {


		Afiliado afiliado = prepareModel(afiliadoBean);
		afiliadoService.editAfiliado(afiliado);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchAfiliado", method = RequestMethod.GET)
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

	@RequestMapping(value = "/deleteAfiliado", method = RequestMethod.POST)
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

	@RequestMapping(value = "/entryAfiliado", method = RequestMethod.GET)
	public ModelAndView entryAfiliado() {
		return new ModelAndView("redirect:/searchAfiliado");
	}

	private Afiliado prepareModel(AfiliadoBean afiliadoBean) {
		Afiliado afiliado = new Afiliado();

		//afiliado.setGeneroId(afiliadoBean.getGeneroId());
		afiliado.setBeneficiarioId(afiliadoBean.getBeneficiarioId());
		afiliado.setNss(afiliadoBean.getNss());
		afiliado.setNombre(afiliadoBean.getNombre());
		afiliado.setApellido_paterno(afiliadoBean.getApellido_paterno());
		afiliado.setApellido_materno(afiliadoBean.getApellido_materno());
		afiliado.setObservaciones(afiliadoBean.getObservaciones());
		afiliado.setFecha_afiliacion(afiliadoBean.getFecha_afiliacion());
		afiliado.setFoto(afiliadoBean.getFoto());
		afiliado.setActa_nacimiento(afiliadoBean.getActa_nacimiento());
		afiliado.setCorreo(afiliadoBean.getCorreo());
		afiliado.setSemanas_cotizadas(afiliadoBean.getSemanas_cotizadas());
		afiliado.setMonto_pension(afiliadoBean.getMonto_pension());
		afiliado.setAfiliadoId(afiliadoBean.getAfiliadoId());
		afiliadoBean.setAfiliadoId(null);

		return afiliado;
	}

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
				bean.setApellido_paterno(afiliado.getApellido_paterno());
				bean.setApellido_materno(afiliado.getApellido_materno());
				bean.setObservaciones(afiliado.getObservaciones());
				bean.setFecha_afiliacion(afiliado.getFecha_afiliacion());
				bean.setFoto(afiliado.getFoto());
				bean.setActa_nacimiento(afiliado.getActa_nacimiento());
				bean.setCorreo(afiliado.getCorreo());
				bean.setSemanas_cotizadas(afiliado.getSemanas_cotizadas());
				bean.setMonto_pension(afiliado.getMonto_pension());
				bean.setAfiliadoId(afiliado.getAfiliadoId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


