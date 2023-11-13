package projetos.spring.nivelamento_sb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetos.spring.nivelamento_sb.domain.Anime;
import projetos.spring.nivelamento_sb.service.AnimeService;
import projetos.spring.nivelamento_sb.util.DateUtil;


import java.time.LocalDateTime;
import java.util.List;
//ENDPOINT

@RestController//ANOTAÇÃO O RETORNO QUE TEREMOS NESTA CLASSE SERÃO APENAS STRINGS(TODOS OS METODOS IRAM CHAMR O @RESPONSEBODY)
@RequestMapping("animes")//FAZ QUE O ENDIPOIT TODOS ACESSEM ATRAVES DO localhost:8080/anime/list //A APLICAÇÃO @RestController IRÁ PROCURAR O ENDPOINT PARA LISTAR OS NOMES CRIADOS, PARA ISSO DEVE USAR O
@Log4j2
@RequiredArgsConstructor//ESTA ANOTAÇÃO CRIA UM CONSTRUTOR COM TODOS OS ATRIBUTOS RELACIONADOA A CLASSE QUE VOCE TEM, DEVE-SE ACRESCENTAR "final" DEPOIS DO private. pode usar também o @AllArgsConstructor sem ter que usar o "final"
public class AnimeController {
    //localhost:8080/anime/list
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")//PARAMETRO PARA SELECIONAR OS ANIMES POR ID
    public ResponseEntity<Anime> findById(@PathVariable long id) {//para o java mapear essa variavel
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);//HttpStatus.CREATED É RESPONSÁVEL PELO RESULTADO 201
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping//(path = "/{id}")
    public ResponseEntity<Void> replace(@RequestBody Anime anime) {
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}