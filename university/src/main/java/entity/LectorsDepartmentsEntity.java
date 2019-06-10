package entity;

import javax.persistence.*;

@Entity
@Table(name = "lectors_departments", schema = "university", catalog = "")
public class LectorsDepartmentsEntity {
    private int id;
    private Integer idLector;
    private Integer idDepartment;
    private LectorEntity lectorByIdLector;
    private DepartmentEntity departmentByIdDepartment;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_lector", insertable = false, updatable = false)
    public Integer getIdLector() {
        return idLector;
    }

    public void setIdLector(Integer idLector) {
        this.idLector = idLector;
    }

    @Basic
    @Column(name = "id_department", insertable = false, updatable = false)
    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LectorsDepartmentsEntity that = (LectorsDepartmentsEntity) o;

        if (id != that.id) return false;
        if (idLector != null ? !idLector.equals(that.idLector) : that.idLector != null) return false;
        if (idDepartment != null ? !idDepartment.equals(that.idDepartment) : that.idDepartment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idLector != null ? idLector.hashCode() : 0);
        result = 31 * result + (idDepartment != null ? idDepartment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_lector", referencedColumnName = "id")
    public LectorEntity getLectorByIdLector() {
        return lectorByIdLector;
    }

    public void setLectorByIdLector(LectorEntity lectorByIdLector) {
        this.lectorByIdLector = lectorByIdLector;
    }

    @ManyToOne
    @JoinColumn(name = "id_department", referencedColumnName = "id")
    public DepartmentEntity getDepartmentByIdDepartment() {
        return departmentByIdDepartment;
    }

    public void setDepartmentByIdDepartment(DepartmentEntity departmentByIdDepartment) {
        this.departmentByIdDepartment = departmentByIdDepartment;
    }
}
