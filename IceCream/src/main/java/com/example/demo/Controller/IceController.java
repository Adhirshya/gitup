package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.IceModel;
import com.example.demo.Repository.IceRepo;
import com.example.demo.Service.IceService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@CrossOrigin("http://localhost:3000")

public class IceController
{
	private final IceService IceService;

    @Autowired
    public IceController(IceService IceService) {
        this.IceService = IceService;
    }

    @PutMapping("/put/{id}")
    public Optional<IceModel> updateById(@PathVariable("id") Long id, @RequestBody IceModel updatedModel) 
    {
        return IceService.updateById(id, updatedModel);
    }
	
	@Autowired
	public IceService rs;
	
	@PostMapping("/post")
	public IceModel addDetails(@RequestBody IceModel obj3)
	{
		return rs.saveInfo(obj3);
	}
	
    @GetMapping("/get")
    public List <IceModel> getDetails()
    {
    	return rs.getInfo();
    }

    
   @PutMapping("/put")
    public IceModel updateDetails(@RequestBody IceModel trainid)
    {
    	return rs.updateInfo(trainid);
    }
    
   @DeleteMapping("/delete/{rid}")
    public String deleteDetails(@PathVariable ("rid") Long id)
    {
    	rs.deleteInfo(id);
    	return "Id "+id+" is deleted";
    }
    
    
    @GetMapping("/get/{id}")
    public Optional<IceModel> getById(@PathVariable("id") Long id)
    {
        return rs.getById(id);
        
    }
    
    //sorting
    @GetMapping("/sortData/{pna}")
    public List<IceModel> sortVote(@PathVariable("pna") String pvote)
    {
    	return rs.sortDesc(pvote);
    }

  //pagination
  @GetMapping("/pagination/{pnu}/{psize}")
  public List<IceModel>paginationData(@PathVariable("pnu") int pnu,@PathVariable("psize")int psize)
  {
  	return rs.paginationData(pnu, psize);
  }
  
  @Autowired
  public IceRepo cr;

  @Tag( name="Native query",description="Getting details")
  @GetMapping("saveStudent")
  public List<IceModel> getD()
  {
  	return cr.getAllData();
  }
  

  @Tag( name="Native query",description="Getting details by id")
  @GetMapping("byName/{id}")
  public List<IceModel> getName(@PathVariable ("id") int pid )
  {
  	return cr.byid(pid);
  }

  @Tag( name="Native query",description="Getting details by start end method")
  @GetMapping("startend/{start}/{end}")
  public List<IceModel> getStart(@PathVariable ("start")int start,@PathVariable ("end")int end)
  {
  	return cr.startEnd(start, end);
  }

  @Tag( name="Native query",description="Deleting details by id and name")
  @DeleteMapping("/del/{id}/{name}")
  public String delD(@PathVariable ("id") int id,@PathVariable ("name")String name)
  {
  	cr.deleteD(id, name);
  	return "deleted";
  }

  @Tag( name="Native query",description="Posting details")
  @PutMapping("updatee/{pid}/{pname}")
  public void updateQue(@PathVariable("pid")int pid,@PathVariable("pname") String pname)
  {
  	cr.updateByQuery(pid, pname);
  }

  @Tag( name="JPQL",description="Getting details by methods")
  @GetMapping("jp")
  public List<IceModel> jplQuery()
  {
  	return cr.jpqlQ();
  }

  @Tag( name="JPQL",description="Getting details by id")
  @GetMapping("/upp/{id}")
  public List<IceModel> jpqUp(@PathVariable ("id") int id)
  {
  	return cr.jqByCon(id);
  }
    
    
}
