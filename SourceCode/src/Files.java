import java.io.FileWriter;

public class Files {
	public static void main(String[] args) {
		int flag = 1;
		try {
			FileWriter write = new FileWriter("C:\\Documents\\a.txt");
			write.append("hello"+ " \n");
			write.append("there..!");
			write.close();
		}
		catch(Exception e) {
			System.out.println(e);
			flag = 0;
		}
		finally {
			if(flag == 1) {
				System.out.println("write successful");
			}
			else {
				System.out.println("failed");
			}
		}
	}
}
