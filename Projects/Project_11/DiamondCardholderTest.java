import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/** Class. */
public class DiamondCardholderTest {

   /** Acct method test. */
   @Test public void acctNumberTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setAcctNumber("12345");
      Assert.assertEquals("Get Acct #", "12345", dc.getAcctNumber());
   }
   
   /** name method test. */
   @Test public void nameTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setName("Bentz, Matthew");
      Assert.assertEquals("Get Name", "Bentz, Matthew", dc.getName());
   }

   /** previous balance test. */
   @Test public void prevBalanceTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPrevBalance(100);
      Assert.assertEquals("Prev balance", 100, dc.getPrevBalance(), 0.0001);
   }
   
   /** payment methods. */
   @Test public void paymentTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPayment(50);
      Assert.assertEquals("Payment", 50, dc.getPayment(), 0.0001);
   }
   
   /** purchases methods. */
   @Test public void purchasesTest() {
      double[] testPurchases = {12.0, 25.0};
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      //set purchases
      dc.setPurchases(12.0, 25.0);
      Assert.assertEquals("purchases array", dc.purchases, dc.getPurchases());
      Assert.assertEquals("Total purchases", 35.15, dc.totalPurchases(), 0.001);
      //add purchases
      dc.addPurchases(30.0, 35.0);
      Assert.assertEquals("add purchases", dc.purchases, dc.getPurchases());
      Assert.assertEquals("Total purchases", 96.9, dc.totalPurchases(), 0.001);
      //delete one purchase
      dc.deletePurchase(30.0);
      Assert.assertEquals("delete purchase", dc.purchases, dc.getPurchases());
      Assert.assertEquals("Total purchases", 68.4, dc.totalPurchases(), 0.001);
      //delete multiple purchases
      dc.deletePurchases(12.0, 35.0);
      Assert.assertEquals("delete purchases", dc.purchases, dc.getPurchases());
      Assert.assertEquals("total purchases",
            23.75, dc.totalPurchases(), 0.0001);
   }
   
   /** interest method test. */
   @Test public void interestTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPrevBalance(100.0);
      dc.setPayment(20.0);
      Assert.assertEquals("interest test", 0.80, dc.interest(), 0.0001);
   }
   
   /** balance method test. */
   @Test public void balanceTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPurchases(20.0, 30.0);
      dc.setPrevBalance(100.0);
      dc.setPayment(20.0);
      Assert.assertEquals("balance test", 48.5, dc.balance(), 0.0001);
      Assert.assertEquals("current balance test", 
            128.3, dc.currentBalance(), 0.0001);
   }
   
   /** minimum payment test. */
   @Test public void minPaymentTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPurchases(50.0);
      dc.setPrevBalance(100.0);
      dc.setPayment(20.0);
      Assert.assertEquals("minimum payment test",
            3.849, dc.minPayment(), 0.0001);
   }
   
   /** purchase points test. */
   @Test public void purchasePointsTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.setPurchases(50.7, 50.0);
      dc.setPayment(20.0);
      Assert.assertEquals("PP test", 285, dc.purchasePoints());
      dc.addPurchases(0.4);
      Assert.assertEquals("PP test", 288, dc.purchasePoints());
   }
   
   /** toString test. */
   @Test public void toStringTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      //dc.setPayment(200);
      Assert.assertEquals("String test", true, dc.toString().contains(
         "Diamond Cardholder\nAcctNo/Name: 10002 Jones, Jimmy"
         + "\nPrevious Balance: $1,200.00"
         + "\nPayment: ($0.00)"
         + "\nInterest: $12.00"
         + "\nNew Purchases: $473.10"
         + "\nCurrent Balance: $1,685.10"
         + "\nMinimum Payment: $50.55"
         + "\nPurchase Points: 1,419"
         + "\n(includes 5.0% discount rate applied to New Purchases)"));
   }
   
   /** discount rate test. */
   @Test public void discountRateTest() {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Jimmy");
      Assert.assertEquals("rate test 1", 0.05, dc.getDiscountRate(), 0.0001);
      dc.setDiscountRate(0.10);
      Assert.assertEquals("rate test 2", 0.10, dc.getDiscountRate(), 0.0001);
   }

   /** Fixture initialization (common initialization
    *  for all tests).
   @Before public void setUp() {
   }
   /** A test that always fails.
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }  **/
}
