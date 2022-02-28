package com.suncode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RowRepository extends CrudRepository<Row, Long> {
    List<Row> findAll();
}
