package com.example.log4j2demo.tree;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Org {

    public String id;
    public LinkedList<String> parentIds;
    public LinkedList<Org> children = new LinkedList<>();


    public boolean isDeeperThanChildOf(Org currentNode) {
        return this.parentIds.size() - currentNode.parentIds.size() == 2;
    }

    public boolean isChildOf(Org superNode) {
        return (this.parentIds.size() - superNode.parentIds.size() == 1)
                && (this.parentIds.getLast().equals(superNode.id));
    }

    public Org getRoot(List<Org> elements) {
        return elements.stream()
                .filter(el -> CollectionUtils.isEmpty(el.parentIds))
                .findFirst().orElse(null);
    }


    public void childAppend(Org org) {
        if (CollectionUtils.isEmpty(this.children)) {
            this.children = new LinkedList<>();
        }
        this.children.addLast(org);
    }


    public LinkedList<String> getParentIds() {
        return parentIds;
    }

    public String getParentIdsAsString() {
        return this.parentIds.stream().collect(Collectors.joining(","));
    }


}
