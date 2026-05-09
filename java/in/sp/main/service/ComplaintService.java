package in.sp.main.service;

import java.util.List;
import in.sp.main.entity.Complaint;

public interface ComplaintService {

    List<Complaint> getAll();

    List<Complaint> getByStatus(String status);
    
    Complaint getById(Long id);

    void save(Complaint c);

    void delete(Long id);

	
    
    
    
    
}