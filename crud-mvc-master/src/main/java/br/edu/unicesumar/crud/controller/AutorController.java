package br.edu.unicesumar.crud.controller;
import br.edu.unicesumar.crud.model.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @GetMapping
    public ModelAndView all(){
        ModelAndView view = new ModelAndView("autor");
        view.addObject("autores", repository.findAll());

        return view;
    }

}
