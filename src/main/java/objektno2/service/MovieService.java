package objektno2.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import objektno2.model.*;

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

    public List<Movie> getAllMovies(){
        return em.createNamedQuery(Movie.GET_ALL_MOVIES, Movie.class).getResultList();
    }

}
