package factory;

import model.LogicElement;
import model.Or;

public class OrElementFactory implements ElementFactoryI {
    @Override
    public LogicElement newInstance(int size) {
        return new Or(size);
    }
}
