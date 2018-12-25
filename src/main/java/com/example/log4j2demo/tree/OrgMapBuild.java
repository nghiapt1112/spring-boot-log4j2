package com.example.log4j2demo.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class OrgMapBuild {
    @JsonIgnore
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public Org buildTreeV2(ArrayList<Org> orgs) {
        HashMap<LinkedList<String>, List<Org>> groupByLevel = new HashMap<>();
        Org root = null;
        for (Org el : orgs) {
            // TODO: check duplicate root
            if (CollectionUtils.isEmpty(el.parentIds)) {
                root = el;
                continue;
            }
            LinkedList<String> K = el.getParentIds();
            List<Org> V = groupByLevel.get(K);

            if (Objects.isNull(V)) {
                V = new ArrayList<>();
            }
            // TODO: can order here to ordered input, ex order children in same level. Which one is brother.
            V.add(el);
            groupByLevel.put(K, V);
        }
        this.appendV2(root, groupByLevel);


        return root;
    }

    private void appendV2(Org org, Map<LinkedList<String>, List<Org>> multiOrgByLevel) {
        LinkedList<String> currentPath = org.getParentIds();
        currentPath.add(org.id);

        List<Org> val = multiOrgByLevel.get(currentPath);
        if (Objects.isNull(val)) {
            return;
        }
        org.children.addAll(val);

        for (Org childChild : org.children) {
            appendV2(childChild, multiOrgByLevel);
        }
    }
}
