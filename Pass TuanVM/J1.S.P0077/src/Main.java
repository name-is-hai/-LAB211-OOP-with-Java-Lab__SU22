
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Program program = new Program();
        //Step1: Display option for user to choice
        while(true){
            int choice = menu.getChoice(1,4);
            switch(choice){
                //user choice 1
                case 1:                            
                    //input file by path
                    String path = program.inputPath("-------- Count Word --------");
                    //input work you want to file
                    String word = program.inputWord();
                    //count
                    int count = program.countWord(path, word);
                    program.displayCount(count);
                    break;
                case 2:
                    //input file by path
                    String path2 = program.inputPath("-------- Find File By Word --------");
                    //input work you want to file
                    String word2 = program.inputWord();
                    //display name of file
                    ArrayList<String> fileName = program.getFileName(path2, word2);
                    
                    program.displayFileName(fileName);
                    break;
                case 3:
                    return;
            }
        }
        
    }
    
}
