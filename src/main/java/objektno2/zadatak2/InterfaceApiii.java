package objektno2.zadatak2;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://official-joke-api.appspot.com")
public interface InterfaceApiii {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/random_joke")
    ResponseApi jokeResponse();
}
