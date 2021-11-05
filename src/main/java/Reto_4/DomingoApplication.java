//Categoria, Mensaje, Reservacion, Cliente , Ortesis
//1.Modelo o Entidad
//2.Interface
//3.Repositorio
//4.Servicios
//5.Controlador o Web



package Reto_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Reto_4.modelo"})
public class DomingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomingoApplication.class, args);
	}

}
