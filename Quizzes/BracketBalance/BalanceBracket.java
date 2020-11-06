import java.util.Scanner;

public class BalanceBracket {
    public static void main(String[] args) {
        StackOwn<Character> st = new StackOwn<Character>();
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        scanner.close();

        int flag = 0;

        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '(' || inp.charAt(i) == '[' || inp.charAt(i) == '{') {
                st.push(inp.charAt(i));
            } else {
                if (st.size() == 0) {
                    flag = 1;
                    break;
                }
                if ((inp.charAt(i) == ')' && st.top() == '(') || (inp.charAt(i) == '}' && st.top() == '{')
                        || (inp.charAt(i) == ']' && st.top() == '[')) {
                    st.pop();
                } else {
                    flag = 1;
                    break;
                }

            }
        }
        if (flag == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
