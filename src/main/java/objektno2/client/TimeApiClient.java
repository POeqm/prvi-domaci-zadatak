package objektno2.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://timeapi.io")
public interface TimeApiClient {

    @GET
    @Path("/api/time/current/ip")
    @Produces(MediaType.APPLICATION_JSON)
    TimezoneResponse getTimezoneByIp(@QueryParam("ipAddress") String ipAddress);
}