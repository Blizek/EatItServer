package eat_it_server.service;

import eat_it_server.model.Admin;
import eat_it_server.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> listOfAllAdmins() {
        return adminRepository.findAll();
    }

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin getAdmin(Integer id) {
        return adminRepository.findById(id).get();
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}
