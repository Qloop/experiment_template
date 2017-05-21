package com.upc.model.dao;

import com.upc.model.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Qloop on 2017/5/20.
 */
@Transactional
public interface TemplateDao extends CrudRepository<Template, Long> {
    Template findById(long id);

    Template findByAuthorId(long authorId);
}
