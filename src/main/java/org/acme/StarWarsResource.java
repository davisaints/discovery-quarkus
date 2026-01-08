package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("starwars")
public class StarWarsResource {

    @RestClient
    StarWarsService service;

    @GET
    @Path("people")
    public String getStarWarsPeople() {
        return service.getPeople();
    }
}
