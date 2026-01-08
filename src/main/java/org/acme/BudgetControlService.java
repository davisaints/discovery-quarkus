package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/")
@RegisterProvider(AuthTokenRequestFilter.class)
public interface BudgetControlService {

    @GET
    @Path("/revenue")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRevenues();
}
