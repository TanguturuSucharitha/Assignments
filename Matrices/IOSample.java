
public class IOSample {

	public static void main(String[] args) {
		String str="Suchi";
		int n= str.length();
		int [] freq =new int[n];
		int i,j;
		char string[]=str.toCharArray();
		for(i=0;i<str.length();i++) {
			freq[i]=1;
		for(j=i+1;j<str.length();j++) {
			if(string[i]==string[j]) {
		
			  freq[i]++;
		      string[j]='0';
			}
			
		}
		}
		System.out.println("chars n freqs");
		for(i=0;i<freq.length;i++)
			if(string[i]!=' ' && string[i]!='0')
				System.out.println(string[i]+"-"+freq[i]);
	}
}
	    
	

			
		    
		
		

	


