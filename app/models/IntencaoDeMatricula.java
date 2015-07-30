package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class IntencaoDeMatricula{
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "MATRICULA_SEQUENCE", sequenceName = "MATRICULA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Disciplina> disciplinas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Usuario> usuarios;
	
	
	// Construtor vazio para o Hibernate criar os objetos
	public IntencaoDeMatricula (){
		
	}
	
	public IntencaoDeMatricula (String problema){		
		this.disciplinas = new ArrayList<Disciplina>();
		this.usuarios = new ArrayList<Usuario>();
	}

	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public void removeDisciplina(Disciplina disciplina) {
		this.disciplinas.remove(disciplina);
	}

	
	

}
