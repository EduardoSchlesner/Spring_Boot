package br.com.alura.forum.controller;

import java.util.List;

import br.com.alura.forum.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.controller.dto.TopicoDto;

@RestController // assumindo que todo método terá um ResponseBody!!!
public class TopicosController {

    @Autowired //testecommit
    private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	                                // @ResponseBody -> não é mais necessário, pois colocamos o restController.
	public List<TopicoDto> lista(String nomeCurso) {
        if(nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
	}
	
}
