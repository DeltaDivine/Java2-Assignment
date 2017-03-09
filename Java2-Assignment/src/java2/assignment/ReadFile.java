/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.System.in;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class ReadFile {
//        public static void docFileFaster() throws FileNotFoundException, IOException{
//        try{
//            FileReader fr = new FileReader("quylop.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String line = br.readLine();
//            Charset.forName("UTF8");
//            while (line != null) {                
//                System.out.println(line);
//                line = br.readLine();
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void readFile() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        try {
            ArrayList<Student> listStudent = new ArrayList<Student>();
            HashMap<String, Student> mapStudent = new HashMap<String, Student>();
            File fr = new File("quylop.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fr), "UTF8"));
            String str;
            str = in.readLine();
            while ((str = in.readLine()) != null) {
                String[] arraySplit = str.split("[\\s\\t]{2,}+");
                for (int i = 0; i < arraySplit.length; i++) {
                    Student student = new Student(
                            arraySplit[0].trim(),
                            arraySplit[1].trim(),
                            Integer.parseInt(arraySplit[2].trim()),
                            arraySplit[3].trim());
                    if (mapStudent.containsKey(student.getId())) {
                        Student temp = mapStudent.get(student.getId());
                        student.setMoney(temp.getMoney() + student.getMoney());
                    }
                    mapStudent.put(student.getId(), student);
                }
            }
            in.close();
            for (String key : mapStudent.keySet()) {
                System.out.println(mapStudent.get(key).toString());
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
//        docFileFaster();
        readFile();
    }
}
