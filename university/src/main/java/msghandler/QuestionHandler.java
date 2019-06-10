package msghandler;

import dao.impl.DepartmentDao;

import java.util.List;

import static msghandler.IConstants.INCORRECT_REQUEST_MSG;

public enum QuestionHandler {
    WHO_IS_HEAD("who is head") {
        @Override
        public Object getData(DepartmentDao departmentDao, String inputQuestion) {
            departmentName = searchNameDepartment(inputQuestion, departmentDao);
            if (departmentName != null) {
                return "\nAnswer: Head of " + departmentName + " department is " + departmentDao.getHeadOfDepartment(departmentName);
            }

            return INCORRECT_REQUEST_MSG;
        }
    },
    STATISTIC("statistic") {
        @Override
        public Object getData(DepartmentDao departmentDao, String inputQuestion) {
            departmentName = searchNameDepartment(inputQuestion, departmentDao);
            if (departmentName != null) {
                return "\nAnswer: " + departmentDao.getStatistic(departmentName);
            }

            return INCORRECT_REQUEST_MSG;
        }
    },
    AVERAGE_SALARY("average salary") {
        @Override
        public Object getData(DepartmentDao departmentDao, String inputQuestion) {
            departmentName = searchNameDepartment(inputQuestion, departmentDao);
            if (departmentName != null) {
                return "\nAnswer: The average salary of " + departmentName + " is " + departmentDao.getAverageSalary(departmentName);
            }

            return INCORRECT_REQUEST_MSG;
        }
    },
    COUNT_OF_EMPLOYEE("count of employee") {
        @Override
        public Object getData(DepartmentDao departmentDao, String inputQuestion) {
            departmentName = searchNameDepartment(inputQuestion, departmentDao);
            if (departmentName != null) {
                return "\nAnswer: " + departmentDao.getCountOfEmployeeDepartment(departmentName);
            }

            return INCORRECT_REQUEST_MSG;
        }
    },
    GLOBAL_SEARCH("global search by ") {
        @Override
        public Object getData(DepartmentDao departmentDao, String inputQuestion) {
            String answer = departmentDao.getResGlobalSearch(inputQuestion.replace(getTitle(), ""));
            answer = answer.isEmpty() ? "result not found" : answer;
            return "\nAnswer: " + answer;
        }
    };

    private String title;
    public String departmentName;

    QuestionHandler(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String searchNameDepartment(String question, DepartmentDao departmentDao) {
        List<String> nameAllDepartments = departmentDao.getAllNamesDepartments();

        for (String nameDepartment : nameAllDepartments) {
            if (question.toLowerCase().contains(nameDepartment.toLowerCase())) {
                return nameDepartment;
            }
        }

        return null;
    }

    public abstract Object getData(DepartmentDao departmentDao, String inputQuestion);
}
