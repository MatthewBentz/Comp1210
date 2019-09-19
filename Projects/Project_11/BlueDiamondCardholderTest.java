import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/** Class. */
public class BlueDiamondCardholderTest {

   /** Acct method test. */
   @Test public void acctNumberTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setAcctNumber("12345");
      Assert.assertEquals("Get Acct #", "12345", bdc.getAcctNumber());
   }
   
   /** name method test. */
   @Test public void nameTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setName("Bentz, Matthew");
      Assert.assertEquals("Get Name", "Bentz, Matthew", bdc.getName());
   }

   /** previous balance test. */
   @Test public void prevBalanceTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPrevBalance(100);
      Assert.assertEquals("Prev balance", 100, bdc.getPrevBalance(), 0.0001);
   }
   
   /** payment methods. */
   @Test public void paymentTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPayment(50);
      Assert.assertEquals("Payment", 50, bdc.getPayment(), 0.0001);
   }
   
   /** purchases methods. */
   @Test public void purchasesTest() {
      double[] testPurchases = {12.0, 25.0};
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      //set purchases
      bdc.setPurchases(12.0, 25.0);
      Assert.assertEquals("purchases array", bdc.purchases,
          bdc.getPurchases());
      Assert.assertEquals("Total purchases", 33.30, bdc.totalPurchases(),
          0.001);
      //add purchases
      bdc.addPurchases(30.0, 35.0);
      Assert.assertEquals("add purchases", bdc.purchases,
          bdc.getPurchases());
      Assert.assertEquals("Total purchases", 91.8, bdc.totalPurchases(),
          0.001);
      //delete one purchase
      bdc.deletePurchase(30.0);
      Assert.assertEquals("delete purchase", bdc.purchases,
          bdc.getPurchases());
      Assert.assertEquals("Total purchases", 64.8, bdc.totalPurchases(),
          0.001);
      //delete multiple purchases
      bdc.deletePurchases(12.0, 35.0);
      Assert.assertEquals("delete purchases", bdc.purchases,
          bdc.getPurchases());
      Assert.assertEquals("total purchases",
            22.5, bdc.totalPurchases(), 0.0001);
   }
   
   /** interest method test. */
   @Test public void interestTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPrevBalance(100.0);
      bdc.setPayment(20.0);
      Assert.assertEquals("interest test", 0.80, bdc.interest(), 0.0001);
   }
   
   /** balance method test. */
   @Test public void balanceTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPurchases(20.0, 30.0);
      bdc.setPrevBalance(100.0);
      bdc.setPayment(20.0);
      Assert.assertEquals("balance test", 46.0, bdc.balance(), 0.0001);
      Assert.assertEquals("current balance test", 
            125.8, bdc.currentBalance(), 0.0001);
   }
   
   /** minimum payment test. */
   @Test public void minPaymentTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPurchases(50.0);
      bdc.setPrevBalance(100.0);
      bdc.setPayment(20.0);
      Assert.assertEquals("minimum payment test",
            3.77, bdc.minPayment(), 0.01);
   }
   
   /** purchase points test. */
   @Test public void purchasePointsTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.setPurchases(50.0);
      Assert.assertEquals("PP test", 225, bdc.purchasePoints());
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("1", "mb");
      bdc2.addPurchases(5000.0);
      Assert.assertEquals("PP test", 25000, bdc2.purchasePoints());
   }
   
   /** toString test. */
   @Test public void toStringTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bdc.setPrevBalance(1200.0);
      Assert.assertEquals("String test", true, bdc.toString().contains(
         "Blue Diamond Cardholder\nAcctNo/Name: 10002 Jones, Jimmy"
         + "\nPrevious Balance: $1,200.00"
         + "\nPayment: ($0.00)"
         + "\nInterest: $12.00"
         + "\nNew Purchases: $538.20"
         + "\nCurrent Balance: $1,750.20"
         + "\nMinimum Payment: $52.51"
         + "\nPurchase Points: 2,690"
         + "\n(includes 10.0% discount rate applied to New Purchases)"));
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      Assert.assertEquals("String test", true, bdc2.toString().contains(
         "Blue Diamond Cardholder\nAcctNo/Name: 10002 Jones, Jimmy"
         + "\nPrevious Balance: $1,200.00"
         + "\nPayment: ($0.00)"
         + "\nInterest: $12.00"
         + "\nNew Purchases: $9,000.00"
         + "\nCurrent Balance: $10,212.00"
         + "\nMinimum Payment: $306.36"
         + "\nPurchase Points: 47,500"
         + "\n(includes 10.0% discount rate applied to New Purchases)"
         + "\n(includes 2,500 bonus points added to Purchase Points"));
   }
   
   /** discount rate test. */
   @Test public void discountRateTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      Assert.assertEquals("rate test 1", 0.10, bdc.getDiscountRate(), 0.0001);
      bdc.setDiscountRate(0.15);
      Assert.assertEquals("rate test 2", 0.15, bdc.getDiscountRate(), 0.0001);
   }
   
   /** bonus points test. */
   @Test public void bonusPointsTest() {
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10002",
          "Jones, Jimmy");
      Assert.assertEquals("bonus test", 2500, bdc.getBonusPurchasePoints());
      bdc.setBonusPurchasePoints(3000);
      Assert.assertEquals("bonus test 2", 3000, bdc.getBonusPurchasePoints());
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