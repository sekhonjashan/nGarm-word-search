import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class nGram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nGramV =0;
		int numOfLines = 0;
		String lines = "";
		
		Scanner sc = new Scanner(System.in);
		
		numOfLines = sc.nextInt();
		
		for(int i = 0; i<=numOfLines;i++) {
			
			lines = lines + sc.nextLine();
			
		}
		//sc.close(); One program will have one and only one scanner close
		//a.replaceAll("\\s+",""); replace spaces with no space
		//.trim().toLowerCase().
		
		lines = lines.trim().toLowerCase().replaceAll("\\s+","").replace(".", "").replace(",", "");
		
		Scanner sc1 = new Scanner(System.in);
		nGramV = sc1.nextInt();
		if(nGramV <0 || nGramV>4) {
			
			System.out.println("Invalid case of nGrame. Try again ");
			System.exit(0);
		}
		
		
		System.out.println("Num of lines" + numOfLines + "\nGram value is " + nGramV);
		
		System.out.println("lines are \n\n"+lines);

		
		switch(nGramV) {
		
		case 1:
			unigram(lines);
		break;
		
		case 2:
			bigram(lines);
		break;
		
		case 3:
			trigram(lines);
		break;
		
		}
		
	}

	
	
	private static void trigram(String lines) {
		// TODO Auto-generated method stub
		int[][][] tri= new int [26][26][26];
		
		int maxR = 0;
		int a=0,b=0,c=0;
		
		for(int i = 2;i<lines.length();i++) {
			
			
			tri[lines.charAt(i-2)-'a'][lines.charAt(i-1)-'a'][lines.charAt(i)-'a']++;	
		}
		
		for(int i = 0; i<26;i++) {
			for(int j = 0; j<26;j++){
			//System.out.println( (char)(i+'a')+ " && "+(char)(j+'a') + "<<--->>"        +   (bi[i][j]));
				for(int k = 0; k<26;k++){
					
				if(tri[i][j][k]>maxR) {
						a = i;
						b = j;
						c = k;
					maxR=tri[i][j][k];
				//	System.out.println( (char)(i+'a')+ " && "+(char)(j+'a') + "<<--->>"        +   (bi[i][j]) + "max value");
				}
			
			}
		}
		}
		
		System.out.println("word is " + (char)(a+'a')+""+ (char)(b+'a')+"" + (char)(c+'a') + "   Count is " + maxR);
		
		
	}



	private static void bigram(String lines) {
		// TODO Auto-generated method stub
		int[][] bi = new int [26][26];
		int maxR=0;
		int a = 0,b = 0;
		for(int i = 1; i<lines.length();i++) {
			
			bi[lines.charAt(i-1)-'a'][lines.charAt(i)-'a']++;
		}
		
		for(int i = 0; i<26;i++) {
			for(int j = 0; j<26;j++){
			//System.out.println( (char)(i+'a')+ " && "+(char)(j+'a') + "<<--->>"        +   (bi[i][j]));
			
				if(bi[i][j]>maxR) {
						a = i;
						b = j;
						
					maxR=bi[i][j];
				//	System.out.println( (char)(i+'a')+ " && "+(char)(j+'a') + "<<--->>"        +   (bi[i][j]) + "max value");
				}
			
			}
		}
		
		System.out.println("word is " + (char)(a+'a')+""+ (char)(b+'a') + "   Count is " + maxR);
		
	}



	private static void unigram(String lines) {
		// TODO Auto-generated method stub
	
		int[] uni = new int[26];
		
		//uni[0] = (int) lines.chars().filter(ch -> ch =='a').count();
		
		 for(int i=0;i<lines.length();i++)
		 {
		 // charAt function returns the char value at the specified index.
		         uni[lines.charAt(i)-'a']++;
		      }
		
		int maxR = Arrays.stream(uni).max().getAsInt();

		int chart = 0;
		for(int i=0 ; i <26;i++) {
			if(uni[i] == maxR) {
				chart = i;
				System.out.println(i + "So char is   ->  " + (char)(i+'a'));
				break;
			}
		

		}
	}

}
