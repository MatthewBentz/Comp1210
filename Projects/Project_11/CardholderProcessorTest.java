import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/** Class. */
public class CardholderProcessorTest {
   /** Test for constructor. */
   @Test public void constructorTest() {
      CardholderProcessor cp = new CardholderProcessor();
   }
   /** Test for array methods. */
   @Test public void arrayTest() {
      CardholderProcessor cp = new CardholderProcessor();
      Cardholder c = new SapphireCardholder("10002", "Matt");
      cp.addCardholder(c);
      cp.addInvalidRecord("Beans");
      cp.getCardholdersArray();
      cp.getInvalidRecordsArray();
      //Assert.assertEquals("Get array", null, cp.getCardholdersArray());
   }
   /** Test for file methods. */
   @Test public void fileTest() {
      CardholderProcessor cp = new CardholderProcessor();
      String[] args1 = {};
      String[] args2 = {"cardholders_data_1.txt"};
      try {
         cp.readCardholderFile("cardholder_data_1.txt");
         CardholdersPart3App.main(args1);
         CardholdersPart3App.main(args2);
      } catch (FileNotFoundException fnfe) {
      
      }
      Assert.assertTrue(cp.generateReport().contains(
         "Monthly Cardholder Report\n")); 
      Assert.assertTrue(cp.generateReportByName().contains(
         "(by Name)\n"));
      Assert.assertTrue(cp.generateReportByCurrentBalance().contains(
         "(by Current Balance)\n"));
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
