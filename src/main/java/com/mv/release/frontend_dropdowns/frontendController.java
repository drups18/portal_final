package com.mv.release.frontend_dropdowns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class frontendController {
    @Autowired
    FrontendRepository repof;

    @PostMapping("/frontend/populate")
    @CrossOrigin
    public Optional popu(@RequestBody frontend_dropdown front){
        repof.save(front);
        return repof.findById(front.getSl_no());
    }


    @GetMapping("/frontend/dropdowns")
    @CrossOrigin
    public frontend poddata(){
/*
    private Long sl_no;
    private String platform;
    private String impact;
    private String impact_areas;
    private String release_type;
 */
        List<Object> platform = repof.getplatform();
        platform.removeAll(Collections.singletonList(null));
        List<Object> impact = repof.getimpact();
        impact.removeAll(Collections.singletonList(null));
        List<Object> impact_areas = repof.getimpact_areas();
        impact_areas.removeAll(Collections.singletonList(null));
        List<Object> release_type = repof.getrelease_type();
        release_type.removeAll(Collections.singletonList(null));

        frontend f = new frontend(platform,impact,impact_areas,release_type);

        return f;

    }
}
