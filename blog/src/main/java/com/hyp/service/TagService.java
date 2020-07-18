package com.hyp.service;

import com.hyp.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ProjectName blog
 * @ClassName TagService
 * @create 2020-07-11 7:04
 * @Author by hyp
 */
public interface TagService {
    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);
}


