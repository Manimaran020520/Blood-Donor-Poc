package com.app.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name="donorsList")

public class Donors {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int donor_id;
	@ManyToOne
	private Login login;
	public String name;
	public String mobile_number;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bloodgroup_id")
	private Bloodgroup bloodGroup;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public String availability;
	public boolean acknowledgement;



}
