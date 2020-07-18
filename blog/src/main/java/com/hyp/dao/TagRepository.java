package com.hyp.dao;

import com.hyp.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName blog
 * @ClassName TagRepository
 * @create 2020-07-11 7:06
 * @Author by hyp
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from t_tag t")
    List<Tag> findTop(Pageable pageable);
}
