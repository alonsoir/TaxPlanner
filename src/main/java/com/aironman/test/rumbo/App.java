package com.aironman.test.rumbo;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import com.aironman.test.rumbo.misc.Utilities;
import com.aironman.test.rumbo.model.Order;

/**
 * @author aironman
 *
 */
public class App {

    @Inject
    @KSession
    private KieSession kSession;

    public void bootstrapDrools() {
        // The KieSession was injected so we can use it now
        kSession.insert("Hola Alonso! disparando reglas drools. Comprobando que el motor de reglas funciona.");
        Order order1 = Utilities.createOrder1();
        Order order2 = Utilities.createOrder2();
        Order order3 = Utilities.createOrder3();
        kSession.insert(order1);
        kSession.insert(order2);
        kSession.insert(order3);
        int rulesFired = kSession.fireAllRules();
        System.out.println(">>> Rules Fired: "+rulesFired);
        System.out.println("order1 after fired: " + order1.toString());
        System.out.println("order2 after fired: " + order2.toString());
        System.out.println("order3 after fired: " + order3.toString());
    }

    public static void main(String[] args) {
        //Boostrap the CDI container, in this case WELD
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        App app = wc.instance().select(App.class).get();
        app.bootstrapDrools();

        w.shutdown();
    }
    
    
    
}
