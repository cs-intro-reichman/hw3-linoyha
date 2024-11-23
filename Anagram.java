/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess (str1);
		str2 = preProcess(str2);
		boolean answer = false;
		if (str1.length() == 0 && str2.length() == 0) {
			return true;
		}
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					str2 = str2.substring(0,j) + str2.substring(j+1);
					answer = true;
					break;
				}
				else {
					answer = false;
				}
			}
			if (answer) {
				continue;
			}
			else {
				return answer;
			}
		}
		return answer;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newstring="";
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)) || str.charAt(i) == ' ') {
				newstring += str.charAt(i);
			}
		}
		return newstring;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String newstr ="";
		while(str.length()!=0) {
			double random = Math.random() * (str.length());
			int index = (int) random;
			newstr += str.charAt(index);
			str = str.substring(0,index) + str.substring(index+1);
		}
		return newstr;
	}
}
