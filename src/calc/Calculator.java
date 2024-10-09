package calc;

import java.io.Console;

public class Calculator {
    public static void main(String[] args) {
        // Commands: 
        // 1. INIT              - set calc's accumulator to 0
        // 2. ADD/MUS/MUL/DIV   - operation to perform
        // 3. SHOW              - shows current value
        // 4. BRK               - exit app

        float value = 0f;
        boolean cmdEntered = false;     // to check if user needs to enter cmd or value next
        String prevCmd = "init";

        Console cons = System.console();
        
        while(!prevCmd.equals("brk"))
        {
            String input = cons.readLine("> ").trim().toLowerCase();

            // if user haven't enter cmd,
            if(!cmdEntered) 
            {
                if(input.equals("show"))
                    System.out.println(value);
                else if(input.equals("init"))
                    value = 0f;
                else
                    cmdEntered = true;  // just accept any cmd entered, do check next loop

                prevCmd = input;
            }
            // if user already enter cmd, should expect num and do operation with prev command
            else
            {
                // reset flag
                cmdEntered = false;
                // current cmd is assumed to be valid num
                float numToOperate = Float.parseFloat(input);

                switch (prevCmd) {
                    case "add":
                        value += numToOperate;
                        break;

                    case "sub":
                        value -= numToOperate;
                        break;

                    case "mul":
                        value *= numToOperate;
                        break;

                    case "div":
                        value /= numToOperate;                        
                        break;
                
                    default:
                        System.out.println("INVALID OPERATION ENTERED PREVIOUSLY! PLEASE ENTER NEW, VALID OPERATION!!");
                        break;
                }
            }

            
        }
    }
}
