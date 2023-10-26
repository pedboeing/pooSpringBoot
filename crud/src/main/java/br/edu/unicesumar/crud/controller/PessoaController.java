package br.edu.unicesumar.crud.controller;
import br.edu.unicesumar.crud.model.domain.Pessoa;
import br.edu.unicesumar.crud.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    //Lista todas as pessoas -> GET
    @GetMapping
    public List<Pessoa> all(){
        return pessoaRepository.findAll();
    }

    //Lista pessoa por ID -> GET
    @GetMapping("/{id}")
    public Pessoa getById(@PathVariable Long id){
        return pessoaRepository.findById(id).orElse(null);
    }

    //Cria pessoa -> POST
    @PostMapping
    public Pessoa create(@RequestBody Pessoa nova){
        return pessoaRepository.save(nova);
    }

    //Editar pessoa por ID -> PUT/ID
    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa update){
        Pessoa pessoaDb = pessoaRepository.findById(id).orElse(new Pessoa());
        pessoaDb.setId(update.getId());
        pessoaDb.setNome(update.getNome());
        pessoaDb.setDocumento(update.getDocumento());
        return pessoaDb;
    }

    //Deletar pessoa por ID -> DELETE
    @DeleteMapping
    public void delete(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }

}
