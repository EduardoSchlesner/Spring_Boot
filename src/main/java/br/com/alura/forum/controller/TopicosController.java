package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;

@RestController // assumindo que todo método terá um ResponseBody!!!
public class TopicosController {

	@RequestMapping("/topicos")
	                                // @ResponseBody -> não é mais necessário, pois colocamos o restController.
	public List<TopicoDto> lista() {
		
		Topico topico = new Topico ("Dúvida", "Dúvida a tratar do Spring Boot", new Curso("Spring Boot", "Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}
	
}
