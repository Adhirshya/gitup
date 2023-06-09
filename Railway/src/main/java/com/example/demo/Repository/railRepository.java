package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.railModel;

import jakarta.transaction.Transactional;


public interface railRepository extends JpaRepository<railModel, Long> {

	
	@Query(value="select * from railway",nativeQuery = true)
	public List<railModel> getAllData();
    
    @Query(value="select * from railway where id=:id",nativeQuery=true)
    public List<railModel> byid (@Param("id")int id);
    
    @Query(value="select * from railway where id between :start and :end",nativeQuery=true)
    public List<railModel> startEnd(@Param("start") int start,@Param("end")int end);
    
    @Modifying
    @Transactional
    @Query(value="delete from railway where id=?1 and tname=?2",nativeQuery = true)
    Integer deleteD(@Param("id") int pid,@Param ("name") String pname);
    
    @Modifying
    @Transactional
    @Query(value="update railway set id=:pid where tname=:pname",nativeQuery=true)
    public void updateByQuery(@Param ("pid")int pid,@Param ("pname")String pname);
    
    @Query(value="select r from railModel r")
    List<railModel> jpqlQ();
    
    @Query(value="select r from railModel r where r.id=?1")
    public List<railModel> jqByCon(@Param("sid")int sid);
	
	
}
