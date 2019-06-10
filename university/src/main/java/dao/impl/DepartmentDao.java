package dao.impl;

import dao.IDepartmentDao;
import msghandler.IConstants;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.List;

public class DepartmentDao implements IDepartmentDao, IConstants {
    private Query query;
    private Session session;

    public DepartmentDao() {
    }

    @Override
    public String getHeadOfDepartment(String nameDepartment) {
        prepareRequestToDb(HEAD_DEPARTMENT_QU);
        query.setParameter("nameDepartment", nameDepartment);
        List<Object[]> list = query.list();
        session.close();

        StringBuilder nameHeadOfDepartment = new StringBuilder();
        for (Object obj : list.get(0)) {
            nameHeadOfDepartment.append(obj);
            nameHeadOfDepartment.append(" ");
        }

        return nameHeadOfDepartment.toString();
    }

    @Override
    public List<String> getAllNamesDepartments() {
        prepareRequestToDb(ALL_NAMES_DEPARTMENTS_QU);
        List<String> departmentsNames = query.list();
        session.close();

        return departmentsNames;
    }

    @Override
    public String getStatistic(String nameDepartment) {
        prepareRequestToDb(STATISTIC_QU);
        query.setParameter("nameDepartment", nameDepartment);
        List<Object[]> list = query.list();
        session.close();

        return splitResult(list);
    }

    @Override
    public int getAverageSalary(String nameDepartment) {
        prepareRequestToDb(AVERAGE_SALARY_QU);
        query.setParameter("nameDepartment", nameDepartment);
        List list = query.list();
        session.close();

        Double averageSalary = (Double) list.get(0);

        return averageSalary.intValue();
    }

    @Override
    public int getCountOfEmployeeDepartment(String nameDepartment) {
        prepareRequestToDb(COUNT_OF_EMPLOYEE_QU);
        query.setParameter("nameDepartment", nameDepartment);
        List list = query.list();
        session.close();

        Long countOfEmployee = (Long) list.get(0);

        return countOfEmployee.intValue();
    }

    @Override
    public String getResGlobalSearch(String keyWord) {
        prepareRequestToDb(GLOBAL_SEARCH_QU);
        query.setParameter("keyWord", "%" + keyWord + "%");
        List<Object[]> list = query.list();
        session.close();

        return splitResult(list);
    }

    private void prepareRequestToDb(String request) {
        session = HibernateUtil.getSessionFactory().openSession();
        query = session.createQuery(request);
    }

    private String splitResult(List<Object[]> list) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            for (Object element : list.get(i)) {
                result.append(element);
                result.append(" ");
            }

            if (!(i == list.size() - 1)) {
                result.append(", ");
            }
        }

        return result.toString();
    }
}
