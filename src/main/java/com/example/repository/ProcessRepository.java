package com.example.repository;

import com.example.domain.ProcessEntity;
import com.example.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcessRepository extends Repository<ProcessEntity, Long>
{

//    List<User> findByNameAndAddress(String name, String address);

//    @Query(value = "from ProcessEntity u where u.ip=:ip")
//    List<User> findByName1(@Param("ip") String ip);
//
//    @Query(value = "select * from #{#entityName} u where u.name=?1", nativeQuery = true)
//    List<User> findByName2(String name);
    @Query(value = "select run_state from process_entity where ip = :ip and main = :main and pid =:pid  ",nativeQuery = true)
    String findByIp(@Param("ip") String ip, @Param("main") String main,@Param("pid") int pid);

//    @Query(value = "select run_state from process_entity where ip = :ip and main = :main and pid =:pid  ",nativeQuery = true)
//    String findByIp(@Param("ip") String ip, @Param("main") String main,@Param("pid") int pid);

//    User findById(Long id);
}
