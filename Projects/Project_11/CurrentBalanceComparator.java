/** Class to implement compareTo method by current balance.
 *Project 10
 *@mlb0119
 *@version 11.16.18 */
 
import java.util.Comparator;
 
 /** Class. */
public class CurrentBalanceComparator implements Comparator<Cardholder> {
 
   /** Constructor?
    *@param c1 first card being compared.
    *@param c2 second card being compared.
    *@return int based on which value is higher or lower. */
   public int compare(Cardholder c1, Cardholder c2) {
      if (c1.currentBalance() > c2.currentBalance()) {
         return -1;
      }
      else if (c1.currentBalance() < c2.currentBalance()) {
         return 1;
      }
      else {
         return 0;
      }
   }
}