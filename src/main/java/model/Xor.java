package model;

public class Xor extends LogicElement {
    public Xor(int size) {
        super(size);
    }

    @Override
    protected boolean operation(boolean b1, boolean b2) {
        return b1^b2;
    }
}
