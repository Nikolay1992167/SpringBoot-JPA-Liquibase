package by.digital.chief.musicHub.mapper;

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
                .pankGroup(pankGroupMapper.buildPankGroup(pankGroupService.getPankGroup(requestPeople.getIdGgroup())))
                .stile(requestPeople.getStile())
                .songItems(requestPeople.getSongItems())
                .build();
    }
}
