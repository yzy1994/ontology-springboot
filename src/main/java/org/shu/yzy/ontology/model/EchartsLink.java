package org.shu.yzy.ontology.model;

import lombok.Data;

@Data
public class EchartsLink {
    String source;

    String target;

    String value;

    String[] symbol;

    Integer[] symbolSize;

    public EchartsLink(String source, String target, String value, String[] symbol, Integer[] symbolSize) {
        this.source = source;
        this.target = target;
        this.value = value;
        this.symbol = symbol;
        this.symbolSize = symbolSize;
    }
}
