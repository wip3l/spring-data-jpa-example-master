package com.example.repository;


import com.example.domain.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TopicJpaRepository extends JpaRepository<TopicEntity,Long> {

//    @Modifying
//    @Query(value = "update process_entity set run_state = :run_state where ip = :ip and main = :main and pid =:pid  ",nativeQuery = true)
//    void updateNameById(@Param("ip") String ip, @Param("main") String main, @Param("pid") String pid, @Param("run_state") String run_state);
//    @Query(value = "select run_state from process_entity where ip = :ip and main = :main and pid =:pid  ",nativeQuery = true)
//    String findByIp(@Param("ip") String ip, @Param("main") String main,@Param("pid") int pid);

}
