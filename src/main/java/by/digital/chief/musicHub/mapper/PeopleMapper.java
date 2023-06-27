package by.digital.chief.musicHub.mapper;

import by.digital.chief.musicHub.dto.request.RequestPeople;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.services.PankGroupService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@RequiredArgsConstructor
public class PeopleMapper {
    private final PankGroupService pankGroupService;
    private final PankGroupMapper pankGroupMapper;

    public People buildPeople(RequestPeople requestPeople) {
        return People.builder()
                .human(requestPeople.getHuman())
                .age(requestPeople.getAge())
                .nationality(requestPeople.getNationality())
                .pankGroup(pankGroupMapper.buildPankGroup(pankGroupService.getPankGroup(requestPeople.getIdGroup())))
                .stile(requestPeople.getStile())
                .build();
    }
}
