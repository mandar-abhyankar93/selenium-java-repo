package samples;

public class ReverseWordsOfSentence {
	
	public static void main(String[] args) {
		String sentence = "The Quick Brown Fox Jumped Over The Lazy Dog";
		String[] words = sentence.split(" ");
		for(int i=words.length-1;i>=0;i--){
			System.out.print(words[i]+" ");
		}
	}

}
