import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/** Class. */
public class CardholdersPart3AppTest {
/** First test. */
   @Test public void noFileName() {
      String[] args1 = {};
      CardholdersPart3App.main(args1);
      Assert.assertEquals("Empty String", args1.length, 0);
      
      CardholdersPart3App app = new CardholdersPart3App();
      
      String[] args2 = {"cardholder_data_1.txt"};
      CardholdersPart3App.main(args2);
   }
   
   /** Second Test. */
   @Test public void exceptionsTest() {
      String[] args = {"cardholder_data_3_exceptions.txt"};
      CardholdersPart3App.main(args);
   }
   /** Fixture initialization (common initialization
    *  for all tests).
   @Before public void setUp() {
   }


   /** A test that always fails.
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   } */
}
