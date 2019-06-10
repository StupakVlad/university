package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "department", schema = "university", catalog = "")
public class DepartmentEntity {
    private int id;
    private String nameDepartment;
    private int idHeadDepartment;
    private LectorEntity lectorByIdHeadDepartment;
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
    @Column(name = "name_department")
    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    @Basic
    @Column(name = "id_head_department", insertable = false, updatable = false)
    public int getIdHeadDepartment() {
        return idHeadDepartment;
    }

    public void setIdHeadDepartment(int idHeadDepartment) {
        this.idHeadDepartment = idHeadDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (id != that.id) return false;
        if (idHeadDepartment != that.idHeadDepartment) return false;
        if (nameDepartment != null ? !nameDepartment.equals(that.nameDepartment) : that.nameDepartment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameDepartment != null ? nameDepartment.hashCode() : 0);
        result = 31 * result + idHeadDepartment;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_head_department", referencedColumnName = "id", nullable = false)
    public LectorEntity getLectorByIdHeadDepartment() {
        return lectorByIdHeadDepartment;
    }

    public void setLectorByIdHeadDepartment(LectorEntity lectorByIdHeadDepartment) {
        this.lectorByIdHeadDepartment = lectorByIdHeadDepartment;
    }

    @OneToMany(mappedBy = "departmentByIdDepartment")
    public Collection<LectorsDepartmentsEntity> getLectorsDepartmentsById() {
        return lectorsDepartmentsById;
    }

    public void setLectorsDepartmentsById(Collection<LectorsDepartmentsEntity> lectorsDepartmentsById) {
        this.lectorsDepartmentsById = lectorsDepartmentsById;
    }
}
