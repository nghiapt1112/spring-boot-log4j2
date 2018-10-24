package com.example.log4j2demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrgByMap {
    @JsonIgnore
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String id;
    private LinkedList<String> parentIds;
    private LinkedList<Org> children = new LinkedList<>();


    private MultiValuedMap groupByLevel(List<OrgByMap> x){


        return null;
    }
}
