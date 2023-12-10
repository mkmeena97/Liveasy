package com.liveasy.logistics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.liveasy.logistics.entities.Load;
import com.liveasy.logistics.services.LoadsService;

@RestController
public class LoadsController {
   
    @Autowired
    LoadsService loadserv;

    @GetMapping("/getloads")
    public List<Load> getLoads()
    {
        return loadserv.getLoadsDetail();
    }

    @GetMapping("/getloadbyid/{loadId}")
    public Load getLoadById(@PathVariable int loadId)
    {
        return loadserv.getLoadById(loadId);
    }

    @PostMapping("/saveload")
    public String saveLoad(@RequestBody Load load)
    {
        boolean response = loadserv.addLoad(load);
        if(response==true)
            return "loads details added successfully";
        else
            return "Failed to add load details";    
    }

    @PutMapping("/updateload/{loadId}")
    public String updateLoad(@PathVariable int loadId, @RequestBody Load load)
    {
        boolean updateload = loadserv.updateLoad(loadId, load);
        if(updateload==true)
            return "loads details updated successfully";
        else
            return "Failed to update load details"; 

    }

    @DeleteMapping("/deleteload/{loadId}")
    public void deleteLoad(@PathVariable int loadId)
    {
        loadserv.deleteLoad(loadId);
    }

}
