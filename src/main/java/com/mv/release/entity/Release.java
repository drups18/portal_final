package com.mv.release.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="all_new_releases")
public class Release {
    private Long release_id;
    private Long empID;
    private String pod_id;
    private String Description;
    private String impact;
    private String impact_area;
    private String release_status;  // to do, done
    private String dev_poc;
    private String qa_poc;
    private String approved_by; // Manager
    private String type_of_release; //feature or bugfix (Common)
    private String type_of_release2; //integra, whizdm, atlas (Daily)
    private String type_of_release3; //Portal, razorpay (Hotfix) same as daily
    private String prlink;
    private Date release_date;
    private String release_window; // Immediate or daily
    private String source_rel_date; //hotfix
    private String src_of_hotfix; //hotfix
    private String item;
    private Date tech_pr_signoff; //Backend
    private String sql_approval;  //Backend
    private String heavy_sql_alter; //Backend
    private Date stage_qa_signoff;
    private Date stage_integration_signoff;
    private String roll_out_percentage;
    private String requires_bar;
    private Date bar_date;
    private String platform; // frontend PWA, Agency Portal
    private String release_version; //frontend
    private Date release_signoff_date;
    private String release;
    private String Stage;

    public Release() {
    }

    public void setRelease_id(Long release_id) {
        this.release_id = release_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getRelease_id() {

        return release_id;
    }

    public Long getEmpID() {
        return empID;
    }
    public void setEmpID(Long empID) {
        this.empID = empID;
    }
    public String getPod_id() {
        return pod_id;
    }
    public void setPod_id(String pod_id) {
        this.pod_id = pod_id;
    }
    @Column(nullable = true)
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    @Column(nullable = true)
    public String getImpact() {
        return impact;
    }
    public void setImpact(String impact) {
        this.impact = impact;
    }
    @Column(nullable = true)
    public String getImpact_area() {
        return impact_area;
    }
    public void setImpact_area(String impact_area) {
        this.impact_area = impact_area;
    }
    @Column(nullable = true)
    public String getRelease_status() {
        return release_status;
    }
    public void setRelease_status(String release_status) {
        this.release_status = release_status;
    }
    @Column(nullable = true)
    public String getDev_poc() {
        return dev_poc;
    }
    public void setDev_poc(String dev_poc) {
        this.dev_poc = dev_poc;
    }
    @Column(nullable = true)
    public String getType_of_release2() {
        return type_of_release2;
    }
    public void setType_of_release2(String type_of_release2) {
        this.type_of_release2 = type_of_release2;
    }
    @Column(nullable = true)
    public String getType_of_release() {
        return type_of_release;
    }
    public void setType_of_release(String type_of_release) {
        this.type_of_release = type_of_release;
    }
    @Column(nullable = true)
    public String getType_of_release3() {
        return type_of_release3;
    }
    public void setType_of_release3(String type_of_release3) {
        this.type_of_release3 = type_of_release3;
    }
    @Column(nullable = true)
    public String getPrlink() {
        return prlink;
    }
    public void setPrlink(String prlink) {
        this.prlink = prlink;
    }
    @Column(nullable = true)
    public Date getRelease_date() {
        return release_date;
    }
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
    @Column(nullable = true)
    public String getRelease_window() {
        return release_window;
    }
    public void setRelease_window(String release_window) {
        this.release_window = release_window;
    }
    @Column(nullable = true)
    public String getApproved_by() {
        return approved_by;
    }
    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }
    @Column(nullable = true)
    public String getSource_rel_date() {
        return source_rel_date;
    }
    public void setSource_rel_date(String source_rel_date) {
        this.source_rel_date = source_rel_date;
    }
    @Column(nullable = true)
    public String getSrc_of_hotfix() {
        return src_of_hotfix;
    }
    public void setSrc_of_hotfix(String src_of_hotfix) {
        this.src_of_hotfix = src_of_hotfix;
    }
    @Column(nullable = true)
    public String getQa_poc() {
        return qa_poc;
    }
    public void setQa_poc(String qa_poc) {
        this.qa_poc = qa_poc;
    }
    @Column(nullable = true)
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    @Column(nullable = true)
    public Date getTech_pr_signoff() {
        return tech_pr_signoff;
    }
    public void setTech_pr_signoff(Date tech_pr_signoff) {
        this.tech_pr_signoff = tech_pr_signoff;
    }
    @Column(nullable = true)
    public String getSql_approval() {
        return sql_approval;
    }
    public void setSql_approval(String sql_approval) {
        this.sql_approval = sql_approval;
    }
    @Column(nullable = true)
    public String getHeavy_sql_alter() {
        return heavy_sql_alter;
    }
    public void setHeavy_sql_alter(String heavy_sql_alter) {
        this.heavy_sql_alter = heavy_sql_alter;
    }
    @Column(nullable = true)
    public Date getStage_qa_signoff() {
        return stage_qa_signoff;
    }
    public void setStage_qa_signoff(Date stage_qa_signoff) {
        this.stage_qa_signoff = stage_qa_signoff;
    }
    @Column(nullable = true)
    public Date getStage_integration_signoff() {
        return stage_integration_signoff;
    }
    public void setStage_integration_signoff(Date stage_integration_signoff) {
        this.stage_integration_signoff = stage_integration_signoff;
    }
    @Column(nullable = true)
    public String getRoll_out_percentage() {
        return roll_out_percentage;
    }
    public void setRoll_out_percentage(String roll_out_percentage) {
        this.roll_out_percentage = roll_out_percentage;
    }
    @Column(nullable = true)
    public String getRequires_bar() {
        return requires_bar;
    }
    public void setRequires_bar(String requires_bar) {
        this.requires_bar = requires_bar;
    }
    @Column(nullable = true)
    public Date getBar_date() {
        return bar_date;
    }
    public void setBar_date(Date bar_date) {
        this.bar_date = bar_date;
    }
    @Column(nullable = true)
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    @Column(nullable = true)
    public String getRelease_version() {
        return release_version;
    }
    public void setRelease_version(String release_version) {
        this.release_version = release_version;
    }
    @Column(nullable = true)
    public Date getRelease_signoff_date() {
        return release_signoff_date;
    }
    public void setRelease_signoff_date(Date release_signoff_date) {
        this.release_signoff_date = release_signoff_date;
    }
    @Column(nullable = true)
    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
    @Column(nullable = true)
    public String getStage() {
        return Stage;
    }

    public void setStage(String stage) {
        Stage = stage;
    }

}


