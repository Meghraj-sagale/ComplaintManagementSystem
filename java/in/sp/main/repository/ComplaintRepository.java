package in.sp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.main.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	
	List<Complaint> findByStatus(String status);
	
}