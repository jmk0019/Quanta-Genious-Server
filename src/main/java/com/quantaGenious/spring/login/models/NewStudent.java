package com.quantaGenious.spring.login.models;


import javax.persistence.*;

@Entity
@Table(name="students")
public class NewStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 45)
    private int id;
    @Column(name = "sname",length = 255)
    private String sname;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", semail='" + semail + '\'' +
                ", spassword='" + spassword + '\'' +
                ", courseDetails='" + courseDetails + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public NewStudent(int id, String sname, String semail, String spassword, String courseDetails) {
        this.id = id;
        this.sname = sname;
        this.semail = semail;
        this.spassword = spassword;
        this.courseDetails = courseDetails;
    }

    public NewStudent() {
    }

    @Column(name="semail",length = 45)
    private String semail;
    @Column(name="spassword",length = 255)
    private String spassword;
    @Column(name="courseDetails",length = 255)
    // @Enumerated(EnumType.ORDINAL)
    private String courseDetails;

}
