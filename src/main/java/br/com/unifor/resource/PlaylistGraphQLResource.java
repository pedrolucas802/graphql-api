package br.com.unifor.resource;

import br.com.unifor.domain.PlaylistEntity;
import br.com.unifor.service.PlaylistService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Mutation;

import jakarta.inject.Inject;
import java.util.List;

@GraphQLApi
public class PlaylistGraphQLResource {

    @Inject
    PlaylistService playlistService;

    @Query
    @Description("Get a list of all playlist entries")
    public List<PlaylistEntity> allPlaylists() {
        return playlistService.list();
    }

    @Mutation
    @Description("Create a new playlist entry")
    public PlaylistEntity createPlaylist(PlaylistEntity playlist) {
        return playlistService.create(playlist);
    }

    @Mutation
    @Description("Update an existing playlist entry")
    public PlaylistEntity updatePlaylist(PlaylistEntity playlist) {
        return playlistService.update(playlist);
    }

    @Query
    @Description("Find a playlist entry by ID")
    public PlaylistEntity findPlaylistById(Long id) {
        return playlistService.findById(id);
    }

    @Mutation
    @Description("Delete a playlist entry by ID")
    public boolean deletePlaylist(Long id) {
        return playlistService.delete(id);
    }
}
