package by.digital.chief.musicHub.mapper;

import by.digital.chief.musicHub.dto.request.RequestPankGroup;
import by.digital.chief.musicHub.dto.respons.ResponsePankGroup;
import by.digital.chief.musicHub.entitie.PankGroup;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class PankGroupMapper {
    public PankGroup buildPankGroup(RequestPankGroup requestPankGroup) {
        return PankGroup.builder()
                .pankGroup(requestPankGroup.getPankGroup())
                .build();
    }

    public ResponsePankGroup buildPankGroupResponse(PankGroup pankGroup) {
        return ResponsePankGroup.builder()
                .id(pankGroup.getId())
                .pankGroup(pankGroup.getPankGroup())
                .build();
    }

    public PankGroup buildPankGroup(ResponsePankGroup responsePankGroup) {
        return PankGroup.builder()
                .id(responsePankGroup.getId())
                .pankGroup(responsePankGroup.getPankGroup())
                .build();
    }
}
