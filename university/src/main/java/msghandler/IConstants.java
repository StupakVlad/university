package msghandler;

public interface IConstants {
    String[] MENU = {"*******You can request such information*****************************\n",
            "- Who is head of department \"department name\"?\n",
            "- Show \"department name\" statistic\n",
            "- Show the average salary for department \"department name\"\n",
            "- Show count of employee for \"department name\"\n",
            "- Global search by \"key word\"\n",
            "- Exit\n",
            "***************************************************************"};

    String WELCOME_MSG = "\nHi! I am a university Bot. How can I help you?\n";
    String INCORRECT_REQUEST_MSG = "\n***Incorrect request or result not found! Please correct and try again!***";

    String HEAD_DEPARTMENT_QU = "SELECT le.name, le.lastName FROM LectorEntity le JOIN le.departmentsById dbi WHERE dbi.nameDepartment = :nameDepartment";
    String STATISTIC_QU = "SELECT le.degreeByIdDegree.nameDegree, count(le.degreeByIdDegree) FROM LectorEntity le JOIN le.lectorsDepartmentsById ldbi JOIN ldbi.departmentByIdDepartment dbid WHERE dbid.nameDepartment = :nameDepartment GROUP BY le.degreeByIdDegree";
    String ALL_NAMES_DEPARTMENTS_QU = "SELECT de.nameDepartment FROM DepartmentEntity de";
    String AVERAGE_SALARY_QU = "SELECT avg(le.salary) FROM LectorEntity le JOIN le.lectorsDepartmentsById ldbi JOIN ldbi.departmentByIdDepartment dbid WHERE dbid.nameDepartment = :nameDepartment";
    String COUNT_OF_EMPLOYEE_QU = "SELECT count(le.lastName) FROM LectorEntity le JOIN le.lectorsDepartmentsById ldbi JOIN ldbi.departmentByIdDepartment dbid WHERE dbid.nameDepartment = :nameDepartment";
    String GLOBAL_SEARCH_QU = "SELECT l.name, l.lastName FROM LectorEntity l WHERE l.name LIKE :keyWord OR l.lastName LIKE :keyWord";
}
