package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Animal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step1Tests {

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
    void task_1_1_shouldCreateTheAnimalClass() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if it exists

        // then - it should exist
        assertTrue(a.existsClass(), "Animal class is not defined");
    }

    @Test
    void task_1_2_shouldHaveBloodTypeProperty() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if the bloodType property exists

        // then - it should exist
        assertTrue(a.hasProperty("bloodType"), "Variable 'bloodType' is not defined");

        // and - it should be of type int
        assertTrue(a.isPropertyOfType("bloodType", BloodType.class), "Variable 'bloodType' is not of type BloodType");

        // and - it should be final
        assertTrue(a.isPropertyPrivate("bloodType"), "Variable 'bloodType' must be private");

        // and - it should be final
        assertTrue(a.isPropertyFinal("bloodType"), "Variable 'bloodType' must be final");
    }

    @ParameterizedTest
    @EnumSource(BloodType.class)
    void task_1_3_shouldHaveParameterizedConstructor(BloodType bloodType) {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal(bloodType);

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(a.hasConstructor(BloodType.class), "Class Animal must have a constructor that receives the BloodType as a parameter");

        // and - it should set the attribute to the proper value
        assertEquals(bloodType, a.getPropertyValue("bloodType"), "Variable 'bloodType' is not initialized properly inside the constructor");
    }

    @ParameterizedTest
    @EnumSource(BloodType.class)
    void task_1_4_shouldCreateGetBloodTypeMethod(BloodType bloodType) {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal(bloodType);

        // when - we check if the getter is correctly implemented

        // then - it should exist
        assertTrue(a.hasMethod("getBloodType"), "Property 'bloodType' must have a getter called 'getBloodType'");
        assertTrue(a.isMethodReturnType(BloodType.class, "getBloodType"), "Method 'getBloodType' must return BloodType");

        // and - it should return the value from the property
        assertEquals(a.getPropertyValue("bloodType"), a.getBloodType(), "Method getBloodType must return the value from the bloodType variable");

        // and - it should NOT have a setter
        assertFalse(a.hasMethod("setBloodType", BloodType.class), "Property 'bloodType' should NOT have a setter");
    }

    @Test
    void task_1_5_shouldImplementEatMethod() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we check if it has the method
        a.eat();

        // then - it should exist
        assertTrue(a.hasMethod("eat"), "Needs to implement the 'eat' method");

        // and - it should have the proper return type
        assertTrue(a.isMethodReturnType(void.class, "eat"), "Method 'eat' must return void");

        // and - it should print what is expected in the output
        assertEquals("chomp chomp", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_1_6_shouldImplementMakeNoiseMethod() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we check if it has the method
        a.makeNoise();

        // then - it should exist
        assertTrue(a.hasMethod("makeNoise"), "Needs to implement the 'makeNoise' method");

        // and - it should have the proper return type
        assertTrue(a.isMethodReturnType(void.class, "makeNoise"), "Method 'makeNoise' must return void");

        // and - it should print what is expected in the output
        assertEquals("making some noise", out.toString().trim(), "The method should print the correct message");
    }
}
