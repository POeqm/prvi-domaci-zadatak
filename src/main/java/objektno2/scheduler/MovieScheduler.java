package objektno2.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import objektno2.service.MovieService;

@ApplicationScoped
public class MovieScheduler {

    @Inject
    MovieService movieService;

    @Scheduled(every = "30s")
    public void printMovieCount() {
        int count = movieService.getAllMovies().size();
        System.out.println("Trenutni broj filmova u bazi: " + count);
    }
}