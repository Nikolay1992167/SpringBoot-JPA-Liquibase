package by.digital.chief.musicHub.dto.respons;

import by.digital.chief.musicHub.entitie.Album;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EnableTransactionManagement
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAlbum {
    private long id;
    private String album;
    private List<ResponseSongPlayers> songPlayersList;

    @Transactional
    public List<ResponseAlbum> getAllAlbumResponseList(List<Album> albumList) {
        List<ResponseAlbum> responseAlbumList = new ArrayList<>();

        for (Album album : albumList) {
            songPlayersList = new ArrayList<>();

            ResponseAlbum responseAlbum = new ResponseAlbum();
            responseAlbum.setId(album.getId());
            responseAlbum.setAlbum(album.getAlbum());
            for (SongPlayers songPlayers : album.getSongPlayersList()) {
                ResponseSongPlayers responseSongPlayers = new ResponseSongPlayers();
                responseSongPlayers.setId(songPlayers.getId());
                responseSongPlayers.setSong(songPlayers.getSong());
                responseSongPlayers.setComposer(songPlayers.getComposer());
                responseSongPlayers.setAlbum((songPlayers.getAlbum()).getAlbum());
                responseSongPlayers.setPoet(songPlayers.getPoet());
                songPlayersList.add(responseSongPlayers);
            }
            responseAlbum.setSongPlayersList(songPlayersList);
            responseAlbumList.add(responseAlbum);
        }
        return responseAlbumList;
    }
}
