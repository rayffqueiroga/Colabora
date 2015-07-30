package models;

import javax.persistence.*;


@Entity
public class Usuario{
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "PESSOA_SEQUENCE", sequenceName = "PESSOA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
	
	@Column
	private String senha;
	
	@Column
	private String email;
	
	@Column
	private boolean isAluno;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Usuario (){
		
	}
	
	public Usuario (String email, String senha, boolean isAluno){
		this.email = email;
		this.senha = senha;
		this.isAluno = isAluno;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean getIsAluno() {
		return isAluno;
	}

	public void setIsAluno(boolean isAluno) {
		this.isAluno = isAluno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (isAluno ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (isAluno != other.isAluno)
			return false;
		return true;
	}	

}
