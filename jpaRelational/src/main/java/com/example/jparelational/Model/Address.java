package com.example.jparelational.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Area cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "Street cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotNull(message = "Building Number cannot be empty")
    @Column(columnDefinition = "int")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
