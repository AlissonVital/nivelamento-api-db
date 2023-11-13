package projetos.spring.nivelamento_sb.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projetos.spring.nivelamento_sb.domain.Anime;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//CLASSE RESPONSAVEL PELA REGRA DE NEGÓCIO E A LÓGICA
@Service
public class AnimeService {
    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "Nóis Stóra!!!"), new Anime(2L,"CVZ"), new Anime(3L, "Liga da Bagaça"), new Anime(4L, "The Walking Dead")));
    }

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1000000000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}
