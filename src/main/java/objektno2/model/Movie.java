package objektno2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = Movie.GET_ALL_MOVIES, query = "SELECT m FROM Movie m")
@NamedQuery(name = Movie.GET_MOVIE_BY_TITLE, query = "SELECT m FROM Movie m WHERE m.title = :title")

public class Movie {
    public static final String GET_ALL_MOVIES = "Movie.getAll";
    public static final String GET_MOVIE_BY_TITLE = "Movie.getByTitle";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    private Long id;
    private String title;
    private int durationInMinutes;
    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
    @OneToMany(mappedBy = "movie")
    private List<Projection> projections;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_details_id")
    private MovieDetails movieDetails;



    public Movie(Long id, String title, int durationInMinutes, Director director){
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.director = director;
    }

    public Movie() {

    }

    public MovieDetails getMovieDetails() { return movieDetails; }
    public void setMovieDetails(MovieDetails movieDetails) { this.movieDetails = movieDetails; }

    public void setId(Long id){
       this.id = id;
   }

    public Long getId() {
       return id;
    }

    public String getTitle() {
       return title;
    }

    public void setTitle(String title) {
       this.title = title;
    }

    public int getDurationInMinutes() {
       return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<Actor> getActors() {
       return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
       return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", actors=" + actors +
                ", director=" + director +
                ", genres=" + genres +
                ", projections=" + projections +
                '}';
    }

}
