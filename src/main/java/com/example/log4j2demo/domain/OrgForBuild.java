package com.example.log4j2demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class OrgForBuild {
    @JsonIgnore
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());




    public Org buildTree(List<Org> orgs) {
        List<Org> sortedOrgList = this.sortByLevel(orgs);
//        Org root = this.getRoot(sortedOrgList);
        Org root = sortedOrgList.get(0);
        if (Objects.isNull(root)) {
            LOGGER.warn("Root is null");
        }
        this.buildFirstNode(root, sortedOrgList);
        for (Org childLevelOne : root.children) {
            this.appendNode(sortedOrgList, childLevelOne, 1);
        }
        return root;
    }


    private void buildFirstNode(Org root, List<Org> elements) {
        for (int i = 1; i < elements.size(); i++) {
            Org el = elements.get(i);
            if (el.parentIds.size() == 1) {
//                el.parentIds.add(root.id);
                root.childAppend(el);
            } else if (el.parentIds.size() > 1) {
                break;
            }
        }
    }

    private void appendNode(List<Org> sortedOrgList, Org currentNode, int index) {
        if (index > sortedOrgList.size()) {
            // out of bound.
            LOGGER.warn("index is reach with size of list\n, index:{}\nsize:{}", index, sortedOrgList.size());
            return;
        }
        int lastIndex = 0;
        for (int i = index; i < sortedOrgList.size(); i++) {

            // Tr][fng hop ma truyen vao 0 thi tru di no cung = 1
            Org e = sortedOrgList.get(i);
            if (Objects.isNull(e)) {
                LOGGER.warn("\n===============Current object is null, please check data.===============");
                break;
            }
            if (e.isDeeperThanChildOf(currentNode)) {
                lastIndex = i;
                break;
            }
            // TODO: only take elements in next level, more than one will be execute in recursive loop.
            if (e.isChildOf(currentNode)) {
//                e.parentIds.add(currentOrg.id);
                currentNode.childAppend(e);
            }
        }


        for (Org child : currentNode.children) {
            appendNode(sortedOrgList, child, lastIndex);
        }

    }

    //TODO: Sorting by increase of parentIds.
    public List<Org> sortByLevel(List<Org> liOrg) {
        liOrg.sort((e1, e2) -> compareByLevel(e1.parentIds, e2.parentIds));
        return liOrg;
    }

    public int compareByLevel(LinkedList<String> e1, LinkedList<String> e2) {
        if (e1.size() > e2.size()) {
            return 1;
        }
        if (e1.size() < e2.size()) {
            return -1;
        }
        return 0;
    }

}
