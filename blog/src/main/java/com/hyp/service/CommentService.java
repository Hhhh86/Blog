package com.hyp.service;

import com.hyp.pojo.Comment;

import java.util.List;

/**
 * @ProjectName blog
 * @ClassName CommentService
 * @create 2020-07-16 21:58
 * @Author by hyp
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

}
