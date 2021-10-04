package com.simpleapi.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.simpleapi.bussiness.SearchRN;
import com.simpleapi.errors.ErrorMessage;

@Path("/count")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Services {
	
	@XmlRootElement
	public static class Consulta {
	    @XmlElement public String cpf;
	    @XmlElement public Integer idProcesso;
	    @XmlElement public String token;
	}
	
	@Inject
	SearchRN searchRN;
	
	private List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
	
	@GET
	@Path("name/{name}")
	public Response countByName(@PathParam("name") String name) {
		
		Long count;
		
		name = name.trim().toUpperCase();
	
		errors.addAll(searchRN.validateName(name));
		
		if (!errors.isEmpty()) {
			return Response.status(Status.BAD_REQUEST)
					.entity(errors)
					.build();//400
		}

		try {			
			count = searchRN.countPeopleByName(name);
			return Response.ok(count, MediaType.APPLICATION_JSON).build();//200
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("an error occured").build();//500
		}

	}
	
	
	// http://localhost:8080/QueueAPI/api/count/name/{name}

}
