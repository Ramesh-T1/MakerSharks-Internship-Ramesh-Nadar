package makersharks.RESTAPI_Project.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "supplier_details", uniqueConstraints = @UniqueConstraint(columnNames = "location"))
public class SupplierDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="supplier_id")
	public Long id;
	@Size(min=2,message="Name Should have atleast 2 characters")
	@Column(name="company_name")
	public String company;
	public String website;
	@Column(name="location",unique=true)
	public String location;
	@Column(name="nature_of_business")
	public String nob; 
	@Column(name="manufacturing_process")
	public String processes;
	public SupplierDetails() {
		
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getNob() {
		return nob;
	}

	public void setNob(String nob) {
		this.nob = nob;
	}

	public String getProcesses() {
		return processes;
	}

	public void setProcesses(String processes) {
		this.processes = processes;
	}
}
