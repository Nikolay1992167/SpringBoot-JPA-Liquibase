package by.digital.chief.musicHub.controllers;

import by.digital.chief.musicHub.dto.request.RequestPankGroup;
import by.digital.chief.musicHub.dto.update.UpdateRequestPankGroup;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.services.PankGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pankgroup")
@RequiredArgsConstructor
public class PankGroupController {

    private final PankGroupService pankGroupServiceImpl;

    @GetMapping("/all")
    public List<PankGroup> getAllPankGroups(){
        return pankGroupServiceImpl.getAllPankGroups();
    }

    @PostMapping("/add")
    public PankGroup addRockGroups(@RequestBody RequestPankGroup requestPankGroup){
        return pankGroupServiceImpl.addPankGroup(requestPankGroup);
    }

    @DeleteMapping("/del/{id}")
    public void delPankGroups(@PathVariable long id){
        pankGroupServiceImpl.delPankGroup(id);
    }

    @PutMapping("/upd/{id}")
    public void updPankGroups(@RequestBody UpdateRequestPankGroup updateRequestPankGroup){
        pankGroupServiceImpl.updPankGroup(updateRequestPankGroup);
    }
}
