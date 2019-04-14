package org.shu.yzy.ontology.model;

import lombok.Data;

import java.util.List;

@Data
public class EchartsData {
    List<EchartsLink> echartsLinkList;

    List<EchartsNode> echartsNodeList;
}
