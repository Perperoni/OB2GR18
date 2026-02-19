import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParentesSjekkerTest {
    private ParentesSjekker parentesSjekker = new ParentesSjekker();
    
    @Test
    void parentesSjekkerTest1() {
        String string1 = "{ [ ( ) ] }";
        assertTrue(parentesSjekker.sjekkParenteser(string1));
    }
    @Test
    void parentesSjekkerTest2() {
        String string2 = "{ [ ( ) }";
        assertFalse(parentesSjekker.sjekkParenteser(string2));
    }
    @Test
    void parentesSjekkerTest3() {
        String string3 = "[ ( ) ] }";
        assertFalse(parentesSjekker.sjekkParenteser(string3));
    }
    @Test
    void parentesSjekkerTest4() {
        String string4 = "{ [ ( ] ) }";
        assertFalse(parentesSjekker.sjekkParenteser(string4));
    }
    @Test
    void parentesSjekkerTestJavaProgram() {
        String javaprogram = " class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello World!\");}} ";
        assertTrue(parentesSjekker.sjekkParenteser(javaprogram));
    }
}
