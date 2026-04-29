package objektno2.zadatak2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import objektno2.model.Director;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    private Long id;
    private int score;
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Director director;

    public Rating(Long id, int score, String description) {
        this.id = id;
        this.score = score;
        this.description = description;
    }

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
