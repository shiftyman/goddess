package com.goddess.ioc;

import com.goddess.ioc.anno.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by windlike.xu on 2018/6/14.
 */
public class ComponentScanner {

    public static HashMap<String, String> getComponentClassName(
            String packageName) {
        List<String> classes = getClassName(packageName);
        HashMap<String, String> components = new HashMap<>();

        try {
            for (String cl : classes) {
                Component comp = Class.forName(cl).getAnnotation(Component.class);

                if (comp != null) {
                    components.put(comp.id(), cl);
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return components;
    }

    public static List<String> getClassName(String packageName) {
        String filePath = ClassLoader.getSystemResource("").getPath()
                + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(packageName, filePath);
        return fileNames;
    }

    private static List<String> getClassName(String packageName, String filePath) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(packageName, childFile.getPath()
                        ));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.replace("\\", ".");
                childFilePath = childFilePath.substring(childFilePath
                        .indexOf(packageName), childFilePath.lastIndexOf("."));
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }
}
