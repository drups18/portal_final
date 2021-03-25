package com.mv.release.frontend_dropdowns;

import java.util.ArrayList;
import java.util.List;

public class frontend {
    List<Object> platform = new ArrayList<>();
    List<Object> impact = new ArrayList<>();
    List<Object> impact_areas = new ArrayList<>();
    List<Object> release_type = new ArrayList<>();

    public frontend(List<Object> platform, List<Object> impact, List<Object> impact_areas, List<Object> release_type) {
        this.platform = platform;
        this.impact = impact;
        this.impact_areas = impact_areas;
        this.release_type = release_type;
    }

    public List<Object> getPlatform() {
        return platform;
    }

    public void setPlatform(List<Object> platform) {
        this.platform = platform;
    }

    public List<Object> getImpact() {
        return impact;
    }

    public void setImpact(List<Object> impact) {
        this.impact = impact;
    }

    public List<Object> getImpact_areas() {
        return impact_areas;
    }

    public void setImpact_areas(List<Object> impact_areas) {
        this.impact_areas = impact_areas;
    }

    public List<Object> getRelease_type() {
        return release_type;
    }

    public void setRelease_type(List<Object> release_type) {
        this.release_type = release_type;
    }
}
