package com.example.log4j2demo.domain;

import com.nghia.libraries.commons.mss.utils.JsonUtils;

import java.util.LinkedList;
import java.util.List;

public class Org {

    private List<String> parentIds;
    private String name;
    private LinkedList<Org> children;

    public Org createRoot(){
        return new Org();
    }

    public void addChild(Org child) {

    }

    public void build(List<Org> elements) {
        JsonUtils.toJson(null);
        int level = 0;

        //TODO: Sorting by increase of parentIds.


        for (Org el : elements){
            // first level
            if (el.parentIds.size() == 1 ) {
                
            }
        }
    }
}
