package org.example.Repositories;

import org.example.Model.JobTitleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobTitleRepository extends CrudRepository<JobTitleModel, Long> {
    @Override
    List<JobTitleModel> findAll();

    @Override
    <S extends JobTitleModel> S save(S entity);
}
