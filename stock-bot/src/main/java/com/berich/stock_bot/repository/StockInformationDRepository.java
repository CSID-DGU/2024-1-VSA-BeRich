package com.berich.stock_bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.berich.stock_bot.entity.StockInformationD;

public interface StockInformationDRepository extends JpaRepository<StockInformationD, Long>{


    boolean existsByTimestamp(Long timestamp);
    
    @Query("SELECT MIN(s.timestamp) FROM StockInformationD s")
    Long findMinTimestamp();

    // 특정 타임스탬프를 기준으로 삭제
    @Modifying
    @Transactional
    void deleteByTimestamp(Long timestamp);
}