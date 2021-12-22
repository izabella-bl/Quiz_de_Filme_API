package com.filme.quiz.quiz.repository;

import java.util.Optional;

import com.filme.quiz.quiz.model.Jogador;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JogadorRepository extends PagingAndSortingRepository<Jogador,Long> {
    
    @Override
    default Iterable<Jogador> findAll() {
        return findAll(Sort.by(Sort.Direction.DESC, "pontos"));
    }

    Optional<Jogador> findById(int id);

    void deleteById(int id);

    
}
