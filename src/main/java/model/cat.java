package model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class cat {
	@Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date ngaySinh;
    private Boolean sex;

    // Constructors
    public cat() {}

    public cat(String name, Date ngaySinh, Boolean sex) {
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.sex = sex;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

	@Override
	public String toString() {
		return "cat [id=" + id + ", name=" + name + ", ngaySinh=" + ngaySinh + ", sex=" + sex + "]";
	}
	
}
