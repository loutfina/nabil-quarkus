package com.its4u.rest.client;

import io.smallrye.common.annotation.Blocking;

import java.time.Instant;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
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
import java.util.List;
import java.util.TimeZone;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;

import org.jboss.logging.Logger;

@Path("/messsage")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class MessageResource {
	
	private static final Logger LOGGER = Logger.getLogger(MessageResource.class.getName());

    @GET
    @Path("/since/{lastTimestamp}")
    public Uni<List<Message>> getMessagesSince(@PathParam("lastTimestamp") Long lastTimestamp){   //Uni is an asynchronous type
		LocalDateTime lastDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastTimestamp),TimeZone.getDefault().toZoneId());
        LOGGER.debug("Call messagesService.getMessagesSince since "+lastDate.toString()); 
        return Message.list("creationDate >= :lastDate", Parameters.with("lastDate", lastDate));
    }

    @GET
    @Path("/user/{userName}")
	@Blocking                                         // <-- see this annotation to block as we are in reactive mode
    public Uni<List<Message>> getByUser(String userName){   // synchronous call need @blocking implementation
        LOGGER.debug("Call messagesService.getByUser with name "+userName);
		return Message.list("user.name", Sort.by("creationDate"), userName);
    }  
	
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(Message message) {      //Uni is an asynchronous type
        if (message == null || message.id != null || message.user == null) {
            throw new WebApplicationException("Try to push an invalid message", 422);
        }
        message.creationDate = LocalDateTime.now();
        return Panache.withTransaction(message::persist).replaceWith(Response.ok(message).status(Status.CREATED)::build);
    }
	
	// Web could add PUT to update a message or DELETE to remove a message
	
}
