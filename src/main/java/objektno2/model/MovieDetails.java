package objektno2.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class MovieDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_details_seq")
    private Long id;

    private String description;
    private double rating;
    private String trailerUrl;
    private String language;
    @JsonIgnore
    @OneToOne(mappedBy = "movieDetails", fetch = FetchType.LAZY)
    private Movie movie;
   

    public MovieDetails() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getTrailerUrl() { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
}