package objektno2.kolokvijum;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import objektno2.kolokvijum.CurencyResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.euroratesapi.dev")
public interface CurrencyApi {

    @GET
    @Path("/api/rates")
    @Produces(MediaType.APPLICATION_JSON)
    CurencyResponse getRates(@QueryParam("from") String from,
                             @QueryParam("to") String to);
}