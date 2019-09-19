/** Carholders app part 3.
 *Project 11
 *@mlb0119
 *@version 11.28.18 */

import java.io.FileNotFoundException;
 /** Class. */
public class CardholdersPart3App {

  /**Main method.
   *@param args used for writing in file name.
   *@throws FileNotFoundException for files not found. */
   public static void main(String[] args) {
      try { 
         CardholderProcessor cp = new CardholderProcessor();
         String fileName = "";
         if (args.length > 0) {
            fileName = args[0];
         } else {
            System.out.println("File name expected as command line argument."
               + "\nProgram ending.");
         }
         //CardholderProcessor cp = new CardholderProcessor();
         if (!fileName.equals("")) {
            cp.readCardholderFile(fileName);
            System.out.print(cp.generateReport());
            System.out.print(cp.generateReportByName());
            System.out.print(cp.generateReportByCurrentBalance());
            System.out.print(cp.generateInvalidRecordsReport());
         }
      }
      catch (FileNotFoundException e) {
         System.out.print(" *** Attempted to read file: "
               + e.getMessage());
      }
   }
}