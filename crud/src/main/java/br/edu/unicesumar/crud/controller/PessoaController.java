package br.edu.unicesumar.crud.controller;

import br.edu.unicesumar.crud.model.Pessoa;
import br.edu.unicesumar.crud.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;


    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> all(){
        return service.selectAll();
    }


    @GetMapping("/{id}")
    public Pessoa getId(@PathVariable Long id) {
        return service.selectAll().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);

    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa){
     long maxId = mock().stream().mapToLong(Pessoa::getId).max().orElse(0L);

     return new Pessoa(maxId+1L, pessoa.getNome(), pessoa.getDocumento());

    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id,
                         @RequestBody Pessoa pessoaUpdate){
        Pessoa pessoaEdit = mock().stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst().orElse(null);

        if(pessoaEdit == null){
            return null;
        }

        return new Pessoa(pessoaEdit.getId(),
                pessoaUpdate.getNome(),
                pessoaUpdate.getDocumento());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Pessoa pessoaRemove = mock().stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findFirst().orElse(null);

        mock().remove(pessoaRemove);
    }

    private List<Pessoa> mock() {
        return Arrays.asList(
                new Pessoa(1L, "Antonio","123"),
                new Pessoa(2L, "Bento","456"),
                new Pessoa(3L, "João","789"),
                new Pessoa(4L, "Joaquim","189"),
                new Pessoa(5L, "Monica","999"),
                new Pessoa(6L, "Magali","888")
        );
    }
}
