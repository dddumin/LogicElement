package factory;

import model.And;
import model.LogicElement;

public class AndElementFactory implements ElementFactoryI {
    @Override
    public LogicElement newInstance(int size) {
        return new And(size);
    }
}
