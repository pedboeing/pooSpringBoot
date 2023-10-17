package br.edu.unicesumar.crud.service;

import br.edu.unicesumar.crud.model.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaService {

    public List<Pessoa> selectAll(){
        return Arrays.asList(
                new Pessoa(1L,"João", "123"),
                new Pessoa(2L,"Maria", "456")
        );
    }
}
