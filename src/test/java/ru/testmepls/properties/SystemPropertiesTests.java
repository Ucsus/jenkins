package ru.testmepls.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // null
    }

    @Test
    void simplePropertyTest1() {
        System.setProperty("browser", "chrome");
        String browserName = System.getProperty("browser");
        System.out.println(browserName); // chrome
    }

    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // firefox
    }

    @Test
    void simplePropertyTest3() {
        System.setProperty("browser", "chrome");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName); // chrome
    }

    @Test
    @Tag("one_property_test")
    void simplePropertyTest4() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
        // gradle clean one_property -Dbrowser=safari. В билде прописать systemProperties(System.getProperties())
        // safari
    }

    @Test
    @Tag("many_properties_test")
    void simplePropertyTest5() {
        String browserName = System.getProperty("browser", "firefox");
        String browserVersion = System.getProperty("browser version", "105");
        String browserSize = System.getProperty("browser size", "1920x1080");

        System.out.println(browserName); //
        System.out.println(browserVersion); //
        System.out.println(browserSize); //

        /*
        from IDEA
            firefox
            105
            1920x1080

        gradle clean many_properties
            firefox
            105
            1920x1080

        gradle clean many_properties -Dbrowser=safari
            safari
            105
            1920x1080
         */
    }

    @Test
    @Tag("hello")
    void simplePropertyTest6() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));
        /*
        gradle clean hello -Duser_name=Alex
            Hello. Alex

        gradle clean hello "-Duser_name=Alex Egorov"
        gradle clean hello -Duser_name="Alex Egorov"
            Hello, Alex Egorov
         */

    }
}
