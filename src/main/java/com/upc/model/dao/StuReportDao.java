package com.upc.model.dao;

import com.upc.model.model.StuReport;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Qloop on 2017/5/21.
 */
@Transactional
public interface StuReportDao extends CrudRepository<StuReport, Long> {

    StuReport findById(long id);

    StuReport findByStuId(long stuId);

    StuReport findByStuIdAndTemplateId(long stuId, long templateId);

    Iterable<StuReport> findByTemplateId(long templateId);
}
