package dietprojectview.newdietview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dietprojectmodel.dietmodel"})
public class NewdietviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewdietviewApplication.class, args);
	}

}
