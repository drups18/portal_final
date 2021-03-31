package com.mv.release.hotfix_dropdowns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotfixRepository extends JpaRepository<hotfix_entity,Long> {

    /*
    private Long sl_no;
    private String pod;
    private String impact_areas;
    private String impact;
    private String release_status;
    private String approved_by;
    private String type_of_release;
     */

    @Query(value = "select pod from hotfix_entity", nativeQuery = true)
    public List<Object> pod();

    @Query(value = "select impact_areas from hotfix_entity", nativeQuery = true)
    public List<Object> impact_areas();

    @Query(value = "select impact from hotfix_entity", nativeQuery = true)
    public List<Object> impact();

    @Query(value = "select release_status from hotfix_entity", nativeQuery = true)
    public List<Object> release_status();

    @Query(value = "select approved_by from hotfix_entity", nativeQuery = true)
    public List<Object> approved_by();

    @Query(value = "select type_of_release from hotfix_entity", nativeQuery = true)
    public List<Object> type_of_release();

    @Query(value = "select type_of_release3 from hotfix_entity", nativeQuery = true)
    public List<Object> type_of_release3();

}
