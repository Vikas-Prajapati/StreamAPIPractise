import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    List<String> address1 = List.of("add11", "add12", "add13");
    List<String> address2 = List.of("add21", "add22", "add23");
    List<String> address3 = List.of("add31", "add32", "add33");
    List<String> address4 = List.of("add11", "add22", "add33");
    Department department1 = new Department(1L, "dept1", address1);
    Department department2 = new Department(2L, "dept2", address2);
    Department department3 = new Department(3L, "dept3", address3);
    Department department4 = new Department(4L, "dept4", address4);
    Employee employee1 = new Employee("emp1", 21, 100_000_00, department1.getId());
    Employee employee2 = new Employee("emp2", 24, 200_00_00, department2.getId());
    Employee employee3 = new Employee("emp3", 25, 100_00_00, department3.getId());
    Employee employee4 = new Employee("emp4", 22, 10_000_00, department1.getId());
    Employee employee5 = new Employee("emp5", 27, 500_000_00, department1.getId());
    Employee employee6 = new Employee("emp6", 27, 700_000_00, department2.getId());

    public static void main(String[] args) {
        Long id = 2L;

        //for a given id
        Main main = new Main();
        Optional<Department> temp = main.getDepartmentById(2L);

        //For a given Employee Name return Employee Object;
        String name = "emp5";
        Optional<Employee> employee = main.getEmployees().stream().filter(employee7 -> employee7.getName().equalsIgnoreCase(name)).findFirst();

        //For a given Employee name return the Department
        Optional<Department> department = main.getEmployees().stream().filter(employee7 -> employee7.getName().equalsIgnoreCase(name)).map(employee7 -> main.getDepartmentById(employee7.getDepartmentId())).flatMap(Optional::stream).findFirst();

        System.out.println(department.get().getName());

        //Given a list of employee return the addresses.
        List<String> str = List.of("emp1", "emp2");
        Set<String> addresses = main.getEmployees().stream()
                .filter(employee7 -> str.contains(employee7.getName()))
                .map(employee7 -> main.getDepartmentById(employee7.getDepartmentId()))
                .filter(Optional::isPresent).map(Optional::get)
                .map(Department::getAddress)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        System.out.println(addresses);

        //Need a department in which no employee exists
//        List<Department> departmentWithNoEmployee = main.getDepartments().stream()
//                        .filter(department5 -> main.getEmployees().forEach(
//                                employee7 ->
//                        ));
//
//        main.getDepartments().c;

//        System.out.println(main.);
    }

    /**
     * Gets whether a department is present or Not.
     *
     * @param Id
     * @return
     */
    Optional<Department> getDepartmentById(Long Id) {
//        return getDepartments().stream().anyMatch(department -> department.getId() == Id);
        return getDepartments().stream().filter(department -> department.getId() == Id).findAny();
    }

    List<Employee> getEmployees() {
        return List.of(employee1, employee2, employee3, employee4, employee5, employee6);
    }

    List<Department> getDepartments() {
        return List.of(department1, department2, department3, department4);
    }


}