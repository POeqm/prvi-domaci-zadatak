package objektno2.kolokvijum;

import jakarta.persistence.OneToMany;
import objektno2.model.Actor;

public class CurencyResponse {
    private String from;
    private String to;
    private double rate;
    private double value;
    private double convertedValue;

    public CurencyResponse() {}

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public double getConvertedValue() { return convertedValue; }
    public void setConvertedValue(double convertedValue) { this.convertedValue = convertedValue; }
}
