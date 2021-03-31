package com.mv.release.daily_dropdowns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class dailyController {

    @Autowired
    daily_repository repod;

    @PostMapping("/daily/populate")
    @CrossOrigin
    public Optional populate(@RequestBody daily_table dai){
        repod.save(dai);
        return repod.findById(dai.getSl_no());
    }

    @GetMapping(value = "/release_status")
    @CrossOrigin
    public List<Object> finddata() {
        List<Object> release_status = repod.findrelease_status();
        return release_status;
    }

    @GetMapping(value = "/daily/dropdowns")
    @CrossOrigin
    public daily senddata(){
        /*
            @Column(nullable = true)
    private String type_of_release;
    @Column(nullable = true)
    private String impact;
    @Column(nullable = true)
    private String impact_areas;
    @Column(nullable = true)
    private String release_type;

    private String release_status;

         */

        List<Object> pod= repod.findpod();
        pod.removeAll(Collections.singletonList(null));
        List<Object> branch_name = repod.findbranch_name();
        branch_name.removeAll(Collections.singletonList(null));
        List<Object> generic = repod.findgenerics();
        generic.removeAll(Collections.singletonList(null));
        List<Object> sql_queries_approval = repod.findsql_queries_approval();
        sql_queries_approval.removeAll(Collections.singletonList(null));
        List<Object> release_status = repod.findrelease_status();
        release_status.removeAll(Collections.singletonList(null));
        List<Object> release_type = repod.findrelease_type();
        release_type.removeAll(Collections.singletonList(null));
        List<Object> impact_areas = repod.findimpactareas();
        impact_areas.removeAll(Collections.singletonList(null));
        List<Object> impact = repod.findimpact();
        impact.removeAll(Collections.singletonList(null));
        List<Object> type_of_release = repod.findtyperelease();
        type_of_release.removeAll(Collections.singletonList(null));

        daily d = new daily(pod, branch_name,generic,sql_queries_approval,release_status,release_type,impact_areas
                ,impact,type_of_release);
        return d;
    }
}