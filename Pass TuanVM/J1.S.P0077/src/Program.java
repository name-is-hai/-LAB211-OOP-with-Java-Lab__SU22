
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Program {

    public String inputPath(String firstLine) {
        System.out.println(firstLine);
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("Enter Path:");
        String path = sc.nextLine();
            if (path.isEmpty()) {
                System.out.println("Input can not be blank.");
                System.out.println("Re-enter:");
            }
            else{
                File f = new File(path);
                if(!f.exists()){
                    System.out.println("Path is not right.");
                }else{
                    return path;
                }
            }
        }
    }
    
        public String inputWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word:");
        String word = sc.nextLine();
        while (true) {
            if (word.isEmpty()) {
                System.out.println("Input can not be blank.");
                System.out.println("Re-enter:");
            }
            return word;
        }
    }
        
    public int countWord(String path, String word){
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while(line != null){
                String[] words = line.split(" ");
                for(String w : words){
                    if(w.equalsIgnoreCase(word)){
                        count ++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            System.out.println("Not found file.");
        } catch (IOException ex) {
        }finally{
            try {
                fr.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }
    
    
    public ArrayList<String> getFileName(String path, String word){
        File file = new File(path);
        File[] listFiles = file.listFiles();
        ArrayList<String> fileName = new ArrayList<>();
        System.out.println("------------ File Name ----------");
        for(File f : listFiles){
            if(f.isFile()){
                if(countWord(f.getAbsolutePath(), word) > 0){
                    fileName.add(f.getName());
                }
            }
        }
        return fileName;
    }   
    
    public void displayCount(int count){
        if(count == 0){
            return;
        }
        System.out.println("Bount: " + count);
    }
    
    public void displayFileName(ArrayList<String> fileName){
        if(fileName.isEmpty()){
            System.out.println("Not found any file.");
        }
        
        for(String name : fileName){
            System.out.println("file name " + name);
        }
    }
    
    
}
