public class Employees implements Calculable{
	
	String name;
	String surname;
	int id;
	double monthlyPayment;
	
	static double totalMonthlyPayments = 0;
	
	public Employees(String name, String surname, int id, double monthlyPayment){
		setName(name);
		setSurname(surname);
		setId(id);
		setMonthlyPayment(monthlyPayment);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		totalMonthlyPayments += monthlyPayment;
		this.monthlyPayment = monthlyPayment;
	}

	public double getCost() {
		return totalMonthlyPayments;
	}
	
	@Override
	public String toString() {
		return "Employees [name=" + getName() + ", surname=" + getSurname() + ", monthlyPayment=" + getMonthlyPayment() + ", id=" + getId() + "]";
	}
}
