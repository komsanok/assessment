package com.kbtg.bootcamp.posttest.repositories;

import com.kbtg.bootcamp.posttest.entities.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LotteryRepository extends JpaRepository<Lottery,Long> {

    @Query(value = "select * from Lottery where ticket =:LotteryId",nativeQuery = true)
    List<Lottery> findByLotteryId(@Param("LotteryId")String LotteryId);

    @Query(value = "select count(*) from Lottery where ticket =:LotteryId",nativeQuery = true)
    int countByLotteryId(@Param("LotteryId")String LotteryId);

}
