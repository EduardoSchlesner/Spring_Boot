package br.com.alura.forum;

import br.com.alura.forum.controller.form.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//lugar onde teremos a logica de autenticacao.

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){

        System.out.println(form.getEmail());
        System.out.println(form.getSenha());



        return ResponseEntity.ok().build(); //testando os dados e retornando um OK.
    }

}
