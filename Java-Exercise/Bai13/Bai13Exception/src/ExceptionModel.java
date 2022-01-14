/**
 * Created by My PC on 15/11/2017.
 */
public class ExceptionModel {
	private int soNguyen;
	private float soThuc;
	private boolean logic;

	public ExceptionModel(int soNguyen) {
		try{this.soNguyen = soNguyen;}
		catch (Exception e){
			System.out.println("Undyfine");
		}
	}
	
	public ExceptionModel(float soThuc) {
		try{this.soThuc = soThuc;}
		catch (Exception e){
			System.out.println("Undyfine");
		}
	}
	
	public ExceptionModel(boolean logic) {
		try{this.logic = logic;}
		catch (Exception e){
			System.out.println("Undyfine");
		}
	}
	
	
}
