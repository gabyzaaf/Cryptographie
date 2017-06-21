import java.security.NoSuchAlgorithmException;


public class Main {

	public static void main(String[] args){
		try {
			System.out.println(Sha.createTheHashFromString(null));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
