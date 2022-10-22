package com.examen.repository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


import com.examen.entity.Job;

//@EnableJpaRepositories
public interface JobDao extends JpaRepository<Job, Long>{

	@Query(" from Job j where j.name = :puesto  ")
	List<Job> findByPuesto(@Param("puesto") String puesto);
	
    @Query("select j from Job j inner join Employees  e on	j.id = e.id where e.last_name = :lastname  ")
    List<Job> findByLastname(@Param("lastname") String lastname);
    
//    @Query("select e from  Employees e inner join Employee_worked  w on	e.id = w.id where w.worked_date = :worked  ")
//    List<Job> findByhour(@Param("worked") Date worked);

    @Query(" from Employees e  inner join Employee_worked  w on "
    		+ " e.id = w.id "
    		+ " where   substr(w.worked_date, 1,2) between :start and :end")
    List<Job> findByhour(@Param("end") Date start,@Param("end") Date end);


}
