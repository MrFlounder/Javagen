package com.server;

import org.json.JSONObject;

import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/")
public class server {
    @PUT
    @Path("OrderFood")
    @Produces(MediaType.TEXT_PLAIN)
    public Response orderFood(String jsonString) {
        JSONObject jsonRequestObj = new JSONObject(jsonString);
        if (jsonRequestObj.get("amount") instanceof Integer && jsonRequestObj.get("food") instanceof String) {
            return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE).build();
        }
    }
    @POST
    @Path("RateFood")
    @Produces(MediaType.TEXT_PLAIN)
    public Response rateFood(String jsonString) {
        JSONObject jsonRequestObj = new JSONObject(jsonString);
        if (jsonRequestObj.get("rating") instanceof Integer && jsonRequestObj.get("food") instanceof String) {
            return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE).build();
        }
    }
    @GET
    @Path("getmethod")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getmethod(@QueryParam("food") String food, @QueryParam("amount") Integer amount) {
        return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();
    }
}