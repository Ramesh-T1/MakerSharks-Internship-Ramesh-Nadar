package makersharks.RESTAPI_Project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import makersharks.RESTAPI_Project.app.SupplierDetails;
import makersharks.RESTAPI_Project.repository.SearchRepository;

@Component
public class SearchDaoService {
	@Autowired
	SearchRepository searchrepository;

	public List<SupplierDetails> findAll() {		
		return searchrepository.findAll() ;
	}

	public SupplierDetails save(SupplierDetails sd) {
		return searchrepository.save(sd);		
	}

	public Optional<SupplierDetails> findById(int supplier_id) {
		return searchrepository.findById(supplier_id);
	}

	public List<SupplierDetails> findByCompany(String company_name) {
		return searchrepository.findByCompany(company_name);
	}

	public List<SupplierDetails> findByWebsite(String website) {
		return searchrepository.findByWebsite(website);
	}

	public List<SupplierDetails> findByLocation(String location) {
		return searchrepository.findByLocation(location);
	}

	public List<SupplierDetails> findByNob(String nob) {
		return searchrepository.findByNob(nob);
	}

	public List<SupplierDetails> findByProcesses(String processes) {
		return searchrepository.findByProcesses(processes);
	}

	public List<SupplierDetails> getAllSupplierWithPagination(int pageNo, int pageSize) {
        PageRequest pageable=PageRequest.of(pageNo-1, pageSize);
		return searchrepository.findAll(pageable).getContent();
	}

}
