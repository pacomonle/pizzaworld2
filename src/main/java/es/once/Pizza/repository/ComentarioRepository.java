package es.once.Pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.once.Pizza.model.Comentario;


@Repository
interface ComentarioRepository extends JpaRepository<Comentario, Long>{

    
}