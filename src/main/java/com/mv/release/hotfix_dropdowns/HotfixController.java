package com.mv.release.hotfix_dropdowns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class HotfixController {

    @Autowired
    HotfixRepository repoh;

    @PostMapping("/hotfix/populate")
    @CrossOrigin
    public Optional popu(@RequestBody hotfix_entity hot){
        repoh.save(hot);
        return repoh.findById(hot.getSl_no());
    }


        /*
    private Long sl_no;
    private String pod;
    private String impact_areas;
    private String impact;
    private String release_status;
    private String approved_by;
    private String type_of_release;
     */

    @GetMapping("/hotfix/dropdowns")
    @CrossOrigin
    public hotfix poddata(){
        /*
            private Long sl_no;
    private String pod;
    private String impact_areas;
    private String impact;
    private String release_status;
    private String approved_by;
    private String type_of_release;
         */
        List<Object> pod = repoh.pod();
        pod.removeAll(Collections.singletonList(null));
        List<Object> impact_areas = repoh.impact_areas();
        impact_areas.removeAll(Collections.singletonList(null));
        List<Object> impact = repoh.impact();
        impact.removeAll(Collections.singletonList(null));
        List<Object> release_status = repoh.release_status();
        release_status.removeAll(Collections.singletonList(null));
        List<Object> appoved_by = repoh.approved_by();
        appoved_by.removeAll(Collections.singletonList(null));
        List<Object> type_of_release = repoh.type_of_release();
        type_of_release.removeAll(Collections.singletonList(null));
        List<Object> type_of_release3 = repoh.type_of_release3();
        type_of_release3.removeAll(Collections.singletonList(null));

        hotfix h = new hotfix(pod, impact_areas, impact, release_status, appoved_by, type_of_release,type_of_release3);

        return h;

    }

}
