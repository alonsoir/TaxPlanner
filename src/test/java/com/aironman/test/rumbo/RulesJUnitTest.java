package com.aironman.test.rumbo;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;

import com.aironman.test.rumbo.misc.Utilities;
import com.aironman.test.rumbo.model.Order;

/**
 *
 * @author aironman
 */
@RunWith(Arquillian.class)
public class RulesJUnitTest {

	public RulesJUnitTest() {
	}

	@Deployment
	public static JavaArchive createDeployment() {

		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Inject
	@KSession
	private KieSession kSession;

	@Test
	public void hello() {
		Assert.assertNotNull(kSession);
		kSession.insert("Hi There From Test!");
		Assert.assertEquals(1, kSession.fireAllRules());
	}

	@Test
	public void should_apply_rules_to_order1_exempted_imported_not_imported() {
		// GIVEN
		Assert.assertNotNull(kSession);
		final Order order1 = Utilities.createOrder1();
		// WHEN
		kSession.insert(order1);
		kSession.fireAllRules();
		// THEN
		System.out.println("order1 after apply rules: " + order1.toString());
		Assert.assertEquals("Shoud be equals...", 29.83d, order1.getTotalPrize(), 0.05d);
		Assert.assertEquals("Shoud be equals...", 1.50d, order1.getTotalTaxes(), 0.05d);
	}

	@Test
	public void should_apply_rules_to_order2_exempetd_imported_not_imported() {
		// GIVEN
		Assert.assertNotNull(kSession);

		final Order order2 = Utilities.createOrder2();
		// WHEN

		kSession.insert(order2);
		kSession.fireAllRules();
		// THEN
		System.out.println("order2 after apply rules: " + order2.toString());
		Assert.assertEquals("Shoud be equals...", 65.15d, order2.getTotalPrize(), 0.05d);
		Assert.assertEquals("Shoud be equals...", 7.65d, order2.getTotalTaxes(), 0.05d);
	}

	@Test
	public void should_apply_rules_to_order3_exented_and_imported_not_exempted_imported_exempted_not_imported_not_exempted_not_imported() {
		// GIVEN 
		Assert.assertNotNull(kSession); 
		final Order order3 =Utilities.createOrder3(); 
		kSession.insert(order3);
		kSession.fireAllRules();
		// THEN 
		System.out.println("order3 after apply rules: " + order3.toString());
		Assert.assertEquals("Shoud be equals...", 74.68d, order3.getTotalPrize(), 0.05d);
		Assert.assertEquals("Shoud be equals...", 6.70d, order3.getTotalTaxes(), 0.05d);
	}

}
