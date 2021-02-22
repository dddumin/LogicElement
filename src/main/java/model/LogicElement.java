package model;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class LogicElement implements Comparable<LogicElement> {
    private boolean[] inputValues;

    public LogicElement(int size) {
        this.inputValues = new boolean[size];
    }

    public void fill(boolean  ... values){
        if (values.length < this.inputValues.length)
            throw new IllegalArgumentException("The number of arguments is less than the length of the original array!!!");
        System.arraycopy(values, 0, this.inputValues, 0, this.inputValues.length);
    }

    public int getLength(){
        return this.inputValues.length;
    }

    public boolean[] getInputValues(){
        return Arrays.copyOf(this.inputValues, this.inputValues.length);
    }

    protected abstract boolean operation(boolean b1, boolean b2);

    public boolean result(){
        boolean result = this.inputValues[0];
        for (int i = 1; i < this.inputValues.length; i++) {
            result = this.operation(result, this.inputValues[i]);
        }
        return result;
    }

    public LogicElement union(LogicElement element){
        if (this.getClass() != element.getClass())
            throw new ClassCastException("Item types do not match");
        try {
            LogicElement logicElement = this.getClass().getConstructor(int.class).newInstance(this.inputValues.length + element.getLength());
            boolean[] mass = new boolean[this.inputValues.length + element.getLength()];
            System.arraycopy(this.inputValues, 0, mass, 0, this.inputValues.length);
            System.arraycopy(element.getInputValues(), 0, mass, this.inputValues.length, element.getLength());
            logicElement.fill(mass);
            return logicElement;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int compareTo(LogicElement o) {
        return Integer.compare(this.inputValues.length, o.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicElement that = (LogicElement) o;
        return Arrays.equals(inputValues, that.inputValues);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(inputValues);
    }

    @Override
    public String toString() {
        return "Class Name: " + this.getClass().getSimpleName() + "; Input Values: " + Arrays.toString(this.inputValues) + "; Out Value: " + this.result();
    }
}
