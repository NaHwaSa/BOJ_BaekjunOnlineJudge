import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] searchOrder = new int[] {
				0,2,6,8,3,4,5,7,9,1
		};		
		String[] numberName = new String[] {
				"ZERO","ONE","TWO","THREE","FOUR"
				,"FIVE","SIX","SEVEN","EIGHT","NINE"
		};
		String[] searchAlphabet = new String[] {
				"Z","O","W","T","R","F","X","V","G","I"
		};
		
		
		int n = Integer.parseInt(br.readLine());		
		
		for (int i = 0; i < n; i++) {
			List<Integer> num = new LinkedList<Integer>();
			String in = br.readLine();
			
			for (int j = 0; j < searchOrder.length; j++) {
				while (in.contains(searchAlphabet[ searchOrder[j] ])) {
					num.add(searchOrder[j]);
					in = removeWord(in, numberName[ searchOrder[j] ]);
				}
			}
			
			Collections.sort(num);
			StringBuffer sb = new StringBuffer();
			sb.append("Case #" + (i+1) + ": ");
			
			Iterator<Integer> it = num.iterator();
			while(it.hasNext()) {
				sb.append(it.next());
			}			
			sb.append("\n");
			bw.write(sb.toString());
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}		
	
	private static String removeWord(String str, String word) {		
		for (int i = 0; i < word.length(); i++) {
			str = str.substring(0, str.indexOf(word.charAt(i))) 
					+ str.substring(str.indexOf(word.charAt(i)) + 1);
		}
		return str;
	}
}
