package com.quiz.filme.repository;

import com.quiz.filme.model.Questoes;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuestoesRepository extends PagingAndSortingRepository<Questoes,Integer> {

    @Override
    default Iterable<Questoes> findAll() {
        
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
    

