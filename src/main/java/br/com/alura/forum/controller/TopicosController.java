package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import br.com.alura.forum.TopicoRepository;
import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.repository.CursoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.controller.dto.TopicoDto;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController // assumindo que todo método terá um ResponseBody!!!
@RequestMapping("/topicos") //todos os metodos dessa classe começarão com /topicos!!!
public class TopicosController {
    @Autowired //testecommit
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    // @ResponseBody -> não é mais necessário, pois colocamos o restController.

    @GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
        if(nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
	}
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return  ResponseEntity.ok().build();
    }
}
