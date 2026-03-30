package objektno2.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = Ticket.GET_ALL_TICKETS_FOR_PROJECTION,
        query = "SELECT t FROM Ticket t WHERE t.projection.id = :id")
public class Ticket {
    public static final String GET_ALL_TICKETS_FOR_PROJECTION = "GetAllTicketsForProjection";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projection_id")
    private Projection projection;

    private String seatNumber;
    private double price;

    public Ticket() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Projection getProjection() { return projection; }
    public void setProjection(Projection projection) { this.projection = projection; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}