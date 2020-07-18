package com.hyp.dao;

import com.hyp.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName blog
 * @ClassName TypeRepository
 * @create 2020-07-10 19:37
 * @Author by hyp
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from t_type t")
    List<Type> findTop(Pageable pageable);
}
