package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.railModel;
import com.example.demo.Repository.railRepository;

@Service

public class railService 
{
	private final railRepository railRepository;
	@Autowired
    public railService(railRepository railRepository) {
        this.railRepository = railRepository;
    }

    public Optional<railModel> updateById(Long id, railModel updatedModel) {
        Optional<railModel> optionalModel = railRepository.findById(id);
        if (optionalModel.isPresent()) {
            railModel existingModel = optionalModel.get();
            
            existingModel.setTname(updatedModel.getTname());
            existingModel.setPassName(updatedModel.getPassName());
            existingModel.setEmail(updatedModel.getEmail());
            existingModel.setDestination(updatedModel.getDestination());
            // ... update other properties as needed

            return Optional.of(railRepository.save(existingModel));
        }
        return Optional.empty();
    }


	@Autowired
	public railRepository obj;
	//post
	public railModel saveInfo(railModel obj1)
	{
		return obj.save(obj1);
	}
	//get
	public List<railModel> getInfo()
	{
		return obj.findAll();
	}
	
	//get by id
	public Optional<railModel> getById(Long trainid) {
        return obj.findById(trainid);
    }
	
	//put
    public railModel updateInfo(railModel iu)
    {
    	return obj.saveAndFlush(iu);
    }
   //delete
    public void deleteInfo(Long trainid)
    {
    	obj.deleteById(trainid);
    }
    
	
}
