package com.example.jparelational.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Age cannot be null")
    @Column(columnDefinition = "int")
    private Integer age;

    @Email(message = "Email should be valid")
    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    @NotNull(message = "Salary cannot be null")
    @Column(columnDefinition = "double")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
