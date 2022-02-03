package test;

import main.BalancedBrackets;
import org.junit.Before;
import org.junit.Test;

import static main.BalancedBrackets.hasBalancedBrackets;
import static org.junit.Assert.*;

public class BalancedBracketsTest {

    //TODO: add tests here
    String testString;
    String unbalncedString;
    String edgeCaseString;
    @Before
    public void createString(){
         testString=("[This] [[should contain 6 brackets]]");
         unbalncedString="]This[ [Should] [contain 6 brackets] as well";
         edgeCaseString="[[[[this string is balanced but nested]]]]";
    }


    //    has just brackets
    @Test
    public void testReturnOfBracketTest(){
    assertEquals(hasBalancedBrackets("[]"), true);
}

    //    original test, program counts the number of brackets. Test still passes with updates.
    @Test
    public void testReturnOfBalancedString(){
        assertEquals(hasBalancedBrackets(testString), true);
    }

    //    does program detected if bracket is out of place
    @Test
    public void unbalncedReturnsFalse() {
        assertFalse(BalancedBrackets.hasBalancedBrackets(unbalncedString));
    }

    //does program pass test with balanced string
    @Test
    public void onlyBracketsReturnsTrue() {
        assertTrue(BalancedBrackets.hasBalancedBrackets(testString));
    }

    //does program work for nested brackets?
    @Test
    public void nestedBracketsTest() {
        assertTrue(BalancedBrackets.hasBalancedBrackets(edgeCaseString));
    }

   // revers brackets return false
   @Test
   public void reverseBrackets(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("]["));
   }
//   test if odd number brackets fail
   @Test
    public void oddNumberBrackets(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("[]["));
   }
//   all opening brackets
    @Test
    public void allOpenBrackets(){
        assertFalse(BalancedBrackets.hasBalancedBrackets("[[[["));
    }
//    empty string return tru
    @Test
    public void emptyStringTrue(){
        assertTrue(BalancedBrackets.hasBalancedBrackets(" "));
    }
//    string no brackets returns true
    @Test
    public void stringNoBrackets(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("This is a test"));
    }
//    brackets within words
    @Test
    public void bracketWithinWord(){
        assertTrue(BalancedBrackets.hasBalancedBrackets("This i[s] a test"));
    }


}
