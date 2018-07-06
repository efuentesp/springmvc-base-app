package com.softtek.acceleo.demo.security.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
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
	@PreAuthorize("hasRole('MANAGESEARCH')")
	public @ResponseBody  List<ConfigPermisos> getAdminPermisos(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {


		List<ConfigPermisos> listAdminPermiso = null;

		
       	listAdminPermiso = adminPermisoService.listAdminPermiso();


		response.setHeader("Access-Control-Expose-Headers", "x-total-count");

		System.out.println("Respuesta: "+ listAdminPermiso.size());
		
		return listAdminPermiso;
	}
	
	@RequestMapping(value = "/adminPermiso", method = RequestMethod.PUT, produces = "application/json")
	@PreAuthorize("hasRole('MANAGEUPDATE')")  
    public void updateAuthorityPrivilege(@RequestBody ConfigPermisos configPermisos) {
		
		// UpdateData
		adminPermisoService.updateAuthorityPrivilege(configPermisos);
		
		System.out.println("Dato Actualizado");
	}
	
	
	
}
