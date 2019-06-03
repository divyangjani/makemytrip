package utills;

import java.io.IOException;

public class Data2 {
	
	public static void main(String[] args) {
		
		 String path=System.getProperty("user.dir");
		try {
			Data data = new Data(path+"/Excel/login.xlsx", "Sheet1");
			data.getdata(0, 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
