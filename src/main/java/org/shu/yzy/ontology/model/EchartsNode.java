package org.shu.yzy.ontology.model;

import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Data
public class EchartsNode{
    private final Integer MIN_LENGTH = 28;

    private final Integer PER_CHAR_LENGTH = 12;

    String name;

    Integer [] symbolSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EchartsNode that = (EchartsNode) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(symbolSize);
        return result;
    }

    public EchartsNode(String name) {
        this.name = name;
        this.symbolSize = new Integer[2];
        this.symbolSize[0] = MIN_LENGTH + this.name.length() * PER_CHAR_LENGTH;
        this.symbolSize[1] = MIN_LENGTH;
    }
}
