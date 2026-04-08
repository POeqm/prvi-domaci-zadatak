package objektno2.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import objektno2.model.*;
import objektno2.model.Ticket;
import java.util.List;


@Dependent
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

}
