package factory;

import model.LogicElement;
import model.Xor;

public class XorElementFactory implements ElementFactoryI {
    @Override
    public LogicElement newInstance(int size) {
        return new Xor(size);
    }
}
