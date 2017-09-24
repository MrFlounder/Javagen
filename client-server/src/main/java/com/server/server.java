package com.server;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class server {
    
        
        @POST
        @Path("OrderFood")
        @Produces(MediaType.TEXT_PLAIN)
        public Response OrderFoodPOST(String jsonString) {
            JSONObject jsonRequestObj = new JSONObject(jsonString);
            if (jsonRequestObj.get("amount") instanceof Integer && 
            jsonRequestObj.get("food") instanceof String
            ) {
                return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();

            } else {
                return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE).build();
            }
        }
        
    
        
        @POST
        @Path("RateFood")
        @Produces(MediaType.TEXT_PLAIN)
        public Response RateFoodPOST(String jsonString) {
            JSONObject jsonRequestObj = new JSONObject(jsonString);
            if (jsonRequestObj.get("rating") instanceof Integer && 
            jsonRequestObj.get("food") instanceof String
            ) {
                return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();

            } else {
                return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_HTML_TYPE).build();
            }
        }
        
    
        
        @GET
        @Path("newEndPoint")
        @Produces(MediaType.TEXT_PLAIN)
        public Response newEndPointGET(@QueryParam("somethingelse") String somethingelse ,@QueryParam("rating") Integer rating ,@QueryParam("food") String food) {
            return Response.status(Response.Status.ACCEPTED).type(MediaType.TEXT_HTML_TYPE).build();
        }
        
    
}