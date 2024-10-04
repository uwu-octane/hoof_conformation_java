package com.tao.cnndeployment.repository;

import com.tao.cnndeployment.pojo.InferenceObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InferenceObjRepository extends JpaRepository<InferenceObj, Integer> {

    Optional<InferenceObj> findByFileName(String filename);


}
