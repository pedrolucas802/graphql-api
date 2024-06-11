package br.com.unifor.resource;

import br.com.unifor.domain.MusicEntity;
import br.com.unifor.service.MusicService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Mutation;

import jakarta.inject.Inject;
import java.util.List;

@GraphQLApi
public class MusicGraphQLResource {

    @Inject
    MusicService musicService;

    @Query
    @Description("Get a list of all music entries")
    public List<MusicEntity> allMusic() {
        return musicService.list();
    }

    @Mutation
    @Description("Create a new music entry")
    public MusicEntity createMusic(MusicEntity music) {
        return musicService.create(music);
    }

    @Mutation
    @Description("Update an existing music entry")
    public MusicEntity updateMusic(MusicEntity music) {
        return musicService.update(music);
    }

    @Query
    @Description("Find a music entry by ID")
    public MusicEntity findMusicById(Long id) {
        return musicService.findById(id);
    }

    @Mutation
    @Description("Delete a music entry by ID")
    public boolean deleteMusic(Long id) {
        return musicService.delete(id);
    }
}
