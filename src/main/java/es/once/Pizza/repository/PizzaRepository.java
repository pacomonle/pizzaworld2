package es.once.Pizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.once.Pizza.model.Ingrediente;
import es.once.Pizza.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

   
}