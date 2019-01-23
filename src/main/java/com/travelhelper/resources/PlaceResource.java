package com.travelhelper.resources;

import com.travelhelper.repositories.PlaceDataRepository;
import com.travelhelper.model.Place;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/places")
public class PlaceResource {

    @Autowired
    private PlaceDataRepository placeDataRepository;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Place> getAllPlaces() {
        return placeDataRepository.getAllPlaces();
    }

    @GET
    @Path("/{name}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Place getPlace(@PathParam("name") String name) {
        return placeDataRepository.getPlace(name);
    }

    @PUT
    @Path("/update")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updatePlace(Place place) {
        placeDataRepository.updatePlace(place.getId(), place.getName());
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("/{name}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deletePlace(@PathParam("name") String name) {
        placeDataRepository.deletePlace(name);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addPlace(Place place, @Context UriInfo uriInfo) {
        placeDataRepository.addPlace(place);
        return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), place.getId())).build();
    }
}
