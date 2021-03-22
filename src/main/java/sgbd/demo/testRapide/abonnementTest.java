package sgbd.demo.testRapide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import sgbd.demo.business.service.AbonnementService;
import sgbd.demo.data_access.entity.Abonnement;
import sgbd.demo.exeption.AbonnementFoundExeption;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;


@SpringBootApplication
@ComponentScan("sgbd.demo")
class AbonnementTest {
    public static void main(String[] args) throws ElementExisteExeption, ElementFoundException {
        ApplicationContext ctx = SpringApplication.run(AbonnementTest.class, args);
        AbonnementService serv = ctx.getBean(AbonnementService.class);

        try{
			System.out.println( serv.readOne(1) );
		}
		catch (AbonnementFoundExeption e){
			System.out.println(e.getMessage());
		}

        }
}
