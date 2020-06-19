package ar.edu.unju.fi.testeos.model;

import javax.persistence.*;

import com.sun.istack.NotNull;

import ar.edu.unju.fi.enumerado.TipoUsuarioEnumerado;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	@NotNull
	@Column(name = "password")
	private String password;
	@NotNull
	@Column(name = "nombre_real")
	private String nombreReal;
	@NotNull
	@Column(name = "apellido_real")
	private String apellidoReal;
	@NotNull
	@Enumerated(EnumType.STRING) // Toma el valor del enumerado y lo guarda en la columna de la tabla.
	@Column(name = "tipo_usuario")
	private TipoUsuarioEnumerado tipoUsuario;

	/**
	 * Constructor sin parametros.
	 */
	public Usuario() {

	}

	/**
	 * Constructor con parametros.
	 * 
	 * @param id
	 * @param nombreUsuario
	 * @param password
	 * @param nombreReal
	 * @param apellidoReal
	 * @param tipoUsuario
	 */
	public Usuario(Long id, String nombreUsuario, String password, String nombreReal, String apellidoReal,
			TipoUsuarioEnumerado tipoUsuario) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombreReal
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	/**
	 * @param nombreReal the nombreReal to set
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	/**
	 * @return the apellidoReal
	 */
	public String getApellidoReal() {
		return apellidoReal;
	}

	/**
	 * @param apellidoReal the apellidoReal to set
	 */
	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}

	/**
	 * @return the tipoUsuario
	 */
	public TipoUsuarioEnumerado getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuarioEnumerado tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal="
				+ nombreReal + ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}

}
