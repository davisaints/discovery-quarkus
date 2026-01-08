package org.acme;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Provider
public class AuthTokenRequestFilter implements ClientRequestFilter {

    @ConfigProperty(name = "external.api.token")
    String token;

    @Override
    public void filter(ClientRequestContext requestContext) {
        requestContext
                .getHeaders()
                .add("Authorization", "Bearer " + token);
    }
}
