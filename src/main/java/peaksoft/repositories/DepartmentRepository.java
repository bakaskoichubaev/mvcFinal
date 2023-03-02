package peaksoft.repositories;

import peaksoft.models.Department;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepo {
    List<Department> findAll(Long hospitalId);

    void save(Department department);

    Department findById(Long departmentId);

    void update(Long departmentId, Department department);


    void delete(Long id, Long hospitalId);


}
