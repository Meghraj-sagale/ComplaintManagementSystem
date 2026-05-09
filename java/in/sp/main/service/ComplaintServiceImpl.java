package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Complaint;
import in.sp.main.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {


	@Autowired
	private ComplaintRepository repo;

	@Override
    public List<Complaint> getAll() {
        return repo.findAll();
    }

    public Complaint getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Complaint c) {
        repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

	@Override
	public List<Complaint> getByStatus(String status) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
    
    
    
   
    
  
}