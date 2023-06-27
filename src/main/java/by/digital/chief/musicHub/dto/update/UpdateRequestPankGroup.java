package by.digital.chief.musicHub.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateRequestPankGroup {
    @NotNull
    private long id;
    @NotBlank
    @Size(max = 50)
    private String pankGroup;
}
