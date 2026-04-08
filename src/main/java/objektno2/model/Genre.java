package objektno2.model;

import  jakarta.persistence.*;

import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private List<Movie> movies;

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
