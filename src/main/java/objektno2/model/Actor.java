package objektno2.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "actor_seq")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    public Actor(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Actor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
