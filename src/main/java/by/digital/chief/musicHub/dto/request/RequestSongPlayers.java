package by.digital.chief.musicHub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSongPlayers {
    @NotBlank
    @Size(max = 50)
    private String song;
    @NotBlank
    @Size(max = 50)
    private String composer;
    @NotBlank
    @Size(max = 50)
    private String poet;
    @NotNull
    private Integer idAlbum;
}
