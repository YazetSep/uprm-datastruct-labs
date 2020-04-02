package Exercises;

import java.util.Scanner;

import Ex8_Stack.src.ciic4020.stack.LinkedListStack;
import Ex8_Stack.src.ciic4020.stack.Stack;
import sun.applet.Main;

public class Fully_Paren {
	
	
	private static Stack<String> operators = new LinkedListStack<String>();
	private static Stack<Integer> operands = new LinkedListStack<Integer>();
	private static Stack<String> paren = new LinkedListStack<String>();

	/*Full disclosure, this exercise has not been finished, the rest have been completed. 
	* I dont mind losing points in it, but I will finish it as I found it very challenging and 
	* fun to execute
	*/
	public static void expressionReader() {

		Integer[] alphabet = new Integer[26];

		while(true) {			

			//Scanner type object that will read user input
			Scanner sc = new Scanner(System.in);

			System.out.println("Scanner is Scanning Press ENTER without providing an input to exit");

			String lineInput = sc.nextLine();

			if(lineInput.trim().isEmpty()) {
				System.out.println("Exiting...");
				break;
			}

			if(lineInput.length() <= 1) {
				System.out.println("Not a valid expression or declaration");
				continue;
			}

			//Executes if the user inputs a variable assignment (ie "L=3")
			if(lineInput.substring(1,2).equals("=")) {
				int varConst=0;

				try {
					varConst = Integer.parseInt(lineInput.substring(2));
				} catch (Exception NumberFormatException) {
					System.out.println("That is not a valid variable assignment, try again.");
					continue;
				}

				//Assigns the variables value to it's corresponding location in the alphabet array				
				alphabet[variableAssigner(lineInput.substring(0,1).charAt(0))] = varConst;
			}

			else {
				int varAssignedTo;

				//Splits the input by the character defined
				String[] expression = lineInput.split(":");

				varAssignedTo = variableAssigner(expression[0].charAt(0));
				operands.push(varAssignedTo);

				char[] expressionBits = expression[1].toCharArray();


				//Goes through the characters that were obtained from the toCharArray array and assigns them to their stacks
				for (char c : expressionBits) {

					if(c == '(' || c == '{' || c == '[') {
						paren.push(String.valueOf(c));
					}
					else if(c == ')' || c == '}' || c == ']') {
						paren.push(String.valueOf(c));
					}
					else if(c == '+' || c == '-' || c == '*' || c == '/') {
						operators.push(String.valueOf(c));
					}
					else {
						operands.push(alphabet[variableAssigner(c)]);
					}
				}
			}

			Stack<String> printerStack = new LinkedListStack<String>();
			Stack<String> parenEvaluatorStack = new LinkedListStack<String>();
			Stack<String> operatorEvaluatorStack = new LinkedListStack<String>();
			Stack<Integer> operandEvaluatorStack = new LinkedListStack<Integer>();

			if(operators.isEmpty()) {
				//is invalid and print the invalid expression

			}
			else if (operands.size() > 1) {
				//is invalid and print the invalid expression
			}
			else if (paren.size()%2 != 0 || paren.top().equals("(") || paren.top().equals("{") || paren.top().equals("[")) {
				//is invalid and print the invalid expression
			}

			while(printerStack.size() != (operands.size()+operators.size()+paren.size())) {

				while(!paren.isEmpty()) {
					parenEvaluatorStack.push(paren.pop());
				}
				while(!operands.isEmpty()) {
					operandEvaluatorStack.push(operands.pop());
				}
				while(!operators.isEmpty()) {
					operatorEvaluatorStack.push(operators.pop());
				}

				if(parenEvaluatorStack.top().equals(")") || parenEvaluatorStack.top().equals("}") || parenEvaluatorStack.top().equals("]") ) {
					//is inavild and print the invalid expression
					break;
				}

				while(!parenEvaluatorStack.isEmpty()) {

					if(parenEvaluatorStack.top().equals(")") || parenEvaluatorStack.top().equals("}") || parenEvaluatorStack.top().equals("]")) {

						Integer temp2 = operands.pop();
						Integer temp1 = operands.pop();


						int secondOperand = alphabet[temp2];
						String operator = operators.pop();
						int firstOperand = alphabet[temp1];

						//Checks what the operator was and executes it refering to the operands in the operands stack and getting their values from the alphabet array
						if(operator.equals("+")) {
							alphabet[operands.pop()] = firstOperand + secondOperand; 
						}
						else if(operator.equals("-")) {
							alphabet[operands.pop()] = firstOperand - secondOperand; 

						}
						else if(operator.equals("*")) {
							alphabet[operands.pop()] = firstOperand * secondOperand; 

						}
						else if(operator.equals("/")) {
							alphabet[operands.pop()] = firstOperand / secondOperand; 

						}
					}
				}
			}	
		}
	}

	//Method to link al letters with their positions in the alphabet
	public static int variableAssigner(char letter) {

		if(letter == 'A' || letter == 'a') {	
			return 0;
		}
		else if(letter == 'B' || letter == 'b') {	
			return 1;
		}
		else if(letter == 'C' || letter == 'c') {	
			return 2;
		}
		else if(letter == 'D' || letter == 'd') {	
			return 3;
		}
		else if(letter == 'E' || letter == 'e') {	
			return 4;
		}
		else if(letter == 'F' || letter == 'f') {	
			return 5;
		}
		else if(letter == 'G' || letter == 'g') {	
			return 6;
		}
		else if(letter == 'H' || letter == 'h') {	
			return 7;
		}
		else if(letter == 'I' || letter == 'i') {	
			return 8;
		}
		else if(letter == 'J' || letter == 'j') {	
			return 9;
		}
		else if(letter == 'K' || letter == 'k') {	
			return 10;
		}
		else if(letter == 'L' || letter == 'l') {	
			return 11;
		}
		else if(letter == 'M' || letter == 'm') {	
			return 12;
		}
		else if(letter == 'N' || letter == 'n') {	
			return 13;
		}
		else if(letter == 'O' || letter == 'o') {	
			return 14;
		}
		else if(letter == 'P' || letter == 'p') {	
			return 15;
		}
		else if(letter == 'Q' || letter == 'q') {	
			return 16;
		}
		else if(letter == 'R' || letter == 'r') {	
			return 17;
		}
		else if(letter == 'S' || letter == 's') {	
			return 18;
		}
		else if(letter == 'T' || letter =='t') {	
			return 19;
		}
		else if(letter == 'U' || letter == 'u') {	
			return 20;
		}
		else if(letter == 'V' || letter == 'v') {	
			return 21;
		}
		else if(letter == 'W' || letter == 'w') {	
			return 22;
		}
		else if(letter == 'X' || letter == 'x') {	
			return 23;
		}
		else if(letter == 'Y' || letter == 'y') {	
			return 24;
		}
		else if(letter == 'Z' || letter == 'z') {	
			return 25;
		}

		return 0;

	}


//	public static void main(String[] args) {
//		expressionReader();
//	}


}
