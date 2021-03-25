package com.mv.release.daily_dropdowns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class daily_table {
    private Long sl_no;
    @Column(nullable = true)
    private String type_of_release;
    @Column(nullable = true)
    private String impact;
    @Column(nullable = true)
    private String impact_areas;
    @Column(nullable = true)
    private String release_type;

    private String release_status;

    public String getRelease_status() {
        return release_status;
    }

    public void setRelease_status(String release_status) {
        this.release_status = release_status;
    }

    public String getType_of_release() {
        return type_of_release;
    }

    public void setType_of_release(String type_of_release) {
        this.type_of_release = type_of_release;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getImpact_areas() {
        return impact_areas;
    }

    public void setImpact_areas(String impact_areas) {
        this.impact_areas = impact_areas;
    }

    public String getRelease_type() {
        return release_type;
    }

    public void setRelease_type(String release_type) {
        this.release_type = release_type;
    }

    public String getPOD() {
        return POD;
    }

    public void setPOD(String POD) {
        this.POD = POD;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getSql_queries_approval() {
        return sql_queries_approval;
    }

    public void setSql_queries_approval(String sql_queries_approval) {
        this.sql_queries_approval = sql_queries_approval;
    }

    @Column(nullable = true)
    private String POD;
    @Column(nullable = true)
    private String generic;
    @Column(nullable = true)
    private String branch_name;
    @Column(nullable = true)
    private String sql_queries_approval;


    public void setSl_no(Long sl_no) {
        this.sl_no = sl_no;
    }

    @Id
    public Long getSl_no() {
        return sl_no;
    }

}
