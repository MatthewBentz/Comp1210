/** SapphireCardholder child class of cardholder.
 *Project 9
 *@mlb0119 Matthew Bentz
 *@version 11/9/18 */
 
 /** Child class of cardholder. */
public class SapphireCardholder extends Cardholder {
   
   /** Constructor.
    *@param acctNumberIn for account number.
    *@param nameIn for account name. */
   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Sapphire Cardholder";
   }
   
   /** Method to determine purchase points.
    *@return int value for every dollar spent. */
   protected int purchasePoints() {
      int points = (int) Math.floor(totalPurchases());
      return points;
   }
 
 
}