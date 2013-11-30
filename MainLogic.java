import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainLogic {
		
	public static String scramble(int pos, String s){
		List<Character> list = new ArrayList<Character>();
	    for(char c : s.toCharArray()) {
	        list.add(c);
	    }
	    
	    Collections.shuffle(list);
	    StringBuilder builder = new StringBuilder();
	    for(char c : list) {
	        builder.append(c);
	    }
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String scrambled;
		String s[] = {"hi","there", "go", "away"};

		int last, secondlast, word;
		word = last = secondlast = -1;
		
		Random generator = new Random(); 
		
		/* will move this to a function or something */
		for(int i = 0; i < 10; i++){
			while(word == last || word == secondlast)
				word = generator.nextInt(s.length);
			
			scrambled = scramble(word, s[word]);
			
			while(scrambled.equals(s[word]))
				scrambled = scramble(word, s[word]);
		    
			/* Test stuff */
			System.out.println(scrambled);
			secondlast = last;
			last = word;
		}
	}

}
