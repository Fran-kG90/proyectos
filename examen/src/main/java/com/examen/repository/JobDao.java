package com.examen.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.examen.entity.Job;

public interface JobDao extends JpaRepository<Job, Long>{

	List<Job> findByPuesto(String puesto);
	
    @Query("from Job j inner join Employees  e on	j.id = e.id where e.last_name = :lastname  ")
    List<Job> findByLastname(@Param("lastname") String lastname);
    
    @Query("count(w.worked_hours) from Employees e inner join Employee_worked  w on	e.id = w.id where w.worked_date = :worked  ")
    List<Job> findByhour(@Param("worked") Date worked);

//    @Query("count(w.worked_hours) from Employees e "
//    		+ "inner join Employee_worked  w on"
//    		+ "	e.id = w.id  "
//    		+ "where  w.worked_date between :fechaConsulta and :fechaSgte")
//    List<Job> findByhourDate(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);


}
