package objektno2.resources;


import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import objektno2.model.Movie;
import objektno2.model.Ticket;
import objektno2.service.MovieService;
import java.util.List;
import objektno2.model.MovieDetails;
import objektno2.model.CinemaHallInfo;
import objektno2.model.CinemaHall;

@Path("/movie")
public class MovieResource {

    @Inject
    private MovieService movieService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovie")
    @RolesAllowed("admin")
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

    @GET
    @Path("/getMovieById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return Response.ok().entity(movie).build();
    }

    @GET
    @Path("/getMovieByTitle")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieByTitle(@QueryParam("title") String title) {
        List<Movie> movies = movieService.getMovieByTitle(title);
        return Response.ok().entity(movies).build();
    }

    @GET
    @Path("/getTicketsByProjectionId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicketsByProjectionId(@QueryParam("id") Long id) {
        List<Ticket> tickets = movieService.getTicketsByProjectionId(id);
        return Response.ok().entity(tickets).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMovieDetails")
    public String addMovieDetails(MovieDetails movieDetails) {
        movieService.addMovieDetails(movieDetails);
        return "Movie details added successfully";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCinemaHallInfo/{cinemaHallId}")
    public String addCinemaHallInfo(@PathParam("cinemaHallId") Long cinemaHallId, CinemaHallInfo cinemaHallInfo) {
        movieService.addCinemaHallInfo(cinemaHallId, cinemaHallInfo);
        return "Cinema hall info added successfully";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCinemaHall")
    public String addCinemaHall(CinemaHall cinemaHall) {
        movieService.addCinemaHall(cinemaHall);
        return "Cinema hall added successfully";
    }


}
