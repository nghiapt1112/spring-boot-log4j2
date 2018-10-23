package com.example.log4j2demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Org {
    @JsonIgnore
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String id;
    private List<String> parentIds;
    private LinkedList<Org> children = new LinkedList<>();

    public Org buildTree(List<Org> orgs) {
        List<Org> sortedOrgList = this.sortByLevel(orgs);
        Org root = this.getRoot(sortedOrgList);
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

    private boolean isDeeperThanChildOf(Org currentNode) {
        return this.parentIds.size() - currentNode.parentIds.size() == 2;
    }

    private boolean isChildOf(Org superNode) {
        return (this.parentIds.size() - superNode.parentIds.size() == 1)
                && (this.parentIds.get(this.parentIds.size() - 1).equals(superNode.id));
    }

    public Org getRoot(List<Org> elements) {
        return elements.stream()
                .filter(el -> CollectionUtils.isEmpty(el.parentIds))
                .findFirst().orElse(null);
    }

    //TODO: Sorting by increase of parentIds.
    private List<Org> sortByLevel(List<Org> liOrg) {
        liOrg.sort((e1, e2) -> compareByLevel(e1, e2));
        return liOrg;
    }

    private int compareByLevel(Org e1, Org e2) {
        if (e1.parentIds.size() > e2.parentIds.size()) {
            return 1;
        }
        if (e1.parentIds.size() < e2.parentIds.size()) {
            return -1;
        }
        return 0;
    }

    private void childAppend(Org org) {
        if (CollectionUtils.isEmpty(this.children)) {
            this.children = new LinkedList<>();
        }
        this.children.add(org);
    }
}
