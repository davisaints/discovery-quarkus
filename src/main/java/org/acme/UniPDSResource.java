package org.acme;

import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/uni-pds")
public class UniPDSResource {

    private JsonObject createJsonObject() {
        JsonObject jsonObject = new io.vertx.core.json.JsonObject();
        jsonObject.put("name", "John Doe");

        return jsonObject;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJsonObject() {
        return createJsonObject();
    }
}
