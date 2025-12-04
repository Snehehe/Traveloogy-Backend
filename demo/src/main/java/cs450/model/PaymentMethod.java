package cs450.model;

import jakarta.persistence.*;

@Entity
public class PaymentMethod {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    public String cardholderName;
    public String maskedCardNumber;
    public String expiryMonth;
    public String expiryYear;

    @ManyToOne
public User user;

}
