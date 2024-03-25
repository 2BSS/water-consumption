package ee.adrian.backend.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "measurements")
public class NewMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(precision = 13, scale = 3)
    private BigDecimal kitchenHot;
    @Column(precision = 13, scale = 3)
    private BigDecimal kitchenCold;
    @Column(precision = 13, scale = 3)
    private BigDecimal bathroomHot;
    @Column(precision = 13, scale = 3)
    private BigDecimal bathroomCold;

    // Constructors, getters, and setters

    public NewMeasurement() {

    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getKitchenHot() {
        return kitchenHot;
    }

    public BigDecimal getKitchenCold() {
        return kitchenCold;
    }

    public BigDecimal getBathroomHot() {
        return bathroomHot;
    }

    public BigDecimal getBathroomCold() {
        return bathroomCold;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setKitchenHot(BigDecimal kitchenHot) {
        this.kitchenHot = kitchenHot;
    }

    public void setKitchenCold(BigDecimal kitchenCold) {
        this.kitchenCold = kitchenCold;
    }

    public void setBathroomHot(BigDecimal bathroomHot) {
        this.bathroomHot = bathroomHot;
    }

    public void setBathroomCold(BigDecimal bathroomCold) {
        this.bathroomCold = bathroomCold;
    }
}
