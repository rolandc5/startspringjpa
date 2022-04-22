package org.example.Repositories;

import org.example.Model.DepartmentModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentModel, Long> {
    @Override
    List<DepartmentModel> findAll();

    @Override
    <S extends DepartmentModel> S save(S entity);
}
