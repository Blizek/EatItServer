package eat_it_server;

import eat_it_server.controller.AdditivesController;
import eat_it_server.model.Additives;
import eat_it_server.repository.AdditivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class aaaEatItServerApplication{
	public static void main(String[] args) {
		SpringApplication.run(EatItServerApplication.class, args);
	}
}
