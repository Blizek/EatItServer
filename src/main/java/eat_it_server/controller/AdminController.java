package eat_it_server.controller;

import eat_it_server.model.Admin;
import eat_it_server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("")
    public ResponseEntity<List<Admin>> fetchAllAdmins() {
        List<Admin> listOfAllAdmins = adminService.listOfAllAdmins();
        return new ResponseEntity<>(listOfAllAdmins, HttpStatus.OK);
    }
}
