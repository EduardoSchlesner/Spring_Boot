package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Curso;

@RestController // assumindo que todo método terá um ResponseBody!!!
public class TopicosController {

	@RequestMapping("/topicos")
	                                // @ResponseBody -> não é mais necessário, pois colocamos o restController.
	public List<Topico> lista() {
		
		Topico topico = new Topico ("Duvida", "Duvida com spring", new Curso("Spring", "Programação"));
		
		return Arrays.asList(topico, topico, topico);
	}
	
}
