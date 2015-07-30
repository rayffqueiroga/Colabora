package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Problema{
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "PROBLEMA_SEQUENCE", sequenceName = "PROBLEMA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
	
	@Column
	private String problema;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Disciplina> disciplinas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Usuario> usuarios;
	
	
	// Construtor vazio para o Hibernate criar os objetos
	public Problema (){
		
	}
	
	public Problema (String problema){
		this.problema = problema;
		this.disciplinas = new ArrayList<Disciplina>();
		this.usuarios = new ArrayList<Usuario>();
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public void removeDisciplina(Disciplina disciplina) {
		this.disciplinas.remove(disciplina);
	}

	public void addUsuario(Usuario usuario){
		this.usuarios.add(usuario);
	}
	
	public String getNomeDisciplina(){
		String nomeDisc = "";
		for (Disciplina d: disciplinas){
			nomeDisc = nomeDisc + d.getNome();
		}
		return nomeDisc;
	}
	
	
	

}
