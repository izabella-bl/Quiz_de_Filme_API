package com.quiz.filme.API;

import java.util.List;

import com.quiz.filme.model.Jogador;
import com.quiz.filme.repository.JogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz/jogador")
public class JogadorApi {


    @Autowired
    private JogadorRepository repository;

    @GetMapping
    public List<Jogador> jogadores ( ){
       return (List<Jogador>)repository.findAll();     
    }

    @GetMapping("/{id}")  
    public Jogador buscarPorId(@PathVariable int id){
        return repository.findById(id).get();        
    }

    @PostMapping  
    public String salvar(@RequestBody Jogador model){
        repository.save(model);
        return "salvo com sucesso";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/{id}")    
    public String update(@RequestBody Jogador model, @PathVariable int id){
        if(model.getId() == id){
            repository.save(model);
            return "alterado com sucesso";
        }
        return "id da url diferente do body";
    }

}
