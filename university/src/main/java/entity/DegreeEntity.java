package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "degree", schema = "university", catalog = "")
public class DegreeEntity {
    private int id;
    private String nameDegree;
    private Collection<LectorEntity> lectorsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_degree")
    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DegreeEntity that = (DegreeEntity) o;

        if (id != that.id) return false;
        if (nameDegree != null ? !nameDegree.equals(that.nameDegree) : that.nameDegree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameDegree != null ? nameDegree.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "degreeByIdDegree")
    public Collection<LectorEntity> getLectorsById() {
        return lectorsById;
    }

    public void setLectorsById(Collection<LectorEntity> lectorsById) {
        this.lectorsById = lectorsById;
    }
}
