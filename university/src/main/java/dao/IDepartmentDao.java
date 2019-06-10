package dao;

import java.util.List;

public interface IDepartmentDao {
    String getHeadOfDepartment(String nameDepartment);
    List<String> getAllNamesDepartments();
    String getStatistic(String nameDepartment);
    int getAverageSalary(String nameDepartment);
    int getCountOfEmployeeDepartment(String nameDepartment);
    String getResGlobalSearch(String keyWord);
}
