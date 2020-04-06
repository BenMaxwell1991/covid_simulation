package com.maxwell.utility;

import com.maxwell.data.SIR;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;

// This class helps print output to the console
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
    public static void printData(SIR sir, File aFile){
        DecimalFormat formatter = new DecimalFormat("0.00");
        String sStr = formatter.format(sir.s.get());
        String iStr = formatter.format(sir.i.get());
        String rStr = formatter.format(sir.r.get());

        System.out.print(sStr + "  " + iStr + "  " + rStr + "\n");
        try {
            FileWriter myWriter = new FileWriter(aFile, true);
            myWriter.write(sStr + "  " + iStr + "  " + rStr + "\n");
            myWriter.close();
        } catch (Exception e) {

        }
    }
}
