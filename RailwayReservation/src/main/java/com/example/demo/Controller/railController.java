package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.railModel;
import com.example.demo.Repository.railRepo;
import com.example.demo.Service.railService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

public class railController
{
	@Autowired
	public railService rs;
	
	@PostMapping("/saveRail")
	public railModel addDetails(@RequestBody railModel obj3)
	{
		return rs.saveInfo(obj3);
	}
	
	@Tag( name="Native query",description="Getting details")
    @GetMapping("/getRail")
    public List <railModel> getDetails()
    {
    	return rs.getInfo();
    }

    
    @PutMapping("updateRail")
    public railModel updateDetails(@RequestBody railModel trainid)
    {
    	return rs.updateInfo(trainid);
    }
    
    @DeleteMapping("/deleteRail/{rid}")
    public String deleteDetails(@PathVariable ("rid") int trainid)
    {
    	rs.deleteInfo(trainid);
    	return "Train Id "+trainid+" is deleted";
    }
    
    @DeleteMapping("/deleteByReq")
    public String deleteByRequesttPara(@RequestParam("rid") int trainid)
    {
    	rs.deleteInfo(trainid);
    	return "Train Id "+trainid+" is deleted";    
    	}
    
    //sorting
    @GetMapping("/sortData/{pna}")
    public List<railModel> sortVote(@PathVariable("pna") String pvote)
    {
    	return rs.sortDesc(pvote);
    }

  //pagination
  @GetMapping("/pagination/{pnu}/{psize}")
  public List<railModel>paginationData(@PathVariable("pnu") int pnu,@PathVariable("psize")int psize)
  {
  	return rs.paginationData(pnu, psize);
  }

  @Autowired
  public railRepo cr;

  @Tag( name="Native query",description="Getting details")
  @GetMapping("saveStudent")
  public List<railModel> getD()
  {
  	return cr.getAllData();
  }
  

  @Tag( name="Native query",description="Getting details by id")
  @GetMapping("byName/{id}")
  public List<railModel> getName(@PathVariable ("id") int pid )
  {
  	return cr.bytrainid(pid);
  }

  @Tag( name="Native query",description="Getting details by start end method")
  @GetMapping("startend/{start}/{end}")
  public List<railModel> getStart(@PathVariable ("start")int start,@PathVariable ("end")int end)
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
  public List<railModel> jplQuery()
  {
  	return cr.jpqlQ();
  }

  @Tag( name="JPQL",description="Getting details by id")
  @GetMapping("/upp/{id}")
  public List<railModel> jpqUp(@PathVariable ("id") int id)
  {
  	return cr.jqByCon(id);
  }

}
