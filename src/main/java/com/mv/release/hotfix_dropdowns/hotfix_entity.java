package com.mv.release.hotfix_dropdowns;

import javax.persistence.*;

@Entity
public class hotfix_entity {

    private Long sl_no;
    private String pod;
    private String impact_areas;
    private String impact;
    private String release_status;
    private String approved_by;
    private String type_of_release;

    @Column(nullable = true)
    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Column(nullable = true)
    public String getImpact_areas() {
        return impact_areas;
    }

    public void setImpact_areas(String impact_areas) {
        this.impact_areas = impact_areas;
    }

    @Column(nullable = true)
    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    @Column(nullable = true)
    public String getRelease_status() {
        return release_status;
    }

    public void setRelease_status(String release_status) {
        this.release_status = release_status;
    }

    @Column(nullable = true)
    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    @Column(nullable = true)
    public String getType_of_release() {
        return type_of_release;
    }

    public void setType_of_release(String type_of_release) {
        this.type_of_release = type_of_release;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSl_no() {
        return sl_no;
    }

    public void setSl_no(Long sl_no) {
        this.sl_no = sl_no;
    }
}
