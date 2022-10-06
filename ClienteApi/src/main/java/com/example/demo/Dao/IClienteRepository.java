package com.example.demo.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
