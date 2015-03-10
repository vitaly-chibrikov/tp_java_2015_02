package example;

public class TimeHelper {
	public static void sleep(int period){
		try{
			Thread.sleep(period);
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
}
