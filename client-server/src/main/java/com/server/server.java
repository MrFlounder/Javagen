package com.server; /**
 * Created by kzang on 2017/8/30.
 */

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/")
public class server {
    @POST
    @Path("OrderFood")
    @Produces(MediaType.TEXT_PLAIN)
    public Response orderFood(String jsonString) {
        Response.Status status = null;
        JSONObject obj = new JSONObject(jsonString);

        System.out.println(jsonString);
        status = Response.Status.ACCEPTED;
        return Response.status(status).type(MediaType.TEXT_HTML_TYPE).build();
    }
    @POST
    @Path("RateFood")
    @Produces(MediaType.TEXT_PLAIN)
    public Response rateFood(String jsonString) {
        Response.Status status = null;
        JSONObject obj = new JSONObject(jsonString);

        System.out.println(jsonString);
        status = Response.Status.ACCEPTED;
        return Response.status(status).type(MediaType.TEXT_HTML_TYPE).build();
    }
}