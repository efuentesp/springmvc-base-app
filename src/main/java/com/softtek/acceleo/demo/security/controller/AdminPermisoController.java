package com.softtek.acceleo.demo.security.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.service.AdminPermisoService;



@RestController
public class AdminPermisoController {

	@Autowired
	private AdminPermisoService adminPermisoService;
	
	AdminPermiso adminPermiso = new AdminPermiso();
	
	/**
	 * Obtiene informacion de los afilliados.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<AdminPermiso>.
	 */
	@RequestMapping(value = "/adminPermiso", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody  List<AdminPermiso> getAdminPermisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<AdminPermiso> listAdminPermiso = null;

		if (query==null && _page == 0) {
       		listAdminPermiso = adminPermisoService.listAdminPermiso();
			//rows = adminPermisoService.getTotalRows();
		} else if (query!= null){
			listAdminPermiso = adminPermisoService.listAdminPermiso();
			//rows = adminPermisoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAdminPermiso = adminPermisoService.listAdminPermiso();
			//rows = adminPermisoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAdminPermiso;
	}
	
}
