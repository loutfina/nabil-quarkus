package com.its4u.rest.client;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import org.jboss.logging.Logger;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UserResource {
	
	private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @GET
    @Path("/{name}")
    public Uni<User> getUserByName(@PathParam("name") String name){   //Uni is an asynchronous type
        LOGGER.debug("Call UserResource.getUserByName  "+name); 
        return User.find("name",formatName(name)).firstResult();
    }

	
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(User user) {      //Uni is an asynchronous type
        if (user == null ) {
            throw new WebApplicationException("Try to push an invalid user", 422);
        }
        // format name and remove any ID to create a new user (I don't check if it already exists)
        String name = formatName(user.name); 
        User newUser = new User(name);  
        return Panache.withTransaction(newUser::persist).replaceWith(Response.ok(newUser).status(Status.CREATED)::build);
    }

    private String formatName(String name){
        if (name !=null){
            return (name.length()>1) ? Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase() : name.toUpperCase();
        }
        return null;
    }
	
	// Web could add PUT to update a message or DELETE to remove a message
	
}
