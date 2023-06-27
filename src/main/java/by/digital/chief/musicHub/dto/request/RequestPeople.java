package by.digital.chief.musicHub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPeople {
    @NotBlank
    @Size(max = 50)
    private String human;
    @NotNull
    private Integer age;
    @NotBlank
    @Size(max = 50)
    private String nationality;
    @NotNull
    private Integer idGroup;
    @NotBlank
    @Size(max = 50)
    private String stile;

}
