package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestPankGroup;
import by.digital.chief.musicHub.dto.respons.ResponsePankGroup;
import by.digital.chief.musicHub.dto.update.UpdateRequestPankGroup;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.exeptions.ResourceNotFoundException;
import by.digital.chief.musicHub.mapper.PankGroupMapper;
import by.digital.chief.musicHub.repositories.PankGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PankGroupServiceImpl implements PankGroupService {
    private final PankGroupMapper pankGroupMapper;
    private final PankGroupRepository pankGroupRepository;

    @Override
    public ResponsePankGroup getPankGroup(long id) {
        return pankGroupRepository.findById(id)
                .map(pankGroupMapper::buildPankGroupResponse)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Can not find pankgroup with id %s", id)));
    }

    @Override
    public List<PankGroup> getAllPankGroups() {
        return pankGroupRepository.findAll();
    }

    @Override
    public PankGroup addPankGroup(RequestPankGroup requestPankGroup) {
        PankGroup pankGroup = pankGroupMapper.buildPankGroup(requestPankGroup);
        return pankGroupRepository.save(pankGroup);
    }

    @Override
    public void delPankGroup(long id) {
        pankGroupRepository.deleteById(id);
    }

    @Override
    public void updPankGroup(UpdateRequestPankGroup updateRequestPankGroup) {
        PankGroup updatePankGroup = pankGroupRepository.findById(updateRequestPankGroup.getId())
                .map(pankGroup -> {
                    pankGroup.setPankGroup(updateRequestPankGroup.getPankGroup());
                    return pankGroup;
                })
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Not find group.")));
        pankGroupRepository.save(updatePankGroup);
    }
}
