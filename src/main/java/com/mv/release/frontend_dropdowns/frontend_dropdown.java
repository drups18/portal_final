package com.mv.release.frontend_dropdowns;

import javax.persistence.*;

@Entity
public class frontend_dropdown {
    private Long sl_no;
    private String platform;
    private String impact;
    private String impact_areas;
    private String release_type;

    @Column(nullable = true)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Column(nullable = true)
    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    @Column(nullable = true)
    public String getImpact_areas() {
        return impact_areas;
    }

    public void setImpact_areas(String impact_areas) {
        this.impact_areas = impact_areas;
    }
    @Column(nullable = true)
    public String getRelease_type() {
        return release_type;
    }

    public void setRelease_type(String release_type) {
        this.release_type = release_type;
    }

    public void setSl_no(Long sl_no) {
        this.sl_no = sl_no;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSl_no() {
        return sl_no;
    }
}
