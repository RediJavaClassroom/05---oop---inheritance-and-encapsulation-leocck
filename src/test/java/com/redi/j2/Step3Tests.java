package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Salmon;
import com.redi.j2.proxies.Shark;
import com.redi.j2.proxies.Fish;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream setUpStream() {
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void task_3_1_0_shouldCreateTheFishClass() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish();

        // when - we check if it exists

        // then - it should exist
        assertTrue(m.existsClass(), "Fish class is not defined");
    }

    @Test
    void task_3_1_1_shouldExtendAnimal() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish();

        // when - we check if it extends the Animal class

        // then - it should
        assertTrue(m.extendsClass("com.redi.j2.Animal"), "Fish class must extend from Animal");
    }

    @Test
    void task_3_1_2_shouldHaveMaxEggsProperty() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish();

        // when - we check if the maxEggs property exists

        // then - it should exist
        assertTrue(m.hasProperty("maxEggs"), "Variable 'maxEggs' is not defined");

        // and - it should be of type int
        assertTrue(m.isPropertyOfType("maxEggs", int.class), "Variable 'maxEggs' should be of type int");

        // and - it should be final
        assertTrue(m.isPropertyPrivate("maxEggs"), "Variable 'maxEggs' must be private");

        // and - it should be final
        assertTrue(m.isPropertyFinal("maxEggs"), "Variable 'maxEggs' must be final");
    }

    @Test
    void task_3_1_3_shouldHaveParameterizedConstructor() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish(56);

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(m.hasConstructor(int.class), "Class Fish must have a constructor that receives an int as a parameter");

        // and - it should have set the blood type to 'COLD'
        assertEquals(BloodType.COLD, m.getBloodType(), "Blood Type is not being set to COLD. Please call the constructor from the superclass with the right parameter.");

        // and - it should set the attribute to the proper value
        assertEquals(56, (int) m.getPropertyValue("maxEggs"), "Variable 'maxEggs' is not initialized properly inside the constructor");
    }

    @Test
    void task_3_1_4_shouldCreateGetMaxEggsMethod() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish(15);

        // when - we check if the getter is correctly implemented

        // then - it should exist
        assertTrue(m.hasMethod("getMaxEggs"), "Property 'maxEggs' must have a getter called 'getMaxEggs'");
        assertTrue(m.isMethodReturnType(int.class, "getMaxEggs"), "Method 'getMaxEggs' must return int");

        // and - it should return the value from the property
        assertEquals((int)m.getPropertyValue("maxEggs"), m.getMaxEggs(), "Method getMaxEggs must return the value from the maxEggs variable");

        // and - it should NOT have a setter
        assertFalse(m.hasMethod("setMaxEggs", int.class), "Property 'maxEggs' should NOT have a setter");
    }

    @Test
    void task_3_1_5_shouldImplementSwimMethod() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we check if it has the method
        m.swim();

        // then - it should exist
        assertTrue(m.hasMethod("swim"), "Needs to implement the 'swim' method");

        // and - it should have the proper return type
        assertTrue(m.isMethodReturnType(void.class, "swim"), "Method 'swim' must return void");

        // and - it should print what is expected in the output
        assertEquals("keep on swimming", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_3_1_6_A_shouldImplementLayEggsMethod() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish();

        // when - we check if it has the method
        Integer eggs = m.layEggs();

        // then - it should exist
        assertTrue(m.hasMethod("layEggs"), "Needs to implement the 'layEggs' method");

        // and - it should have the proper return type
        assertTrue(m.isMethodReturnType(int.class, "layEggs"), "Method 'layEggs' must return int");
    }

    @Test
    void task_3_1_6_B_shouldUseRandomValues() {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish(100);

        // and - the result of running the method for the first time
        Integer firstEggsResult = m.layEggs();

        // and - a control flag to check if the result was ever different from the first time
        boolean changedAtLeastOnce = false;

        // when - we give birth a couple of times
        for (int i = 0; i < 100; i++) {
            if (firstEggsResult != m.layEggs()) {
                changedAtLeastOnce = true;
                break;
            }
        }

        // then - the result must have changed at least once
        assertTrue(changedAtLeastOnce, "The method 'layEggs' always returns the same number: "+firstEggsResult);
    }

    @ParameterizedTest(name = "task_3_1_6_C_shouldHaveEggsLimits_{0}")
    @ValueSource(ints = { 1, 10, 100 })
    void task_3_1_6_C_shouldHaveEggsLimits(int maxEggs) {

        // given - the class we want the students to implement
        Fish m = Fixtures.createFish(maxEggs);

        // when - we lay eggs for a couple of times
        for (int i = 0; i < 100; i++) {
            Integer eggs = m.layEggs();

            assertNotNull(eggs, "Number of eggs is not correct when maxEggs is "+maxEggs);

            // then - the number of eggs needs to be at least one
            assertTrue(eggs > 0, "Number of eggs less than one ("+eggs+") when maxEggs is "+maxEggs);

            // and - the number of eggs cannot exceed maxEggs
            assertTrue(eggs <= maxEggs, "Number of eggs too big ("+eggs+") with maxEggs is "+maxEggs);
        }
    }

    @Test
    void task_3_2_0_shouldCreateTheSalmonClass() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // when - we check if it exists

        // then - it should exist
        assertTrue(d.existsClass(), "Salmon class is not defined");
    }

    @Test
    void task_3_2_1_shouldExtendFish() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // when - we check if it extends the Fish class

        // then - it should
        assertTrue(d.extendsClass("com.redi.j2.Fish"), "Salmon class must extend from Fish");
    }

    @Test
    void task_3_2_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(d.hasConstructor(), "Class Salmon must have a default (no-param) constructor");

        // and - it should have set the maxEggs to '2800'
        assertEquals(2800, d.getMaxEggs(), "MaxEggs is not being set to 2800. Please call the constructor from the superclass with the right parameter.");
    }

    @Test
    void task_3_2_3_shouldOverrideLayEggsMethod() {

        // given - a salmon
        Salmon d = Fixtures.createSalmon();

        // when - it lays eggs for the first time
        Integer eggs = d.layEggs();

        // then - it should have the same behaviour from the parent class
        assertNotNull(eggs, "Lay Eggs function is not implemented correctly");
        assertTrue(eggs > 0, "Number of eggs less than one ("+eggs+") in the first time laying eggs");
        assertTrue(eggs <= 2800, "Number of eggs too big ("+eggs+") for a Salmon (maxEggs = 2800)");

        // and - if it lays eggs another time
        eggs = d.layEggs();

        // expect - the number of eggs to be zero
        assertEquals(0, eggs, "Salmons can lay eggs only once in their lifetime");
    }

    @Test
    void task_3_2_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.eat();

        // then - it should print what is expected in the output
        assertEquals("This small pray is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_3_3_0_shouldCreateTheSharkClass() {

        // given - the class we want the students to implement
        Shark e = Fixtures.createShark();

        // when - we check if it exists

        // then - it should exist
        assertTrue(e.existsClass(), "Shark class is not defined");
    }

    @Test
    void task_3_3_1_shouldExtendFish() {

        // given - the class we want the students to implement
        Shark e = Fixtures.createShark();

        // when - we check if it extends the Fish class

        // then - it should
        assertTrue(e.extendsClass("com.redi.j2.Fish"), "Shark class must extend from Fish");
    }

    @Test
    void task_3_3_2_shouldHaveIsOviparousProperty() {

        // given - the class we want the students to implement
        Shark m = Fixtures.createShark();

        // when - we check if the maxEggs property exists

        // then - it should exist
        assertTrue(m.hasProperty("isOviparous"), "Variable 'isOviparous' is not defined");

        // and - it should be of type int
        assertTrue(m.isPropertyOfType("isOviparous", boolean.class), "Variable 'isOviparous' should be of type boolean");

        // and - it should be final
        assertTrue(m.isPropertyPrivate("isOviparous"), "Variable 'isOviparous' must be private");

        // and - it should be final
        assertTrue(m.isPropertyFinal("isOviparous"), "Variable 'isOviparous' must be final");
    }

    @ParameterizedTest(name = "task_3_1_6_C_shouldHaveEggsLimits_{0}")
    @ValueSource(booleans = { true, false })
    void task_3_3_3_shouldHaveParameterizedConstructor(boolean isOviparous) {

        // given - the class we want the students to implement
        Shark m = Fixtures.createShark(isOviparous);

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(m.hasConstructor(boolean.class), "Class Shark must have a constructor that receives a boolean as a parameter");

        // and - it should have set the maxEggs property to 20
        assertEquals(20, m.getMaxEggs(), "Max Eggs is not being set to 20. Please call the constructor from the superclass with the right parameter.");

        // and - it should set the attribute to the proper value
        assertEquals(isOviparous, (boolean) m.getPropertyValue("isOviparous"), "Variable 'isOviparous' is not initialized properly inside the constructor");
    }

    @Test
    void task_3_3_4_A_shouldLayEggs() {

        // given - an oviparous shark
        Shark d = Fixtures.createShark(true);

        // when - it lays eggs a couple of times
        for (int i = 0; i < 100; i++) {
            Integer eggs = d.layEggs();

            assertNotNull(eggs, "Number of eggs is not correct when Shark is oviparous");

            // then - the number of eggs needs to be at least one
            assertTrue(eggs > 0, "Number of eggs less than one ("+eggs+") for an oviparous Shark");

            // and - the number of eggs cannot exceed maxEggs
            assertTrue(eggs <= 20, "Number of eggs too big ("+eggs+") for an oviparous Shark (maxEggs = 20)");
        }
    }

    @Test
    void task_3_3_4_B_shouldOverrideLayEggsMethod() {

        // given - an oviparous shark
        Shark d = Fixtures.createShark(false);

        // when - we try to make it lay eggs
        Integer eggs = d.layEggs();

        // then - it should not
        assertEquals(0, eggs, "The layEggs method must return zero if the Shark is not oviparous");
    }

    @Test
    void task_3_3_5_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Shark d = Fixtures.createShark();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.eat();

        // then - it should print what is expected in the output
        assertEquals("This human is delicious", out.toString().trim(), "The method should print the correct message");
    }
}
