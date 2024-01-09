package com.app.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bloodgroup")
public class Bloodgroup {
	@Id


	public int bloodgroup_id;

	public String bloodgroup;

	public Bloodgroup(String s) {
	}
}
