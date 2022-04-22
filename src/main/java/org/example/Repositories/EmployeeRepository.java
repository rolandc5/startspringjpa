package org.example.Repositories;

import org.example.Model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long> {
    @Override
    List<EmployeeModel> findAll();

    @Override
    <S extends EmployeeModel> S save(S entity);
}
