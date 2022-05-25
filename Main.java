//Created by Christian Cernechez
//May 25, 2022

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    // Function to add array in kooSumArray
    public static String[] addArray(int arrayLength, String kooSumArray[], String newItem)
    {
        int i;

        String newarray[] = new String[arrayLength + 1];
        for (i = 0; i < arrayLength; i++)
            newarray[i] = kooSumArray[i];
  
        newarray[arrayLength] = newItem;
  
        return newarray;
    }

    //check number if even or odd
    public static boolean checkIfEven(String num)
    {
        int result = Integer.parseInt(num) % 2;
        if(result > 0 ){
            return false;
        } else {
            return true;
        }
    }

    public static String kooSum(String num1, String num2)
    {
        if((checkIfEven(num1) == true) && (checkIfEven(num2) == true)){
            return num2 + num1;
        } else if((checkIfEven(num1) == true) && (checkIfEven(num2) == false)){
            return num1 + num2 + num1;
        } else if((checkIfEven(num1) == false) && (checkIfEven(num2) == true)){
            return num2 + num1 + num2;
        } else {
            return num1 + num2;
        }
    }


    public static void main(String[] args)
    {

        //Create Array
        String kooSumArray[] = {};


        Scanner myScanner1 = new Scanner(System.in);
        System.out.println("Set test case number : ");
       
        int numTestCase = Integer.parseInt(myScanner1.nextLine());

        String numb1, numb2;
        String x;
        Scanner myScanner2 = new Scanner(System.in);
        System.out.println("=================KOO NUMBERS================\nNote : Please use single space for the seperation of two numbers.");
        for(int i = 0; i < numTestCase; i++) {
            
            x = myScanner2.nextLine();
            String[] y = x.split(" ");
    
            kooSumArray = addArray(kooSumArray.length, kooSumArray,kooSum(y[0],y[1]));
        }

        
        try {
            FileWriter myWriter = new FileWriter("Output.txt");
            for(int i = 0;i < kooSumArray.length; i++){
                myWriter.write(kooSumArray[i] + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote the result in Output.txt file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}