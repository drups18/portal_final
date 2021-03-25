package com.mv.release.daily_dropdowns;

import java.util.ArrayList;
import java.util.List;

public class daily {
    List<Object> pod = new ArrayList<>();
    List<Object> branch_name = new ArrayList<>();
    List<Object> generic = new ArrayList<>();
    List<Object> sql_queries_approval = new ArrayList<>();
    List<Object> release_status = new ArrayList<>();
    List<Object> release_type = new ArrayList<>();
    List<Object> impact_areas = new ArrayList<>();
    List<Object> impact = new ArrayList<>();
    List<Object> type_of_release = new ArrayList<>();

    public daily(List<Object> pod, List<Object> branch_name, List<Object> generic, List<Object> sql_queries_approval, List<Object> release_status, List<Object> release_type, List<Object> impact_areas, List<Object> impact, List<Object> type_of_release) {
        this.pod = pod;
        this.branch_name = branch_name;
        this.generic = generic;
        this.sql_queries_approval = sql_queries_approval;
        this.release_status = release_status;
        this.release_type = release_type;
        this.impact_areas = impact_areas;
        this.impact = impact;
        this.type_of_release = type_of_release;
    }

    public List<Object> getPod() {
        return pod;
    }

    public void setPod(List<Object> pod) {
        this.pod = pod;
    }

    public List<Object> getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(List<Object> branch_name) {
        this.branch_name = branch_name;
    }

    public List<Object> getGeneric() {
        return generic;
    }

    public void setGeneric(List<Object> generic) {
        this.generic = generic;
    }

    public List<Object> getSql_queries_approval() {
        return sql_queries_approval;
    }

    public void setSql_queries_approval(List<Object> sql_queries_approval) {
        this.sql_queries_approval = sql_queries_approval;
    }

    public List<Object> getRelease_status() {
        return release_status;
    }

    public void setRelease_status(List<Object> release_status) {
        this.release_status = release_status;
    }

    public List<Object> getRelease_type() {
        return release_type;
    }

    public void setRelease_type(List<Object> release_type) {
        this.release_type = release_type;
    }

    public List<Object> getImpact_areas() {
        return impact_areas;
    }

    public void setImpact_areas(List<Object> impact_areas) {
        this.impact_areas = impact_areas;
    }

    public List<Object> getImpact() {
        return impact;
    }

    public void setImpact(List<Object> impact) {
        this.impact = impact;
    }

    public List<Object> getType_of_release() {
        return type_of_release;
    }

    public void setType_of_release(List<Object> type_of_release) {
        this.type_of_release = type_of_release;
    }
}
