package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileSystem {

	private File file;
	private BufferedReader bReader = null;
	private String[] word; // 단어 수
	private int[] alpha; // 각 단어 첫 알파벳 카운트
	private int line;  // 문장 수
	private int lineLen;  // 전체글자 수
	private int count; // 필요로 의해 만든 변수

	public FileSystem(String pwd) throws Exception { // 생성자, 맴버변수 초기화
		this.file = new File(pwd);
		this.bReader = new BufferedReader(new FileReader(file));
		this.word = new String[1024];
		this.alpha = new int[26];
		this.line = 0;
		this.lineLen = 0;
		this.count = 0;
	}

	private void readFile() throws Exception {                    // READ FILE
		String s = null;
		while ((s = this.bReader.readLine()) != null) {
			s = s.trim();
			splitString(s);
		}
		this.word[count] = "<eof>";
	}

	private void splitString(String s) {                             // SPLIT STRING
		for (int k = 0; k < s.split(" ").length; k++) {
			this.word[count++] = s.split("\\s")[k];
		}
		this.lineLen += s.length();
		this.line++;
	}

	private void firstAlpha() {                                       // FIRST ALPHABAT
		int k = 0;
		while (this.word[k] != null) {
			if(this.word[k].equals("")) {
				k++;
			}
			else if (this.word[k].toLowerCase().charAt(0) >= 97 && this.word[k].toLowerCase().charAt(0) <= 122) {
				this.alpha[word[k].toLowerCase().charAt(0) - 97]++;
				k++;
			}
			else {
				k++;
			}
		}
	}

	private void printFirstAlpha() {                                 // JUST PRINT
		for (char ch = 97; ch < 123; ch++) {
			System.out.println(ch + " : " + this.alpha[ch - 97] + " 개");
		}
	}

	private void printLine() {                                        // JUST PRINT
		System.out.println("Line : " + this.line);
	}

	private void printCountWord() {                              // JUST PRINT
		int co = 0;
		for (int k = 0; k < word.length; k++) {
			if(word[k].equals("<eof>")) {
				System.out.println("word : " + co);
				break;
			}
			else {
				co++;
			}
		}
	}

	private void printLineLen() {                                   // JUST PRINT
		System.out.println("Len : " + this.lineLen);
	}

	private void showDetail() {                                    // PRINT HANDLER

		printLine();
		printLineLen();
		printCountWord();
		printFirstAlpha();
	}

	public void Handler() throws Exception {                  // HANDLER
		readFile();
		firstAlpha();
		showDetail();
	}
}
