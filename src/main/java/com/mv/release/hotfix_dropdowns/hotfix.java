package com.mv.release.hotfix_dropdowns;

import java.util.ArrayList;
import java.util.List;

public class hotfix {

    List<Object> pod = new ArrayList<>();
    List<Object> impact_areas = new ArrayList<>();
    List<Object> impact = new ArrayList<>();
    List<Object> release_status = new ArrayList<>();
    List<Object> appoved_by = new ArrayList<>();
    List<Object> type_of_release = new ArrayList<>();

    public hotfix(List<Object> pod, List<Object> impact_areas, List<Object> impact, List<Object> release_status
            , List<Object> appoved_by, List<Object> type_of_release) {
        this.pod = pod;
        this.impact_areas = impact_areas;
        this.impact = impact;
        this.release_status = release_status;
        this.appoved_by = appoved_by;
        this.type_of_release = type_of_release;
    }

    public List<Object> getPod() {
        return pod;
    }

    public void setPod(List<Object> pod) {
        this.pod = pod;
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

    public List<Object> getRelease_status() {
        return release_status;
    }

    public void setRelease_status(List<Object> release_status) {
        this.release_status = release_status;
    }

    public List<Object> getAppoved_by() {
        return appoved_by;
    }

    public void setAppoved_by(List<Object> appoved_by) {
        this.appoved_by = appoved_by;
    }

    public List<Object> getType_of_release() {
        return type_of_release;
    }

    public void setType_of_release(List<Object> type_of_release) {
        this.type_of_release = type_of_release;
    }
}
