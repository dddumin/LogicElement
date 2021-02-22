package util;

import model.LogicElement;

public class Elements {
    public static LogicElement union (LogicElement ... logicElements){
        LogicElement logicElement = logicElements[0];
        for (int i = 1; i < logicElements.length; i++) {
            logicElement = logicElement.union(logicElements[i]);
        }
        return logicElement;
    }
}
