package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Dog;
import com.redi.j2.proxies.Elephant;
import com.redi.j2.proxies.Mammal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step2Tests {

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
    void task_2_1_0_shouldCreateTheMammalClass() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if it exists

        // then - it should exist
        assertTrue(m.existsClass(), "Mammal class is not defined");
    }

    @Test
    void task_2_1_1_shouldExtendAnimal() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if it extends the Animal class

        // then - it should
        assertTrue(m.extendsClass("com.redi.j2.Animal"), "Mammal class must extend from Animal");
    }

    @Test
    void task_2_1_2_shouldHaveMaxBabiesProperty() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if the maxBabies property exists

        // then - it should exist
        assertTrue(m.hasProperty("maxBabies"), "Variable 'maxBabies' is not defined");

        // and - it should be of type int
        assertTrue(m.isPropertyOfType("maxBabies", int.class), "Variable 'maxBabies' should be of type int");

        // and - it should be final
        assertTrue(m.isPropertyPrivate("maxBabies"), "Variable 'maxBabies' must be private");

        // and - it should be final
        assertTrue(m.isPropertyFinal("maxBabies"), "Variable 'maxBabies' must be final");
    }

    @Test
    void task_2_1_3_shouldHaveParameterizedConstructor() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal(56);

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(m.hasConstructor(int.class), "Class Mammal must have a constructor that receives an int as a parameter");

        // and - it should have set the blood type to 'WARM'
        assertEquals(BloodType.WARM, m.getBloodType(), "Blood type is not being set to WARM. Please call the constructor from the superclass with the right parameter.");

        // and - it should set the attribute to the proper value
        assertEquals(56, (int) m.getPropertyValue("maxBabies"), "Variable 'maxBabies' is not initialized properly inside the constructor");
    }

    @Test
    void task_2_1_4_shouldCreateGetMaxBabiesMethod() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal(15);

        // when - we check if the getter is correctly implemented

        // then - it should exist
        assertTrue(m.hasMethod("getMaxBabies"), "Property 'maxBabies' must have a getter called 'getMaxBabies'");
        assertTrue(m.isMethodReturnType(int.class, "getMaxBabies"), "Method 'getMaxBabies' must return int");

        // and - it should return the value from the property
        assertEquals((int)m.getPropertyValue("maxBabies"), m.getMaxBabies(), "Method getMaxBabies must return the value from the maxBabies variable");

        // and - it should NOT have a setter
        assertFalse(m.hasMethod("setMaxBabies", int.class), "Property 'maxBabies' should NOT have a setter");
    }

    @Test
    void task_2_1_5_shouldImplementWalkMethod() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we check if it has the method
        m.walk();

        // then - it should exist
        assertTrue(m.hasMethod("walk"), "Needs to implement the 'walk' method");

        // and - it should have the proper return type
        assertTrue(m.isMethodReturnType(void.class, "walk"), "Method 'walk' must return void");

        // and - it should print what is expected in the output
        assertEquals("going for a walk", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_1_6_A_shouldImplementGiveBirthMethod() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if it has the method
        Integer children = m.giveBirth();

        // then - it should exist
        assertTrue(m.hasMethod("giveBirth"), "Needs to implement the 'giveBirth' method");

        // and - it should have the proper return type
        assertTrue(m.isMethodReturnType(int.class, "giveBirth"), "Method 'giveBirth' must return int");
    }

    @Test
    void task_2_1_6_B_shouldUseRandomValues() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal(100);

        // and - the result of running the method for the first time
        Integer firstBirthResult = m.giveBirth();

        // and - a control flag to check if the result was ever different from the first time
        boolean changedAtLeastOnce = false;

        // when - we give birth a couple of times
        for (int i = 0; i < 100; i++) {
            if (firstBirthResult != m.giveBirth()) {
                changedAtLeastOnce = true;
                break;
            }
        }

        // then - the result must have changed at least once
        assertTrue(changedAtLeastOnce, "The method 'giveBirth' always returns the same number: "+firstBirthResult);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 10, 100 })
    void task_2_1_6_C_shouldObeyBirthLimits(int maxBabies) {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal(maxBabies);

        // when - we give birth a couple of times
        for (int i = 0; i < 100; i++) {
            Integer children = m.giveBirth();

            assertNotNull(children, "Number of children is not correct when maxBabies is "+maxBabies);

            // then - the number of children needs to be at least one
            assertTrue(children > 0, "Number of children less than one ("+children+") when maxBabies is "+maxBabies);

            // and - the number of children cannot exceed maxBabies
            assertTrue(children <= maxBabies, "Number of children too big ("+children+") with maxBabies is "+maxBabies);
        }
    }

    @Test
    void task_2_2_0_shouldCreateTheDogClass() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if it exists

        // then - it should exist
        assertTrue(d.existsClass(), "Dog class is not defined");
    }

    @Test
    void task_2_2_1_shouldExtendMammal() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if it extends the Mammal class

        // then - it should
        assertTrue(d.extendsClass("com.redi.j2.Mammal"), "Dog class must extend from Mammal");
    }

    @Test
    void task_2_2_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(d.hasConstructor(), "Class Dog must have a default (no-param) constructor");

        // and - it should have set the maxBabies to '24'
        assertEquals(24, d.getMaxBabies(), "MaxBabies is not being set to 24. Please call the constructor from the superclass with the right parameter.");
    }

    @Test
    void task_2_2_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("woof woof", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_2_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.eat();

        // then - it should print what is expected in the output
        assertEquals("This bone is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_3_0_shouldCreateTheElephantClass() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if it exists

        // then - it should exist
        assertTrue(e.existsClass(), "Elephant class is not defined");
    }

    @Test
    void task_2_3_1_shouldExtendMammal() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if it extends the Mammal class

        // then - it should
        assertTrue(e.extendsClass("com.redi.j2.Mammal"), "Elephant class must extend from Mammal");
    }

    @Test
    void task_2_3_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(e.hasConstructor(), "Class Elephant must have a default (no-param) constructor");

        // and - it should have set the maxBabies to '24'
        assertEquals(2, e.getMaxBabies(), "MaxBabies is not being set to 2. Please call the constructor from the superclass with the right parameter.");
    }

    @Test
    void task_2_3_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        e.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("bahruuuuuuhhhhaaaaa", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_3_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        e.eat();

        // then - it should print what is expected in the output
        assertEquals("This hay is delicious", out.toString().trim(), "The method should print the correct message");
    }
}
