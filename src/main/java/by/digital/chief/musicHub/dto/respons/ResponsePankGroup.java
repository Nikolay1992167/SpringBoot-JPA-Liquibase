package by.digital.chief.musicHub.dto.respons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePankGroup {
    private long id;
    private String pankGroup;
}
