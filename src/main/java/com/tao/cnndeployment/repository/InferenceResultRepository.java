package com.tao.cnndeployment.repository;

import com.tao.cnndeployment.pojo.InferenceObj;
import com.tao.cnndeployment.pojo.InferenceResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InferenceResultRepository extends CrudRepository<InferenceResult, Integer> {
}
