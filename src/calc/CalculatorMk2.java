package calc;

import java.io.Console;

public class CalculatorMk2 {

   // Constant
   public static final int CMD_POS = 0;      

   public static void main(String[] args) {

      // declare an accumulator
      float acc = 0;  

      boolean stop = false;

      Console cons = System.console();

      while (!stop) {

         // Read a line, trim it, ignore case, split into multi-strings with each spacing
         String[] inputs = cons.readLine("CMD> ").trim().split(" ");
         String cmd = inputs[CMD_POS];

         switch (cmd.toLowerCase()) {
            // e.g. ADD 5 6 7 8  [acc + 5 + 6 + 7 + 8]
            case "add":
               // loop thru input values given
               for(int i = 1; i < inputs.length; i++)
               {
                  acc += Float.parseFloat(inputs[i]);
               }
               break;

            // e.g. SUB 5 6 7 8
            case "sub":
               // loop thru input values given
               for(int i = 1; i < inputs.length; i++)
               {
                  acc -= Float.parseFloat(inputs[i]);
               }
               break;

            // e.g. MUL 5 6 7 8
            case "mul":
               // loop thru input values given
               for(int i = 1; i < inputs.length; i++)
               {
                  acc *= Float.parseFloat(inputs[i]);
               }
               break;

            // e.g. DIV 5
            case "div":
               // only take next value to divm ignore other multiple values given
               acc /= Float.parseFloat(inputs[1]);
               break;

            // initializes the accumulator to 0
            case "init":
               acc = 0;
               break;

            case "brk":
               stop = true;
               break;

            case "show":
               System.out.printf("> %.3f\n", acc);
               break;

            default:

         }

      }

   }

}