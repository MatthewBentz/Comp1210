import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/** 
 * TriangleListApp - uses TriangleList and Triangle classes.
 */
public class TriangleListApp {

/**
 * Reads file with triangle data, creates TriangleList, prints TriangleList,
 * prints summary of TriangleList.
 *
 * @param args - is not used.
 * @throws FileNotFoundException required by Scanner for File
 */
   public static void main(String[] args) throws FileNotFoundException
   {
      ArrayList<Triangle> myList = new ArrayList<Triangle>();
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      
      Scanner scanFile = new Scanner(new File(fileName));
   
      String triangleListName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
      
         double side1 = scanFile.nextDouble();
         double side2 = scanFile.nextDouble();
         double side3 = scanFile.nextDouble();
         
         Triangle t = new Triangle(side1, side2, side3);
         myList.add(t);           
      }
      scanFile.close();
      
      TriangleList myTriangleList = new TriangleList(triangleListName, myList);
   
      System.out.println(myTriangleList);
      
      System.out.println(myTriangleList.summary());                          
   }

}
