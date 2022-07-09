package UnitTest.JUnit_5_Proj;

public class BankLoanService {
	
	public double calcSimpleInterest(double pAmt, double rate, double time) {
		
		System.out.println("BankLoanService.calcSimpleInterest()");
		
		if(pAmt<=0 || rate<=0 || time<=0)
			throw new IllegalArgumentException("pAmt,rate or time must not be 0");
		
		
//		try {
//			Thread.sleep(10010);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		double dd = 100/0;
		
		return (pAmt*time*rate)/100;
		
	}
	
	
	
	public String helloString(String name) {
		return "hello "+name;
	}
	public boolean checkEmpty(String name) {
		return name.isBlank();
	}

}
