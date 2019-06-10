package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lector", schema = "university", catalog = "")
public class LectorEntity {
    private int id;
    private String name;
    private String lastName;
    private int salary;
    private int idDegree;
    private Collection<DepartmentEntity> departmentsById;
    private DegreeEntity degreeByIdDegree;
    private Collection<LectorsDepartmentsEntity> lectorsDepartmentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "id_degree")
    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LectorEntity that = (LectorEntity) o;

        if (id != that.id) return false;
        if (salary != that.salary) return false;
        if (idDegree != that.idDegree) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + idDegree;
        return result;
    }

    @OneToMany(mappedBy = "lectorByIdHeadDepartment")
    public Collection<DepartmentEntity> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<DepartmentEntity> departmentsById) {
        this.departmentsById = departmentsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_degree", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public DegreeEntity getDegreeByIdDegree() {
        return degreeByIdDegree;
    }

    public void setDegreeByIdDegree(DegreeEntity degreeByIdDegree) {
        this.degreeByIdDegree = degreeByIdDegree;
    }

    @OneToMany(mappedBy = "lectorByIdLector")
    public Collection<LectorsDepartmentsEntity> getLectorsDepartmentsById() {
        return lectorsDepartmentsById;
    }

    public void setLectorsDepartmentsById(Collection<LectorsDepartmentsEntity> lectorsDepartmentsById) {
        this.lectorsDepartmentsById = lectorsDepartmentsById;
    }
}
