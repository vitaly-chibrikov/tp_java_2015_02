package utils;

public class TimeHelper {
	public static void sleep(int period){
		try{
			Thread.sleep(period);
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
	
	public static void sleep(){
		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
}
