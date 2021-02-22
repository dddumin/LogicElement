package factory;

import model.LogicElement;

public interface ElementFactoryI {
    LogicElement newInstance(int size);
}
