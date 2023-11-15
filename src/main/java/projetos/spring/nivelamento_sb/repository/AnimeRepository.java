package projetos.spring.nivelamento_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.spring.nivelamento_sb.domain.Anime;


//ESTA CLASSE SERA A CONEXÃO COM O BANCO DE DADOS

//Long É O ATRIBUTO QUE REPRESENTA O ID
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}