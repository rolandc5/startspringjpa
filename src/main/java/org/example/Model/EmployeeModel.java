package org.example.Model;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String middleInitial;
    @NotNull
    private String email;
    @NotNull
    private Boolean isManager;
    public EmployeeModel() {
    }

    public EmployeeModel(EmployeeModel body) {
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();
        this.middleInitial = body.getMiddleInitial();
        this.email = body.getEmail();
        this.isManager = body.getIsManager();
    }

    //    @ManyToOne
//    @JoinColumn(name = "manager_id")
//    private EmployeeModel manager;
//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private DepartmentModel department;
//    @ManyToOne
//    @JoinColumn(name = "job_title_id")
//    private JobTitleModel jobTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
     }

     public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }
//
//    public JobTitleModel getJobTitle() {
//        return jobTitle;
//    }
//
//    public DepartmentModel getDepartment() {
//        return department;
//    }
//
//    public EmployeeModel getManager() {
//        return manager;
//    }

}
