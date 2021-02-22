package model;

public class And extends LogicElement {

    public And(int size) {
        super(size);
    }

    @Override
    protected boolean operation(boolean b1, boolean b2) {
        return b1&&b2;
    }

}
