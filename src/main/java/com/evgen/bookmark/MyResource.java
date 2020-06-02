package com.evgen.bookmark;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daoImpl.Dao;
import entities.Message;

@Path("todo")
public class MyResource {


	Dao d = new Dao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return d.getMessagesList();
	}

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") int id) {

		return d.getMessageById(id);
	}

	@POST
	@Path("add")
//	@Produces(MediaType.APPLICATION_JSON)
	public Message createMessage(Message m) {

		d.createMessage(m);
		return m;
	}

	@DELETE
	@Path("delete/{id}")
	public Response deleteMessageById(@PathParam("id") int id) {
		d.deleteMessageById(id);
		return Response.status(200).entity("Id " + id + " Deleted").build();

	}

}