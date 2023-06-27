package by.digital.chief.musicHub.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateRequestPeople {
    @NotNull
    private long id;
    @NotBlank
    @Size(max = 50)
    private String human;
    @NotNull
    private Integer age;
    @NotBlank
    @Size(max = 50)
    private String nationality;
    @NotNull
    private long idGroup;
    @NotBlank
    @Size(max = 50)
    private String stile;
}
