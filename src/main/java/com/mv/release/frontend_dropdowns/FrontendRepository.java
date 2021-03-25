package com.mv.release.frontend_dropdowns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FrontendRepository extends JpaRepository<frontend_dropdown,Long> {

/*
    private Long sl_no;
    private String platform;
    private String impact;
    private String impact_areas;
    private String release_type;
 */

    @Query(value = "select platform from frontend_dropdown", nativeQuery = true)
    public List<Object> getplatform();

    @Query(value = "select impact from frontend_dropdown", nativeQuery = true)
    public List<Object> getimpact();

    @Query(value = "select impact_areas from frontend_dropdown", nativeQuery = true)
    public List<Object> getimpact_areas();

    @Query(value = "select release_type from frontend_dropdown", nativeQuery = true)
    public List<Object> getrelease_type();


}
