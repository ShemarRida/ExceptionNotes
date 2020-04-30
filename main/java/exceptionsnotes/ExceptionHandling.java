package exceptionsnotes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception{
        //createNewFile();
        numbersExceptionHandling();
        createNewFileRethrow();
        calculateSalary(30.0,12.0);
    }
    public static void createNewFile(){
        File file = new File("resources/nonexistent.text");
        try{
            file.createNewFile();
        }catch (Exception e){
            System.out.println("Directory does not exist.");
            e.printStackTrace();
        }
    }
    public static void createNewFileRethrow() throws IOException{
        File file = new File("resources/nonexistent.text");
        file.createNewFile();

    }
    public static void numbersExceptionHandling(){
        File file = new File("resources/number.txt");
        // Scanner fileReader = null
        try(Scanner fileReader = new Scanner(file)) {
            //fileReader = new Scanner(file);

            while (fileReader.hasNext()){
                double num = fileReader.nextDouble();
                System.out.println(num);
            }
        }catch (FileNotFoundException | InputMismatchException e){
            e.printStackTrace();
        }
        //finally {
         //   fileReader.close();
       // }
    }
    public static void calculateSalary(double hours, double rate){
        if (hours > 40){
            throw new IllegalArgumentException("We do not allow overtime");
        }
    }
}
