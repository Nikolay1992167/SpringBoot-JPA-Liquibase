package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestPankGroup;
import by.digital.chief.musicHub.dto.respons.ResponsePankGroup;
import by.digital.chief.musicHub.dto.update.UpdateRequestPankGroup;
import by.digital.chief.musicHub.entitie.PankGroup;

import java.util.List;

public interface PankGroupService {
    ResponsePankGroup getPankGroup(long id);
    List<PankGroup> getAllPankGroups();
    PankGroup addPankGroup(RequestPankGroup requestPankGroup);
    void delPankGroup(long id);
    void updPankGroup(UpdateRequestPankGroup updateRequestPankGroup);
}