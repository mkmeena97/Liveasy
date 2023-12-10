package com.liveasy.logistics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liveasy.logistics.entities.Load;
import com.liveasy.logistics.repositories.LoadsRepository;

@Service
public class LoadsService {
    
    @Autowired
    LoadsRepository loadrepo;

    public List<Load> getLoadsDetail()
    {
        return loadrepo.findAll();
    }

    public Load getLoadById(int loadId)
    {
        Load l;
        Optional<Load> ol = loadrepo.findById(loadId);
        try{
            l=ol.get();
        }catch(Exception e)
        {
            l=null;
        }
        return l;
    }

    @Transactional
    public boolean addLoad(Load load)
    {
        Load savedLoad = loadrepo.save(load);
        if(savedLoad!=null)
            return true;
        else
            return false;    
    }

    public boolean updateLoad(int loadId, Load updatedLoad) {
        Optional<Load> existingLoadOptional = loadrepo.findById(loadId);

        if (existingLoadOptional.isPresent()) {
            Load existingLoad = existingLoadOptional.get();
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            Load l = loadrepo.save(existingLoad);
            if(l!=null){
                return true;
            }
            else
                return false;
        } else {
          return false;
        }
    }

    public void deleteLoad(int loadId)
    {
         loadrepo.deleteById(loadId);
    }
}
