package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.IceModel;
import com.example.demo.Repository.IceRepo;



@Service

public class IceService 
{
	//put by id
	private final IceRepo IceRepo;
	@Autowired
    public IceService(IceRepo IceRepo) {
        this.IceRepo = IceRepo;
    }

    public Optional<IceModel> updateById(Long id, IceModel updatedModel) {
        Optional<IceModel> optionalModel = IceRepo.findById(id);
        if (optionalModel.isPresent()) {
            IceModel existingModel = optionalModel.get();
            
            existingModel.setQuantity(updatedModel.getQuantity());
            existingModel.setFlavour(updatedModel.getFlavour());
            existingModel.setToppings(updatedModel.getToppings());
            existingModel.setPrice(updatedModel.getPrice());
            // ... update other properties as needed

            return Optional.of(IceRepo.save(existingModel));
        }
        return Optional.empty();
    }


	@Autowired
	public IceRepo obj;
	//post
	public IceModel saveInfo(IceModel obj1)
	{
		return obj.save(obj1);
	}
	//get
	public List<IceModel> getInfo()
	{
		return obj.findAll();
	}
	
	//get by id
	public Optional<IceModel> getById(Long id) {
        return obj.findById(id);
    }
	
	//put
    public IceModel updateInfo(IceModel iu)
    {
    	return obj.saveAndFlush(iu);
    }
   //delete
    public void deleteInfo(Long id)
    {
    	obj.deleteById(id);
    }
    
  //sorting
  	public List<IceModel> sortDesc(String name)
  	{
  		return obj.findAll(Sort.by(name).descending());
  	}
  	//pagination
  	public List<IceModel> paginationData(int pageNum,int pagesize)
  	{
  		Page<IceModel>p =obj.findAll(PageRequest.of(pageNum, pagesize));
  		return p.getContent();
  	}
	
}
