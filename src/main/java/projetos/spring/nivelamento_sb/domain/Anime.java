package projetos.spring.nivelamento_sb.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ESTA CLASSE SERA O DOMINIO,
@Data
@AllArgsConstructor
@NoArgsConstructor//AO USAR O @Entity, é necesserátio criar um construtor sem argumentos
@Entity
@Builder
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}