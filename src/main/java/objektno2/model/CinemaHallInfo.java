package objektno2.model;

import jakarta.persistence.*;

@Entity
public class CinemaHallInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_hall_info_seq")
    private Long id;

    private String address;
    private String phoneNumber;
    private int parkingSpaces;

    @OneToOne(mappedBy = "cinemaHallInfo", fetch = FetchType.LAZY)
    private CinemaHall cinemaHall;

    public CinemaHallInfo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public int getParkingSpaces() { return parkingSpaces; }
    public void setParkingSpaces(int parkingSpaces) { this.parkingSpaces = parkingSpaces; }
    public CinemaHall getCinemaHall() { return cinemaHall; }
    public void setCinemaHall(CinemaHall cinemaHall) { this.cinemaHall = cinemaHall; }
}