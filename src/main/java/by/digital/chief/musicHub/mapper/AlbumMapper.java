package by.digital.chief.musicHub.mapper;

import by.digital.chief.musicHub.dto.request.RequestAlbum;
import by.digital.chief.musicHub.entitie.Album;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class AlbumMapper {
    public Album buildAlbum(RequestAlbum requestAlbum) {
        return Album.builder()
                .album(requestAlbum.getAlbum())
                .build();
    }
}
