package com.mv.release.repository;

import com.mv.release.entity.Release;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ReleaseRepository extends JpaRepository<Release,Long> {
    @Query(value="Select * from all_new_releases where empid=?1" , nativeQuery = true)
    List<Release> findbyempid(long empID);

    @Query(value = "Select * from all_new_releases where pod_id=?1",nativeQuery = true)
    List<Release> findbypodid(long teamid);

    @Query(value="Select * from all_new_releases where qa_poc=?1",nativeQuery = true)
    List<Release> findbyname(String name);
}
