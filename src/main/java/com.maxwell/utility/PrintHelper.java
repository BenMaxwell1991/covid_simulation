package com.maxwell.utility;

import com.maxwell.maths.ContinuousValue;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class PrintHelper {

    // Print x number of spaces
    private static void ps(int x){
        for(int i = 0; i < x; i++){
            System.out.print(" ");
        }
    }

    // Print the header row
    public static void printHeader(){
        ps(2);
        System.out.print("S");
        ps(5);
        System.out.print("I");
        ps(5);
        System.out.print("R\n");
    }


    // Print current set of x, y, z data
    public static void printData(ContinuousValue x, ContinuousValue y, ContinuousValue z, File aFile){
        DecimalFormat formatter = new DecimalFormat("0.00");
        String xStr = formatter.format(x.get());
        String yStr = formatter.format(y.get());
        String zStr = formatter.format(z.get());

        System.out.print(xStr + "  " + yStr + "  " + zStr + "\n");
        try {
            FileWriter myWriter = new FileWriter(aFile, true);
            myWriter.write(xStr + "  " + yStr + "  " + zStr + "\n");
            myWriter.close();
        } catch (Exception e) {

        }
    }
}
