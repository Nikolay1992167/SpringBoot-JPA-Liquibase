package by.digital.chief.musicHub.dto.respons;

import by.digital.chief.musicHub.entitie.Album;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EnableTransactionManagement
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePankGroup {
    private long id;
    private String pankGroup;
    private List<ResponsePeople> peopleList;


    @Transactional
    public List<ResponsePankGroup> getAllPankGroupResponseList(List<PankGroup> pankGroupList) {
        List<ResponsePankGroup> responsePankGroupList = new ArrayList<>();

        for (PankGroup pankGroup : pankGroupList) {
            peopleList = new ArrayList<>();

            ResponsePankGroup responsePankGroup = new ResponsePankGroup();
            responsePankGroup.setId(pankGroup.getId());
            responsePankGroup.setPankGroup(pankGroup.getPankGroup());
            for (People people : pankGroup.getPeopleList()) {
                ResponsePeople responsePeople = new ResponsePeople();
                responsePeople.setId(people.getId());
                responsePeople.setHuman(people.getHuman());
                responsePeople.setAge(people.getAge());
                responsePeople.setNationality(people.getNationality());
                responsePeople.setStile(people.getStile());
                responsePeople.setGroup((people.getPankGroup()).getPankGroup());
                peopleList.add(responsePeople);
            }
            responsePankGroup.setPeopleList(peopleList);
            responsePankGroupList.add(responsePankGroup);
        }
        return responsePankGroupList;
    }

}
