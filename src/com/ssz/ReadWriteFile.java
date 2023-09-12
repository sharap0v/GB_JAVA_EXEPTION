package com.ssz;

import sun.security.pkcs.ParsingException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ReadWriteFile {
    public static void writeFile(String fileName, String text){
        try{
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();

            fileOutputStream.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[] readSettings(String filename, String key){
        Properties properties = new Properties();
        ClassLoader loader = HW3.class.getClassLoader();
        try(InputStream stream = loader.getResourceAsStream(filename)) {
            properties.load(new InputStreamReader(stream,"UTF-8"));
            String property = properties.getProperty(key);
            String[] e = property.toUpperCase().replace("Ё", "Е").split(",");
            return e;
        } catch (IOException ignored) {
            ignored.printStackTrace();
            return new String[0] ;
        }

    }

    public static String createFolder(String folderName){
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }
        return folderName;
    }

}
