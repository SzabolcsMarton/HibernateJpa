package hibernatemain;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.jpa.HibernatePersistenceProvider;

import hibernateutil.HibernateUtil;
import model.Employee;

public class HibernateMain {

    public static void main(String[] args) {

	// Save data to "db" with Hibernate
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();

	Employee emp = new Employee();
	emp.setFirstName("Sanyi" + new Random().nextInt(100));
	emp.setLastName("Bácsi");
	emp.setAge(30);
	emp.setSex('m');
	emp.setBirth(LocalDate.now());

	session.persist(emp);
	session.flush();
	session.getTransaction().commit();

	EntityManagerFactory entityManagerFactory = (new HibernatePersistenceProvider())
		.createEntityManagerFactory("employee", null);
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	
	//Read data from "db" with Jpa EntityManager
	@SuppressWarnings("unchecked")
	List<Employee> listEmployee = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

	if (listEmployee == null) {
	    System.out.println("No employee found . ");
	} else {
	    for (Employee empl : listEmployee) {
		System.out.println(empl);
	    }

	    int pk = listEmployee.get(listEmployee.size() - 1).getId();
	    Employee employee = entityManager.find(Employee.class, pk);
	    System.out.println();
	    System.out.println(employee);

	}

	HibernateUtil.shutdown();

    }
}
