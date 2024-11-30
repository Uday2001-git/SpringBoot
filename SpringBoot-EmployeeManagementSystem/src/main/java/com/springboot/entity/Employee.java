package com.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(max=50)
	@Column(length=45)
	private String name;
	
	@NotEmpty
	@Size(max=50)
	@Column(length = 50)
	private String address;
	
	@Email
	@NotEmpty
	@Size(max=70)
	@Column(length = 100)
	private String email;
	
	@Positive
	@NotNull
	private Long phoNumber;
	
	@Positive
	@Max(100000)
	@Min(8000)
	@NotNull
	private Double salary;
}
