package com.practice.cloud.azure.repository;

import com.practice.cloud.azure.model.PincodeData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PincodeRepository extends PagingAndSortingRepository<PincodeData, String> {
}
