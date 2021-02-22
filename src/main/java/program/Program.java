package program;

import factory.AndElementFactory;
import factory.ElementFactoryI;
import factory.OrElementFactory;
import factory.XorElementFactory;
import model.And;
import model.LogicElement;
import model.Or;
import model.Xor;
import repository.ElementRepository;
import util.Elements;

import java.io.IOException;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        LogicElement and = new And(3);
        and.fill(true, false, false);
        System.out.println(and);

        /*LogicElement and1 = new And(4);
        and1.fill(true,true,true, true);
        System.out.println(and1.result());

        LogicElement and2 = and.union(and1);
        System.out.println(and2);
        System.out.println(and2.result());

        LogicElement or = new Or(4);
        and1.fill(true,true,true, true);


        LogicElement union = Elements.union(and, and1, and2, or);
        System.out.println(union);*/

        try {
            //ElementRepository repository = new ElementRepository("file.csv");
            //System.out.println(repository);

            HashMap<String, ElementFactoryI> map = new HashMap<>();
            map.put("AND", new AndElementFactory());
            map.put("OR", new OrElementFactory());
            map.put("XOR", new XorElementFactory());
            ElementRepository repository1 = new ElementRepository("file.csv", map);
            System.out.println(repository1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
