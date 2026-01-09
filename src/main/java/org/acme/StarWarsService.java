package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsService {

    @CircuitBreaker(
        delay = 3000L,
        failureRatio = 0.5,
        requestVolumeThreshold = 2,
        successThreshold = 2
    )
    @Fallback(
            fallbackMethod = "getPeopleFallback"
    )
    @GET
    @Path("people")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3000L)
    String getPeople();
    default String getPeopleFallback() {
        return "Fallback";
    }
}