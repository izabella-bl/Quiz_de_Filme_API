package com.quiz.filme.repository;

import com.quiz.filme.model.Filme;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmeRepository extends PagingAndSortingRepository<Filme,Integer> {

    @Override
    default Iterable<Filme> findAll() {
        
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
    

