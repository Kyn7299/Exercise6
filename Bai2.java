package bai2;

import java.util.ArrayList;

public class Bai2 {
	public static String replaceRepetitive(String x){
		String m = "";
		String[] al = x.split("\\s+");
		for(int i = 0; i < al.length-1; i++) {
			if (al[i].matches(".*[a-zA-Z].*")) {
				if (al[i].equalsIgnoreCase(al[i+1])) {
					m += "REPEAT";
					while (al[i].equalsIgnoreCase(al[i+1]))
						if (i+1 == al.length-1)
							return m;
						else i++;
				}
				else {
					m += al[i];
				}
				m+= " ";
				if (i == al.length-2) {
					m += al[i+1];
				}
			}
			else {
				m += al[i];
				if (i == al.length-2 && !al[i+1].matches(".*[a-zA-Z].*"))
					m += al[i+1];
			}
		}
		return m;
	}
	
	public static void test(String text) {
		switch (text) {
		case "I want to to go to the the the zoo":
			System.out.println("Input : I want to to go to the the the zoo");
			System.out.println("Expect output : I want REPEAT go to REPEAT zoo");
			System.out.println("Real output : "+ replaceRepetitive(text));
			break;
		case "This this is test for for this program Program" :
			System.out.println("Input : This this is test for for this program Program");
			System.out.println("Expect output : REPEAT is test REPEAT this REPEAT");
			System.out.println("Real output : "+ replaceRepetitive(text));
			break;
		case "this This THIS is test for     Space    space" :
			System.out.println("Input : this This THIS is test for     Space    space");
			System.out.println("Expect output : REPEAT is test for REPEAT");
			System.out.println("Real output : "+ replaceRepetitive(text));
			break;
		case "Test TEST for the dots . . ." :
			System.out.println("Input : Test TEST for the dots . . .");
			System.out.println("Expect output : REPEAT for the dots ...");
			System.out.println("Real output : "+ replaceRepetitive(text));
			break;
		case "I i i want to go to to school. School is the the the best." :
			System.out.println("Input : I i i want to go to to school. School is the the the best.");
			System.out.println("Expect output : REPEAT want to go REPEAT school. School is REPEAT best.");
			System.out.println("Real output : "+ replaceRepetitive(text));
			break;
		}	
	}
	
	public static void main(String[] args) {
		String text = "Test TEST for the dots . . .";
		test(text);
	}
}
