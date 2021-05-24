package com.lapor.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.lapor.main.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{

	@Query( value = "select * from user where nama LIKE %?1% or email LIKE %?1% or alamat LIKE %?1% or hp LIKE %?1%", nativeQuery=true)
	List <User> findAllData(String data);
	
//	List<User> findBySearchBy(@Param("type")String type,@Param("value")String value);
//	User findByNama(String nama);

}
