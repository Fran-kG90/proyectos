package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cliente_id;
	private String nombre_usuario;
	private String password;
	private String nombre;
	private String apellidos;
	private String correo_electronico;
	private int edad;
	private double estatura;
	private double peso;
	private double imc;
	private double geb;

	
	 
	
	public Cliente( String nombre_usuario, String password, String nombre, String apellidos,
			String correo_electronico, int edad, double estatura, double peso, double imc, double geb) {
		super();
//		this.cliente_id = cliente_id;
		this.nombre_usuario = nombre_usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
		this.edad = edad;
		this.estatura = estatura;
		this.peso = peso;
		this.imc = imc;//masa corporal
		this.geb = geb;//gasto energetico
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public double getGeb() {
		return geb;
	}
	public void setGeb(double geb) {
		this.geb = geb;
	}

	
	@Override
	public String toString() {
		return "Cliente [cliente_id=" + cliente_id + ", nombre_usuario=" + nombre_usuario + ", password=" + password
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo_electronico=" + correo_electronico
				+ ", edad=" + edad + ", estatura=" + estatura + ", peso=" + peso + ", imc=" + imc + ", geb=" + geb
				+ ", fecha_c=" + "]";
	}
	
	
	
	

}
