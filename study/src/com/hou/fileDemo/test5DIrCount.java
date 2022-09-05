package com.hou.fileDemo;

import java.io.File;
import java.util.HashMap;

public class test5DIrCount {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        File file = new File("study");
        countDir(hm,file);
        System.out.println(hm);
    }

    private static void countDir(HashMap<String, Integer> hm, File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()){
                String name = file1.getName();

                String[] nameSplit = name.split("\\.");
                if (nameSplit.length == 2){
                    String endName = nameSplit[1];
                    if (hm.containsKey(endName) ){
                        Integer count = hm.get(endName);
                        count++;
                        hm.put(endName,count);
                    }else {
                        hm.put(endName,1);
                    }
                }
            }else {
                countDir(hm,file1);
            }
        }

    }
}
