package factory;

import model.And;
import model.LogicElement;
import model.Or;
import model.Xor;

public class SimpleLogicElementFactory {
    public static LogicElement newInstance(LogicElementEnum elementEnum, int size){
        if (elementEnum == LogicElementEnum.AND)
            return new And(size);
        else if (elementEnum == LogicElementEnum.OR)
            return new Or(size);
        else if (elementEnum == LogicElementEnum.XOR)
            return new Xor(size);
        else
            return null;
    }
}
