package com.example.repository;

import com.example.domain.ProcessEntity;
import com.example.domain.WarnMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarnMsgJpaRepository extends JpaRepository<WarnMsg,Long> {

//    @Modifying
//    @Query(value = "update warn_msg set run_state = :run_state where ip = :ip and main = :main and pid =:pid  ",nativeQuery = true)
//    void updateNameById(@Param("ip") String ip, @Param("main") String main, @Param("pid") String pid, @Param("run_state") String run_state);
}
