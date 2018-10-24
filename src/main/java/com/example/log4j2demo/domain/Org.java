package com.example.log4j2demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Org {
    @JsonIgnore
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String id;
    private LinkedList<String> parentIds;
    private LinkedList<Org> children = new LinkedList<>();

    public LinkedList<String> getParentIds() {
        return parentIds;
    }

    public String getParentIdsAsString() {
        return this.parentIds.stream().collect(Collectors.joining(","));
    }

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
                && (this.parentIds.getLast().equals(superNode.id));
    }

    public Org getRoot(List<Org> elements) {
        return elements.stream()
                .filter(el -> CollectionUtils.isEmpty(el.parentIds))
                .findFirst().orElse(null);
    }

    //TODO: Sorting by increase of parentIds.
    private List<Org> sortByLevel(List<Org> liOrg) {
        liOrg.sort((e1, e2) -> compareByLevel(e1.parentIds, e2.parentIds));
        return liOrg;
    }

    private int compareByLevel(LinkedList<String> e1, LinkedList<String> e2) {
        if (e1.size() > e2.size()) {
            return 1;
        }
        if (e1.size() < e2.size()) {
            return -1;
        }
        return 0;
    }

    private void childAppend(Org org) {
        if (CollectionUtils.isEmpty(this.children)) {
            this.children = new LinkedList<>();
        }
        this.children.addLast(org);
    }


    private Map<LinkedList<String>, List<Org>> groupByLevel(ArrayList<Org> orgs) {
//        Map<LinkedList<String>, List<Org>> groupByLevel = orgs.stream().collect(Collectors.groupingBy(el -> el.parentIds));
        SortedMap<LinkedList<String>, List<Org>> groupByLevel = new TreeMap<>();
        Org root = null;
        for (Org el : orgs) {
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

        List<LinkedList<String>> sortedKeys = groupByLevel.keySet()
                .stream()
                .sorted((e1, e2) -> compareByLevel(e1, e2))
                .collect(Collectors.toList());



        for (int i = 2; i < sortedKeys.size(); i++) {

        }
        orgs.clear();
        return groupByLevel;
    }

    private void buildTreeByMap(Map<LinkedList<String>, List<Org>> multiOrgByLevel) {
//        multiOrgByLevel.entrySet().stream().sorted((e1, e2) -> compareByLevel(e1,e2))


        for (Map.Entry entry : multiOrgByLevel.entrySet()) {

        }
    }
}
