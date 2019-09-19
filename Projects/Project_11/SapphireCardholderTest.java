import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/** Class. */
public class SapphireCardholderTest {
   
   /** Acct method test. */
   @Test public void acctNumberTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setAcctNumber("12345");
      Assert.assertEquals("Get Acct #", "12345", sc.getAcctNumber());
   }
   
   /** name method test. */
   @Test public void nameTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setName("Bentz, Matthew");
      Assert.assertEquals("Get Name", "Bentz, Matthew", sc.getName());
   }

   /** previous balance test. */
   @Test public void prevBalanceTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPrevBalance(100);
      Assert.assertEquals("Prev balance", 100, sc.getPrevBalance(), 0.0001);
   }
   
   /** payment methods. */
   @Test public void paymentTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPayment(50);
      Assert.assertEquals("Payment", 50, sc.getPayment(), 0.0001);
   }
   
   /** purchases methods. */
   @Test public void purchasesTest() {
      double[] testPurchases = {12.0, 25.0};
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      //set purchases
      sc.setPurchases(12.0, 25.0);
      Assert.assertEquals("purchases array", sc.purchases, sc.getPurchases());
      Assert.assertEquals("Total purchases", 37.0, sc.totalPurchases(), 0.001);
      //add purchases
      sc.addPurchases(30.0, 35.0);
      Assert.assertEquals("add purchases", sc.purchases, sc.getPurchases());
      Assert.assertEquals("Total purchases", 102.0, sc.totalPurchases(), 0.001);
      //delete one purchase
      sc.deletePurchase(30.0);
      Assert.assertEquals("delete purchase", sc.purchases, sc.getPurchases());
      Assert.assertEquals("Total purchases", 72.0, sc.totalPurchases(), 0.001);
      //delete multiple purchases
      sc.deletePurchases(12.0, 35.0);
      Assert.assertEquals("delete purchases", sc.purchases, sc.getPurchases());
      Assert.assertEquals("total purchases", 25.0, sc.totalPurchases(), 0.0001);
   }
   
   /** interest method test. */
   @Test public void interestTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPrevBalance(100.0);
      sc.setPayment(20.0);
      Assert.assertEquals("interest test", 0.80, sc.interest(), 0.0001);
   }
   
   /** balance method test. */
   @Test public void balanceTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPurchases(20.0, 30.0);
      sc.setPrevBalance(100.0);
      sc.setPayment(20.0);
      Assert.assertEquals("balance test", 51.0, sc.balance(), 0.0001);
      Assert.assertEquals("current balance test",
            130.8, sc.currentBalance(), 0.0001);
   }
   
   /** minimum payment test. */
   @Test public void minPaymentTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPurchases(50.0);
      sc.setPrevBalance(100.0);
      sc.setPayment(20.0);
      Assert.assertEquals("minimum payment test", 3.924,
            sc.minPayment(), 0.0001);
   }
   
   /** purchase points test. */
   @Test public void purchasePointsTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPurchases(50.7, 50.0);
      sc.setPayment(20.0);
      Assert.assertEquals("PP test", 100, sc.purchasePoints());
      sc.addPurchases(0.4);
      Assert.assertEquals("PP test", 101, sc.purchasePoints());
   }
   
   /** toString test. */
   @Test public void toStringTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      Assert.assertEquals("String test", true, sc.toString().contains(
         "Sapphire Cardholder\nAcctNo/Name: 10002 Jones, Jimmy"
         + "\nPrevious Balance: $1,200.00"
         + "\nPayment: ($200.00)"
         + "\nInterest: $10.00"
         + "\nNew Purchases: $548.00"
         + "\nCurrent Balance: $1,558.00"
         + "\nMinimum Payment: $46.74"
         + "\nPurchase Points: 548"));
   }

   /** Fixture initialization (common initialization
    *  for all tests). 
   @Before public void setUp() {
   } */
   /** A test that always fails.
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   } */
   
   /** delete tests... */
   @Test public void deleteTest() {
      SapphireCardholder sc = new SapphireCardholder("10002", "Jones, Jimmy");
      sc.setPurchases(100.0, 50.0, 25.0);
      sc.deletePurchases(50.0);
      Assert.assertEquals("delete test", 125.0, sc.totalPurchases(), 0.0001);
   }
}
