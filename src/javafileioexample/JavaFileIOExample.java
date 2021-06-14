package javafileioexample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaFileIOExample {

    public static void main(String[] args) {

        String sourceFile = "myFolder/birds.txt";
        String targetFile = "myFolder/myCopy.txt";

        try ( // to make sure reader and writer instances are closed after write operation ends (instead of finally block)
                FileReader fileReader = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(targetFile);) {

            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                writer.write(line + "\n");
            }// end while loop
        } // end try
        // because FileNotFoundException is an IOFoundException --------------------
        //        catch (FileNotFoundException ex) {
        //            ex.printStackTrace();
        //            System.out.println("-- FileNotFoundException --");
        //            System.out.println("File not found!!!!");
        //        } 
        //---------------------------------------------------------------------------
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("-- IOFoundException --");
        }// end second catch

    }

}
