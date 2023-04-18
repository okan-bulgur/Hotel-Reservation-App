public class Employees implements Calculable{
	
	String name;
	String surname;
	double monthlyPayment;
	int id;
	
	public Employees(String name, String surname, double monthlyPayment, int id){
		setName(name);
		setSurname(surname);
		setMonthlyPayment(monthlyPayment);
		setId(id);
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
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public double getCost() {
		return getMonthlyPayment();
	}
	
	@Override
	public String toString() {
		return "Employees [name=" + getName() + ", surname=" + getSurname() + ", monthlyPayment=" + getMonthlyPayment() + ", id=" + getId() + "]";
	}
}
