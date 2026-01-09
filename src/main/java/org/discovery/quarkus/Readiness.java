package org.discovery.quarkus;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static org.discovery.quarkus.StarWarsService.FALLBACK_MESSAGE;

@org.eclipse.microprofile.health.Readiness
public class Readiness implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;

    @Override
    public HealthCheckResponse call() {
        if (starWarsService.getPeople().contains(FALLBACK_MESSAGE)) {
            return HealthCheckResponse.down("ERROR");
        }

        return HealthCheckResponse.up("OK");
    }
}
