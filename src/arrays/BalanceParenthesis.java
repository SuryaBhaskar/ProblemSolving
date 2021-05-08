package arrays;
import java.util.HashMap;
import java.util.Map;

public class BalanceParenthesis {

	static Map<Character,Character> braces = new HashMap<>();
	static {
		braces.put('{','}');
		braces.put('(',')');
		braces.put('[',']');
	}

	public static void main(String[] args) {

		char[] input = {'(',')','{','[','(','(',')',')',']','}'};

		System.out.println(isParathenisBalanced(input));
	}

	private static boolean isParathenisBalanced(char[] input) {

		return isParathenisBalanced(input, 0, input.length-1);
	}

	private static boolean isParathenisBalanced(char[] input, int startIndex, int endIndex) {
		{
			if (startIndex == endIndex) {
				return false;
			}

			if (startIndex > endIndex) {
				return true;
			}

			char startingChar = input[startIndex];
			if (braces.get(startingChar) == null) {
				return false;
			}
			int count=0;
			for (int i = startIndex+1; i<=endIndex; i++) {
				if (input[i] == startingChar) {
					count++;
				}
				else if (input[i] == braces.get(startingChar)) {
					if (count==0) {
						return isParathenisBalanced(input, startIndex+1, i-1) && isParathenisBalanced(input, i+1, endIndex);
					}
					count--;
				}
			}

			return false;
		}
	}

}
