package com.example.demo;


import com.example.demo.servletClass.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean<SaludameServlet> saludameServlet() {
		return new ServletRegistrationBean<>(new SaludameServlet(), "/saludame");
	}

	@Bean
	public ServletRegistrationBean<HolaMundoServlet> HolaMundoServlet() {
		return new ServletRegistrationBean<>(new HolaMundoServlet(), "/holamundo");
	}

	@Bean
	public ServletRegistrationBean<TablaMultiplicarServlet> TablaMultiplicarServlet() {
		return new ServletRegistrationBean<>(new TablaMultiplicarServlet(), "/tablamultiplicar");
	}

	@Bean
	public ServletRegistrationBean<CerrarSesionServlet> cerrarSesionServletServletRegistrationBean() {
		return new ServletRegistrationBean<>(new CerrarSesionServlet(), "/cerrarsesion");
	}

	@Bean
	public ServletRegistrationBean<HolaCookies> holaCookiesServletRegistrationBean() {
		return new ServletRegistrationBean<>(new HolaCookies(), "/cookies");
	}


}

