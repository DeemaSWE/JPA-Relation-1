package com.example.jparelational.Repository;

import com.example.jparelational.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

    Address findAddressById(Integer id);

}
