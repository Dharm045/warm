package warm.java;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Dharmraj", 10);
		Employee e2 = new Employee("Ayan", 100);
		Employee e3 = new Employee("Dheeraj", 20);
		Employee e4 = new Employee("Deepak", 10);

//		HashMap<EmployeeKey, Employee> map = new HashMap<>();
//
//		System.out.println("put=" + map.put(new EmployeeKey(e1.name), e1));
//		System.out.println("put=" + map.put(new EmployeeKey(e2.name), e2));
//		System.out.println("put=" + map.put(new EmployeeKey(e3.name), e3));
//		System.out.println("put=" + map.put(new EmployeeKey(e4.name), e4));
//		System.out.println("put=" + map.put(new EmployeeKey(e1.name), new Employee("Suraj", 300)));
//
//		System.out.println("Value is e1 " + map.get(new EmployeeKey(e1.name)));
//		System.out.println("Value is e4 " + map.get(new EmployeeKey(e4.name)));

		ConcurrentHashMap<EmployeeKey, Employee> cMap = new ConcurrentHashMap<>();
		
		System.out.println("put=" + cMap.put(new EmployeeKey(e1.name), e1));
		System.out.println("put=" + cMap.put(new EmployeeKey(e2.name), e2));
		System.out.println("put=" + cMap.put(new EmployeeKey(e3.name), e3));
		System.out.println("put=" + cMap.put(new EmployeeKey(e4.name), e4));
		System.out.println("put=" + cMap.put(new EmployeeKey(e1.name), new Employee("Suraj", 300)));

		System.out.println("Value is e1 " + cMap.get(new EmployeeKey(e1.name)));
		System.out.println("Value is e4 " + cMap.get(new EmployeeKey(e4.name)));
		
	}

	static class EmployeeKey extends Object {
		String name;

		public EmployeeKey(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			int hash = name.charAt(0);
			System.out.println("EmployeeKey hashcode for " + name + " is " + hash);
			return hash;
		}

		@Override
		public boolean equals(Object o) {
			boolean isSame = this.name.equals(((EmployeeKey) o).name);
			System.out.println("EmployeeKey equals on Object " + o + " and " + this + " " + isSame);
			return isSame;
		}

		@Override
		public String toString() {
			return "{ name =" + name + " }";
		}
	}

	static class Employee extends Object {

		String name;
		int salary;

		public Employee(String name, int salary) {
			this.name = name;
			this.salary = salary;
		}

		@Override
		public int hashCode() {
			int hash = name.charAt(0);
			System.out.println("hashcode for " + name + " is " + hash);
			return hash;
		}

		@Override
		public boolean equals(Object o) {
			boolean isSame = this.name.equals(((Employee) o).name);
			System.out.println("equals called on " + o + " and  " + this + " " + isSame);
			return isSame;
		}

		@Override
		public String toString() {
			return "{ name=" + name + ", salary=" + salary + "}";
		}
	}

	private static int buckeTindex(int hash, int length) {
		return hash & (length - 1);
	}

}
