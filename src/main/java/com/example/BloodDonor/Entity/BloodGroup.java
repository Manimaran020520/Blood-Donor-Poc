package com.example.BloodDonor.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="blood_group")
public class BloodGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bloodid;
    private String bloodgroup;
}
