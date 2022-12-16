package com.test.crud.model;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rhrStudent")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long StuId;
	private String StuName;
	private String deptName;
//	// Lazy work for just peck Id And Eager work for all .
//	@OneToOne(cascade = CascadeType.ALL)//fetch = FetchType.EAGER )// CascadeType and fetchType Just Enum.
//	@JoinColumn(name = "address_id", referencedColumnName = "id")
//	private Address address;
//	
	
	//Method Start
	public Long getStuid() {
		return StuId;
	}
	public void setStuid(Long stuId) {
		StuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Student [StuId=" + StuId + ", StuName=" + StuName + ", deptName=" + deptName + "]";
	}

}





//All Annotation:

//StereoType Annotation:
//1.@Component 2.@Service 3.@RestController/Controller 4.@Repository

//Spring Core related annotation:
//	-@Configuration: when i use java base configuration its indicate that class can be use by IOC Container. 
//	-@Bean: return will object
//	-@AutoWired: It will take other classes features
//	-@Qualifier
//	-@Lazy
//	-@Value
//	-@PropertySource
//	-@ConfigurationProperties
//	-@Profile
//	-@Scop

