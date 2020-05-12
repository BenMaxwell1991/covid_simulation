package com.maxwell;

import com.maxwell.data.Constants;
import com.maxwell.utility.JSon;

public class CommandLineEntry {

    public static void main(String[] args) {
        String config = JSon.readFromJsonToString(Config.class, Constants.config);
        String results = EntryPoint.getResultString(config);
    }
}