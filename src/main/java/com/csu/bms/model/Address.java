package com.csu.bms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class Address {
  private String country;

  private String city;

  @Column(name = "postal_code")
  private String postalCode;

  private String street;

  @Column(name = "house_no")
  private String houseNo;

  @Column(name = "flat_no")
  private String flatNo;
}
