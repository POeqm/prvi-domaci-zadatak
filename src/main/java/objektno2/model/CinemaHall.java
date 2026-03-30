package objektno2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = CinemaHall.GET_ALL_CINEMAHALLS, query = "SELECT ch FROM CinemaHall ch"),
        @NamedQuery(name = CinemaHall.GET_CINEMAHALL_BY_NAME, query = "SELECT ch FROM CinemaHall ch WHERE ch.name = :name")
})

public class CinemaHall {

   public static final String GET_ALL_CINEMAHALLS = "CinemaHall.getAllCinemaHalls" ;
   public static final String GET_CINEMAHALL_BY_NAME= "CinemaHall.getAllCinemaHallByName" ;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_hall_seq")
    private Long id;
    private String name;
    private int noOfSeats;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_hall_info_id")
    private CinemaHallInfo cinemaHallInfo;
    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.LAZY)
    private Set<Projection>projections;

    public CinemaHall(Long id, String name, int noOfSeats) {
        this.id = id;
        this.name = name;
        this.noOfSeats = noOfSeats;
    }

    public CinemaHall() {

    }
    public CinemaHallInfo getCinemaHallInfo() { return cinemaHallInfo; }
    public void setCinemaHallInfo(CinemaHallInfo cinemaHallInfo) { this.cinemaHallInfo = cinemaHallInfo; }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setProjections(Set<Projection> projections) {
        this.projections = projections;
    }

    public String getName() {
        return name;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public Set<Projection> getProjections() {
        return projections;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CinemaHall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", noOfSeats=" + noOfSeats +
                ", projections=" + projections +
                '}';
    }
}
