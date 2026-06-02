package objektno2.service;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import objektno2.client.*;
import objektno2.kolokvijum.CurencyResponse;
import objektno2.kolokvijum.CurrencyApi;
import objektno2.model.*;
import objektno2.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieService {
    @Inject
    private EntityManager em;

    @Transactional
    public Movie createMovie(Movie movie){
        return em.merge(movie);
    }

    @Transactional
    public Movie updateMovie(Movie movie){
        return em.merge(movie);
    }

    @Transactional
    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return em.merge(cinemaHall);
    }

    public List<Movie> getAllMovies(){
        return em.createNamedQuery(Movie.GET_ALL_MOVIES, Movie.class).getResultList();
    }

    public Movie getMovieById(Long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> getMovieByTitle(String title) {
        return em.createNamedQuery(Movie.GET_MOVIE_BY_TITLE, Movie.class)
                .setParameter("title", title)
                .getResultList();
    }

    public List<Ticket> getTicketsByProjectionId(Long id) {
        return em.createNamedQuery(Ticket.GET_ALL_TICKETS_FOR_PROJECTION, Ticket.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    public MovieDetails addMovieDetails(MovieDetails movieDetails) {
        return em.merge(movieDetails);
    }

    @Transactional
    public CinemaHallInfo addCinemaHallInfo(Long cinemaHallId, CinemaHallInfo cinemaHallInfo) {
        CinemaHallInfo saved = em.merge(cinemaHallInfo);
        CinemaHall cinemaHall = em.find(CinemaHall.class, cinemaHallId);
        cinemaHall.setCinemaHallInfo(saved);
        em.merge(cinemaHall);
        return saved;
    }

    @Transactional
    public Actor addActor(Actor actor) {
        return em.merge(actor);
    }

    @Inject
    @RestClient
    IpifyClient ipifyClient;

    @Inject
    @RestClient
    TimeApiClient timeApiClient;

    @Transactional
    public TimezoneResponse getTimezoneByActorId(Long actorId) {
        Actor actor = em.find(Actor.class, actorId);
        if (actor == null) {
            throw new jakarta.ws.rs.NotFoundException("Actor with id " + actorId + " not found");
        }

        IpifyResponse ipifyResponse = ipifyClient.getMyIp();
        TimezoneResponse timezoneResponse = timeApiClient.getTimezoneByIp(ipifyResponse.getIp());

        actor.setTimeZone(timezoneResponse.getTimeZone());
        em.merge(actor);

        return timezoneResponse;
    }


    @RestClient
    CurrencyApi  currencyApi;

    @Transactional
    public CurencyResponse currencyConversion(String from, String to, double value, Long userId) {
        Actor actor = em.find(Actor.class, userId);
        if (actor == null) {
            throw new jakarta.ws.rs.NotFoundException("User with id " + userId + " not found.");
        }

        CurencyResponse response = currencyApi.getRates(from, to);
        response.setValue(value);
        response.setConvertedValue(value * response.getRate());

        return response;
    }

    @Transactional
    public Movie uploadFileForMovie(Long movieId, String fileName, InputStream fileStream) {
        Movie movie = em.find(Movie.class, movieId);
        if (movie == null) {
            throw new jakarta.ws.rs.NotFoundException("Movie with id " + movieId + " not found.");
        }

        String uploadDir = "C:/uploads/";
        String filePath = uploadDir + fileName;
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                new File(uploadDir).mkdirs();
                Files.copy(fileStream, file.toPath());
            } catch (IOException e) {
                throw new RuntimeException("Error saving file: " + e.getMessage());
            }
        }

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFilename(filePath);
        em.merge(uploadedFile);

        if (movie.getUploadedFiles() == null) {
            movie.setUploadedFiles(new ArrayList<>());
        }
        movie.getUploadedFiles().add(uploadedFile);
        return em.merge(movie);
    }

    public Movie getMovieWithFiles(Long movieId) {
        Movie movie = em.find(Movie.class, movieId);
        if (movie == null) {
            throw new jakarta.ws.rs.NotFoundException("Movie with id " + movieId + " not found.");
        }

        if (movie.getUploadedFiles() != null) {
            for (UploadedFile uploadedFile : movie.getUploadedFiles()) {
                if (uploadedFile.getFilename() != null) {
                    uploadedFile.setFile(new File(uploadedFile.getFilename()));
                }
            }
        }

        return movie;
    }

}
