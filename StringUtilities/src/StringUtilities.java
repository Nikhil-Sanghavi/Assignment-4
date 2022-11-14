import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringUtilities {

	private static void printDuplicateCharsIgnoreCase(String s) //accept string and print duplicates chars on console (case-insensitive)
	{
		System.out.println("print duplicate chars ignore case : " + s);
		boolean ignoreCase = true;
		int[] charCount = new int['Z' - 'A' + 1]; // array of total alphabets initialized to zero as default
		for (int i = 0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if (ignoreCase) {
				if (ch >= 'a' && ch <= 'z') //convert lower case to upper case
					ch = (char) (ch - 'a' + 'A');
			}
			charCount[ch - 'A']++;
		}
		for (int i=0; i<charCount.length; i++)
		{
			if (charCount[i] > 1) // character coming more than once, means duplicate character
			{
				System.out.print((char)(i+'A'));
			}
		}
	}
	
	private static void printDuplicateChars(String s) //accept string and print duplicates chars on console (case-sensitive)
	{
		System.out.println("print duplicate chars : " + s);
		boolean ignoreCase = false;
		int[] charCountLowerCase = new int['z' - 'a' + 1]; // array of total alphabets initialized to zero as default
		int[] charCountUpperCase = new int['z' - 'a' + 1]; // array of total alphabets initialized to zero as default
		boolean upperCase;
		for (int i = 0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upperCase = true;
			else
				upperCase = false;
			if (upperCase)
				charCountUpperCase[ch - 'A']++;
			else
				charCountLowerCase[ch - 'a']++;
		}
		for (int i=0; i<charCountUpperCase.length; i++)
		{
			if (charCountUpperCase[i] > 1) // character coming more than once, means duplicate character
			{
				System.out.print((char)(i+'A'));
			}
		}
		
		for (int i=0; i<charCountLowerCase.length; i++)
		{
			if (charCountLowerCase[i] > 1) // character coming more than once, means duplicate character
			{
				System.out.print((char)(i+'a'));
			}
		}
	}
	
	private static void removeDuplicateCharsIgnoreCase(String s) {
		System.out.println("remove duplicate chars ignore case : " + s);
		boolean ignoreCase = true;
		int[] charCount = new int['Z' - 'A' + 1]; // array of total alphabets initialized to zero as default
		for (int i = 0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if (ignoreCase) {
				if (ch >= 'a' && ch <= 'z') //convert lower case to upper case
					ch = (char) (ch - 'a' + 'A');
			}
			charCount[ch - 'A']++;
		}
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i); // ch can be either upper case or lower case
			//convert ch to upper case if it is lower case
			if (ignoreCase) {
				if (ch >= 'a' && ch <= 'z') //convert lower case to upper case
					ch = (char) (ch - 'a' + 'A');
			}

			if (charCount[ch - 'A'] > 0) {
				System.out.print(ch);
				charCount[ch - 'A'] = -1; // ch printed so no repeatation of this char
			}
		}
		System.out.println();
	}
	
	private static void removeDuplicateChars(String s) {
		System.out.println("remove duplicate chars : " + s);
		int[] charCountLowerCase = new int['z' - 'a' + 1]; // array of total alphabets initialized to zero as default
		int[] charCountUpperCase = new int['z' - 'a' + 1]; // array of total alphabets initialized to zero as default
		boolean upperCase;
		for (int i = 0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upperCase = true;
			else
				upperCase = false;
			if (upperCase)
				charCountUpperCase[ch - 'A']++;
			else
				charCountLowerCase[ch - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= 'A' && ch <= 'Z') // work with charCountUpperCase
			{
				if (charCountUpperCase[ch - 'A'] > 0) {
					System.out.print(ch);
					charCountUpperCase[ch - 'A'] = -1; // ch printed so no repeatation of this char
				}	
			}
			else //work with charCountLowerCase
			{
				if (charCountLowerCase[ch - 'a'] > 0) {
					System.out.print(ch);
					charCountLowerCase[ch - 'a'] = -1; // ch printed so no repeatation of this char
				}
			}
		}
		System.out.println();
//
	}
	
	private static void checkPalindrome(String s) {
		System.out.println("palinDrome Test : " + s);
		boolean palinDrome = true;
		for(int i=0,j=s.length()-1; i<j;i++,j--) {
			if (s.charAt(i) != s.charAt(j)) {
				palinDrome = false;
				break;
			}
		}
		System.out.println(palinDrome ? s + " is a PalinDrome string" : s + " is not a PalinDrome string");
	}
	
	private static void countConsoVoWelsSpecialChar(String s) {
		System.out.println("Counting consonants, vowels and special char : " + s);
		int totConsonants = 0, totVowels = 0, totSpecialChars = 0;
		
		for(int i=0; i<s.length();i++) 
		{
			char ch = s.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				if ("aeiouAEIOU".indexOf(ch) == -1)
					totConsonants++;
				else
					totVowels++;
			else
				totSpecialChars++;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("Consonants : ");
		sb.append(totConsonants);
		sb.append(" :: Vowels : ");
		sb.append(totVowels);
		sb.append(" :: SpecialChars : ");
		sb.append(totSpecialChars);
		System.out.println(sb);
				
	}
	private static char[] toLowerCaseCharArray(char [] c) {
		for (int i = 0; i<c.length; i++) {
			if (c[i] >= 'A' && c[i] <= 'Z')
				c[i] = (char) (c[i] - 'A' + 'a');
		}
		return c;
	}
	private static void  checkAnagram(String s1, String s2) {
		boolean anagram = true;
		if (s1.length() != s2.length())
			anagram = false;
		else {
					
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			
			toLowerCaseCharArray(c1);
			toLowerCaseCharArray(c2);
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			for(int i = 0; i<c1.length; i++) {
				if (c1[i] != c2[i]) {
					anagram = false;
					break;
				}
			}
		}
		if (anagram)
			System.out.println(s1 + " and " + s2 + " are anagram strings");
		else
			System.out.println(s1 + " and " + s2 + " are not anagram strings");
	}
	
	private static void checkPanagram(String s) {
		boolean panagram = true;
		
		boolean[] alphabets = new boolean['z' - 'a' + 1];
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int charIndex = -1;
			if (ch >= 'A' && ch <= 'Z')
				charIndex = ch - 'A';
			else if (ch >= 'a' && ch <= 'z')
				charIndex = ch - 'a';
			if (charIndex >= 0)
				alphabets[charIndex] = true;
		}
		for (int i = 0; i < alphabets.length; i++)
			if (!alphabets[i]) {
				panagram = false;
				System.out.print((char)('a' + i));
//				break;
			}
		if (!panagram)
			System.out.println(" ==> missing in following string");
				
		if (panagram)
			System.out.println(s + " :: panagram");
		else
			System.out.println(s + " :: not panagram");
		System.out.println("-------");
	}
	
	private static void checkAllUniqueChars(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		boolean repeatingChars = false;
		for(int i = 0; i < charArray.length-1; i++) {
			if (charArray[i] != ' ') //skip spaces
			{
				if (charArray[i] == charArray[i+1]) {
					repeatingChars = true;
					break;
				}
					
			}
 		}
		if (repeatingChars)
			System.out.println(s + " :: not having all unique chars");
		else
			System.out.println(s + " :: having all unique chars");
			
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
//		System.out.print("\\033[H\\033[2J");  
//		System.out.flush();  
//		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
		Scanner scan = new Scanner(System.in);
//		//remove duplicate chars
		System.out.print("Remove Duplicates...");
		System.out.println("Press any key to continue ..");
		scan.hasNextLine();
		removeDuplicateCharsIgnoreCase("Ashokkumar");//A and a will not be considered as duplicates
//		System.out.println("-----------------------------");
		removeDuplicateChars("Ashokkumar");//A and a will be considered as duplicates
//		System.out.println("* * * * *");
		
		removeDuplicateCharsIgnoreCase("AaBbCc");//A and a will not be considered as duplicates
//		System.out.println("-----------------------------");
		removeDuplicateChars("AaBbCc");//A and a will be considered as duplicates
//		System.out.println("* * * * *");
		
		removeDuplicateCharsIgnoreCase("");//A and a will not be considered as duplicates
//		System.out.println("-----------------------------");
		removeDuplicateChars("");//A and a will be considered as duplicates
//		System.out.println("* * * * *");
		System.out.println("Press any key to continue..");
		scan.nextLine();
		
		
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
//		//print duplicate chars
		System.out.print("print duplicate Characters...");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		printDuplicateCharsIgnoreCase("Ashokkumar");//A and a will not be considered as duplicates
		System.out.println("-----------------------------");
		printDuplicateChars("Ashokkumar");//A and a will be considered as duplicates
		System.out.println("* * * * *");
		
		printDuplicateCharsIgnoreCase("AaBbCc");//A and a will not be considered as duplicates
		System.out.println("-----------------------------");
		printDuplicateChars("AaBbCc");//A and a will be considered as duplicates
		System.out.println("* * * * *");
		
		printDuplicateCharsIgnoreCase("");//A and a will not be considered as duplicates
		System.out.println("-----------------------------");
		printDuplicateChars("");//A and a will be considered as duplicates
		System.out.println("* * * * *");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
//		//palindrome string
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		System.out.print("palindrome string ...");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		checkPalindrome("abcba");
		checkPalindrome("abcabc");
		checkPalindrome("*A$$A*");
		checkPalindrome("abccba");
		checkPalindrome("");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
		
// count consonants, vowels and special chars
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		System.out.print("count Consonants, Vowels and Special Characters...");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		countConsoVoWelsSpecialChar("Hello, how are you ?");
		countConsoVoWelsSpecialChar("bcd 123");
		countConsoVoWelsSpecialChar("aei xyz");
		countConsoVoWelsSpecialChar("Hello, how are you ?!...");
		countConsoVoWelsSpecialChar("");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
//		//anagram - both strings having same chars
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		System.out.print("anagram string... ");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		checkAnagram("RACE", "CARE");
		checkAnagram("Race", "Care");
		checkAnagram("Race", "Carec");
		checkAnagram("aeiou", "aiuoe");
		checkAnagram("", "");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
//	// panagram - contains all alphabets
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		System.out.print("panagram... ");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		checkPanagram("Hello");
		checkPanagram("A Quick Brown Fox Jumps Over a Lazy Dog");
		checkPanagram("$$$ A Quick Brown Fox Jumps Over the Lazy Dog ... 123");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
		System.out.print("check whether all characters are unique..");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		checkAllUniqueChars("12345");
		checkAllUniqueChars("12 34 5");// check only non space chars.. duplicate spaces allowed
		checkAllUniqueChars("1234512345");
		checkAllUniqueChars("Unique chars");
		checkAllUniqueChars("Repeating chars");
		scan.nextLine();
		
		System.out.print("maximum repeating character using map/stream... ");
		System.out.println("Press any key to continue ..");
		scan.nextLine();
//		System.out.print("\033[H\033[2J");  
//		System.out.flush();  
		maxRepeatingChars("Hello"); //l - 2 times
		maxRepeatingChars("Hello how are youuuuuuuu"); //l - 2 times
		maxRepeatingChars("Helloo"); //lo - 2 times
		maxRepeatingChars("Helo"); //Helo - 1 times
		maxRepeatingChars("ahhhhaa ...... !!!!!!!!!!"); //! - n times
		maxRepeatingChars(""); //! - n times
		System.out.println("Press any key to continue ..");
		scan.nextLine();
		
		System.out.print("Thanks and Bye...");
		System.out.println("Press any key to continue ..");

		scan.nextLine();
		scan.close();
		
	}
	private static void maxRepeatingChars(String s) {
		//take each char and add to map with key as char and value as count
		//find maximum value of count from map values
		// list all keys having count same as maximum values
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			Object value = map.get(ch);
			if (value == null) {
				map.put(ch, 1);
			}
			else {
				map.put(ch, (int)value + 1);
			}
		}
		int maxValue = -1;
//		maxValue = map.values().stream().max(null).get();
		maxValue = map.values()
				.stream()
				.mapToInt(v -> v)
				.max().orElse(maxValue);
//				.max((i1,i2) -> i1 > i2 ? i1 : i2);
//		System.out.println("-------------");
		System.out.println(s);
		//find all keys having value = maxValue
//		List<Character> chList = new ArrayList<>();
//		List<Character> chList = getKeys(map, maxValue);
		List<Character> chList = getKeysUsingStream(map, maxValue);
		for (Character character : chList) {
			System.out.print(character);
		}
		if (maxValue > 0)
			System.out.println(" :: " + maxValue + " times");
//		System.out.println("-------------");
	}

	private static <K, V> List<K> getKeys(Map<K, V> map, V value) {
		List<K> list = new ArrayList<>();
		for( Map.Entry<K, V> entry : map.entrySet()) {
			if (value.equals(entry.getValue()))
				list.add(entry.getKey());
		}
		return list;
	}
	
	private static <K,V> List<K> getKeysUsingStream(Map<K,V> map, V value){
		List<K> list = map.entrySet()
		.stream()
		.filter(entry -> entry.getValue().equals(value))
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		//		.map(entry -> entry.getKey())
		
		return list;
	}
	
}
