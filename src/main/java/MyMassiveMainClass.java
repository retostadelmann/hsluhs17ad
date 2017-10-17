
import ch.hslu.ad.sw03.ExampleTree;
import ch.hslu.ad.sw03.ITree;
import ch.hslu.ad.sw04.ExampleHashSet;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author reto.stadelmann
 */
public class MyMassiveMainClass {

    static Logger LOG = LogManager.getLogger(MyMassiveMainClass.class);

    public static void main(final String[] args) {
        ExampleHashSet ehs = new ExampleHashSet(20);
        ehs.add(9);
    }
}
