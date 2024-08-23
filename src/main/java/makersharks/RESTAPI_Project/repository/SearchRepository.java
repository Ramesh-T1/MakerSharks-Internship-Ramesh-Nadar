package makersharks.RESTAPI_Project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import makersharks.RESTAPI_Project.app.SupplierDetails;

public interface SearchRepository extends JpaRepository<SupplierDetails,Long> {

	Optional<SupplierDetails> findById(int supplier_id);

	List<SupplierDetails> findByCompany(String company_name);

	List<SupplierDetails> findByWebsite(String website);

	List<SupplierDetails> findByLocation(String location);

	List<SupplierDetails> findByNob(String nob);

	List<SupplierDetails> findByProcesses(String processes);

}
