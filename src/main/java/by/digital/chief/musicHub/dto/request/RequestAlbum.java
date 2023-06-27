package by.digital.chief.musicHub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestAlbum {
    @NotBlank
    @Size(max = 50)
    private String album;
}
