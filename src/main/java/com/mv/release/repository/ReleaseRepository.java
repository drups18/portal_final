package com.mv.release.repository;

import com.mv.release.entity.Release;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ReleaseRepository extends JpaRepository<Release,Long> {
    //    @Query(value="Select * from all_new_releases where empid=?1" , nativeQuery = true)
    List<Release> findByEmpID(long empID);

   // @Query(value = "Select * from all_new_releases where pod_id=?1",nativeQuery = true)
    List<Release> findByPodid(long teamid);

    //    @Query(value="Select * from all_new_releases where qa_poc=?1",nativeQuery = true)
    List<Release> findByQapoc(String name);

    @Query(value = "Select * from all_new_releases where release_status='Manager_Approved' or release_status='RM_Approved' or release_status='Released'", nativeQuery = true)
    List<Release> findByRelease_status();

    @Query(value = "Select * from all_new_releases where release_status='RM_Approved' or release_status='Released' order by release_date DESC", nativeQuery = true)
    List<Release> findByReleasestatus();



}
