package objektno2.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import objektno2.model.Movie;
import objektno2.service.MovieService;
import java.util.List;

@Path("/movie")
public class MovieResource {

    @Inject
    private MovieService movieService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    public String addMovie(Movie movie) {
        movieService.createMovie(movie);
        return "Movie added successfully";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateMovie")
    public String updateMovie(Movie movie) {
        movieService.updateMovie(movie);
        return "Movie updated successfully";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllMovies")
    public Response getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return Response.ok().entity(movies).build();
    }
}
