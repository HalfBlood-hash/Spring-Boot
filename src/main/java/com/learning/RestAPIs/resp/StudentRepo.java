package com.learning.RestAPIs.resp;

import com.learning.RestAPIs.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
}
