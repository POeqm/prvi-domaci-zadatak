package objektno2.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = Projection.GET_PROJECTIONS_FOR_CINEMAHALL, query = "SELECT p FROM Projection p WHERE p.cinemaHall.id = :id")

public class Projection {
    public static final String GET_PROJECTIONS_FOR_CINEMAHALL = "Projection.getProjectionForCinemaHall";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projection_seq")
    private Long id;
    private String date;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    public Projection(Long id, String date, Movie movie, CinemaHall cinemaHall) {
        this.id = id;
        this.date = date;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    public Projection() {

    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", movie=" + movie +
                ", cinemaHall=" + cinemaHall +
                '}';
    }
}
