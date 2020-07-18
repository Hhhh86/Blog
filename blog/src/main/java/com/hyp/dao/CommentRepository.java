package com.hyp.dao;

import com.hyp.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @ProjectName blog
 * @ClassName CommentRepository
 * @create 2020-07-16 22:01
 * @Author by hyp
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
