package com.mv.release.daily_dropdowns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface daily_repository extends JpaRepository<daily_table,Long> {
    @Query(value = "SELECT * FROM daily_table " , nativeQuery = true)
    List<daily_table> findfulldata();

    @Query(value = "SELECT pod FROM daily_table",nativeQuery = true)
    List<Object> findpod();

    @Query(value = "SELECT impact from daily_table ", nativeQuery = true)
    List<Object> findimpact();

    @Query(value = "SELECT impact_areas from daily_table ", nativeQuery = true)
    List<Object> findimpactareas();

    @Query(value = "SELECT release_type from daily_table ", nativeQuery = true)
    List<Object> findrelease_type();

    @Query(value = "select generic from daily_table", nativeQuery = true)
    List<Object> findgenerics();

    @Query(value = "select branch_name from daily_table", nativeQuery = true)
    List<Object> findbranch_name();

    @Query(value = "select sql_queries_approval from daily_table", nativeQuery = true)
    List<Object> findsql_queries_approval();

    @Query(value = "select release_status from daily_table", nativeQuery = true)
    List<Object> findrelease_status();

    @Query(value = "select type_of_release from daily_table", nativeQuery = true)
    List<Object> findtyperelease();


}
