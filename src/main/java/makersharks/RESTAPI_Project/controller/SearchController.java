package makersharks.RESTAPI_Project.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import makersharks.RESTAPI_Project.app.SupplierDetails;
import makersharks.RESTAPI_Project.dao.SearchDaoService;
import makersharks.RESTAPI_Project.repository.SearchRepository;

@RestController
public class SearchController {
	@Autowired
	SearchDaoService service;
	
	@Autowired
	SearchRepository searchRepository;
	
	@Tag(name = "Get All Supplier")
    //@SecurityRequirement(name = "MakerSharks_API")
	@GetMapping(path="/getSupplier",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveAllSupplier()
	{
		return service.findAll();	
	}
	@Tag(name = "AddSupplier")
	@PostMapping(path="/addSupplier",headers="X-API-VERSION=1")
	public ResponseEntity<SupplierDetails> add(@Valid BindResult br,@RequestBody SupplierDetails sd) {
		SupplierDetails s=service.save(sd);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(s.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	//Using Regex as path for all URL is same
	@Tag(name = "Get Supplier By Id")
	@GetMapping(path="/getSupplier/{supplier_id:\\d+}",headers="X-API-VERSION=1")
	public SupplierDetails retreiveOnSupplier_ID(@PathVariable int supplier_id)
	{
		Optional<SupplierDetails> result=service.findById(supplier_id);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("id"+supplier_id);
		}
		return result.get();	
	}
	@Tag(name = "Get Supplier By Company Name")
	@GetMapping(path="/getSupplier/{company_name:[a-zA-Z]+}",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveOnCompany_Name(@PathVariable String company_name)
	{
		List<SupplierDetails> result=service.findByCompany(company_name);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("company_name"+company_name);
		}
		return result;
	}
	@Tag(name = "Get Supplier By Website")
	@GetMapping(path="/getSupplierByWebsite/{website}",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveOnWebsite(@PathVariable String website)
	{
		List<SupplierDetails> result=service.findByWebsite(website);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("website"+website);
		}
		return result;
	}
	@Tag(name = "Get Supplier By Location")
	@GetMapping(path="/getSupplierByLocation/{location}",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveOnLocation(@PathVariable String location)
	{
		List<SupplierDetails> result=service.findByLocation(location);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("location"+location);
		}
		return result;
	}
	@Tag(name = "Get Supplier By Nature")
	@GetMapping(path="/getSupplierByNature/{nob}",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveOnNatureOfBusiness(@PathVariable String nob)
	{
		List<SupplierDetails> result=service.findByNob(nob);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("Nature of Business"+nob);
		}
		return result;
	}
	@Tag(name = "Get Supplier By Processes")
	@GetMapping(path="/getSupplierByProcesses/{processes}",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveOnManufacturingProcesses(@PathVariable String processes)
	{
		List<SupplierDetails> result=service.findByProcesses(processes);
		if(result.isEmpty())
		{
			throw new UserNotFoundException("process"+processes);
		}
		return result;
	}	
	
	//With Pagination
	@Tag(name = "GetAllSupplier with PAginaion")
	@GetMapping(path="/getSupplierPage",headers="X-API-VERSION=1")
	public List<SupplierDetails> retreiveAllSupplierWithPagination(@RequestParam int pageNo,@RequestParam int pageSize)
	{
		List<SupplierDetails> sdp=service.getAllSupplierWithPagination(pageNo,pageSize);
		return sdp;	
	}
	
}
