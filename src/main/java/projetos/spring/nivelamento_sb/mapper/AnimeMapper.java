package projetos.spring.nivelamento_sb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import projetos.spring.nivelamento_sb.domain.Anime;
import projetos.spring.nivelamento_sb.requests.AnimePostRequestBody;
import projetos.spring.nivelamento_sb.requests.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePostRequestBody);
}