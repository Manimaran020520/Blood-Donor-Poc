package com.example.BloodDonor.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int donorid;
    @ManyToOne
    private Login login;
    private String fullname;
    @Column(name="mobile_number",unique = true)
    private long mobileNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bloodid", referencedColumnName = "bloodid")
    private BloodGroup bloodGroup;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    private Address address;
    private boolean availability;
    private boolean acknowledgement;



}
