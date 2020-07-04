package com.example.rest.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.UsuarioModel;
import com.example.rest.entidad.Usuario;
import com.example.rest.servicio.ServicioRest;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);

	private UsuarioModel daoUsuario = new UsuarioModel();

	// Crud de Tipo Reclamo
	@GET
	@Path("/usuario")
	public Response listarUsuarios() {
		log.info("listar Usuario rest ");
		return Response.ok(daoUsuario.listarUsuarios()).build();
	}

	@POST
	@Path("/usuario")
	public Response registraUsuario(Usuario obj) {
		log.info("Registra Usuario " + obj.getIdusuario());
		if (daoUsuario.insertaUsuario(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/usuario")
	public Response atualizaUsuario(Usuario obj) {
		log.info("Actualiza Usuario " + obj.getIdusuario());
		if (daoUsuario.actualizaUsuario(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/usuario/{idusuario}")
	public Response eliminaUsuario(@PathParam("idusuario") int id) {
		log.info("Elimina Usuario " + id);
		if (daoUsuario.eliminaUsuario(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}
