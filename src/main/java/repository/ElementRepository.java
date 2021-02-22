package repository;

import factory.ElementFactoryI;
import factory.LogicElementEnum;
import factory.SimpleLogicElementFactory;
import model.LogicElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class ElementRepository {
    private ArrayList<LogicElement> logicElements;

    public ElementRepository(String fileName, Map<String, ElementFactoryI> factoryIMap) throws IOException {
        this.logicElements = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                try {
                    String[] data = reader.readLine().split(";");
                    boolean[] inputValues = new boolean[data.length - 1];
                    for (int i = 1; i < data.length; i++) {
                        if (!data[i].equals("true") && !data[i].equals("false"))
                            throw new ArrayIndexOutOfBoundsException();
                        inputValues[i-1] = Boolean.parseBoolean(data[i]);
                    }
                    LogicElement logicElement = factoryIMap.get(data[0]).newInstance(inputValues.length);
                    logicElement.fill(inputValues);
                    this.logicElements.add(logicElement);
                } catch (ArrayIndexOutOfBoundsException | NullPointerException ignored) {
                }
            }
        }
    }

    public ElementRepository(String fileName) throws IOException {
        this.logicElements = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                try {
                    String[] data = reader.readLine().split(";");
                    boolean[] inputValues = new boolean[data.length - 1];
                    for (int i = 1; i < data.length; i++) {
                        if (!data[i].equals("true") && !data[i].equals("false"))
                            throw new ArrayIndexOutOfBoundsException();
                        inputValues[i-1] = Boolean.parseBoolean(data[i]);
                    }
                    LogicElement logicElement = SimpleLogicElementFactory.newInstance(LogicElementEnum.valueOf(data[0]), inputValues.length);
                    logicElement.fill(inputValues);
                    this.logicElements.add(logicElement);
                } catch (ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException ignored) {
                }
            }
        }
    }

    public void sort(Comparator<LogicElement> comparator){
        this.logicElements.sort(comparator);
    }

    @Override
    public String toString() {
        String data = "";
        for (LogicElement element : this.logicElements) {
            data += element.toString() + "\r\n";
        }
        return "Logic Elements: \r\n" + data;
    }
}

