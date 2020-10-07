public class program {
	public String test(String hex) {
		/*
		 * Exercise 15: Hex to binary- Given a string representing a number in
		 * hexadecimal format, convert it into its equivalent binary string. For e.g. if
		 * the input if ”1F1” then its binary equivalent is ”111110001”. If the input is
		 * ”13AFFFF”, the output should be ”1001110101111111111111111”.
		 */
		String binary = "";
		for (int i = 0; i < hex.length(); i++) {
			binary += convert(hex.charAt(i));
		}

		// removing initial zeroes.
		String final_string = "";
		int flag = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) != '0') {
				flag = 1;
			}
			if (flag == 1)
				final_string += binary.charAt(i);
		}
		return final_string;
	}

	public String convert(char t) {
		switch (t) {
			case '0':
				return "0000";
			case '1':
				return "0001";
			case '2':
				return "0010";
			case '3':
				return "0011";
			case '4':
				return "0100";
			case '5':
				return "0101";
			case '6':
				return "0110";
			case '7':
				return "0111";
			case '8':
				return "1000";
			case '9':
				return "1001";
			case 'A':
			case 'a':
				return "1010";
			case 'B':
			case 'b':
				return "1011";
			case 'C':
			case 'c':
				return "1100";
			case 'D':
			case 'd':
				return "1101";
			case 'E':
			case 'e':
				return "1110";
			case 'F':
			case 'f':
				return "1111";
		}
		return "";
	}
}
