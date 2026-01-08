package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("budget-control")
public class BudgetControlResource {
    @RestClient
    BudgetControlService service;

    @GET
    @Path("/revenue")
    public String getExpenses() {
        return service.getRevenues();
    }
}
