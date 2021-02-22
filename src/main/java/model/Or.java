package model;

public class Or extends LogicElement{
    public Or(int size) {
        super(size);
    }

    @Override
    protected boolean operation(boolean b1, boolean b2) {
        return b1||b2;
    }

}
