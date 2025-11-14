package pageObjects;

public class abc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="this is a string";
		String s1[]=s.split(" ");
	//String	or_rev="";
		for(int i=0;i<=s1.length-1;i++) {
		String	rev="";
		String word=s1[i];
					for(int j=s1[i].length()-1;j>=0;j--) {
						rev=rev+word.charAt(j);
								
					}
					System.out.print(rev+" ");
		}

	}

}
