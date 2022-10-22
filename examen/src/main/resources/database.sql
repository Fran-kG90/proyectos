select * from employees
  select * from jobs
  select * from gender
    select * from employe_worked_hours
  
  
   insert into employees (id,birthdate,last_name,name,id_gender,id_job)
  values (1,'2004-02-05','Gallardo','Francisco',1,1);
  
   insert into employees (id,birthdate,last_name,name,id_gender,id_job)
  values (2,'2005-04-09','Hernandez','Ana',2,2);
  
   insert into jobs (id,name,salary)
  values (1,'Carpintero',6000);
  
     insert into jobs (id,name,salary)
  values (2,'Medico',8000);
  
   insert into gender (id,name)
  values (1,'masculino');
  
     insert into gender (id,name)
  values (2,'femenino');
  
     insert into employe_worked_hours (id,worked_date,worked_hours)
  values (1,1,'2003-06-25',8);
  
  
  select *  from employees e 
    		inner join employe_worked_hours  w on
    			e.id = w.id  
    		where  w.worked_date between   like( '%?1%' , '%?5%')
  
  Select sum(w.worked_hours) as hours  from employees e
  inner join employe_worked_hours  w on
    			e.id = w.id  
  where   substr(w.worked_date, 1,2) between '05' and '25';
  
  
   Select * from employees e
  inner join employe_worked_hours  w on
    			e.id = w.id   
   where   substr(w.worked_date, 1,2) = '06'
