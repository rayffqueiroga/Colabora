package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Random;

@Entity
public class Disciplina {
	
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "DISCIPLINA_SEQUENCE", sequenceName = "DISCIPLINA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String professor;
	
	@Column
	private String sala;
	
	@Column
	private String abreviatura;
	
	@Column
	private String codigo;
	
	@Column
	private int creditos;
	
	@Column
	private boolean estaNoHorario;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Horario> horariosDaDisciplina;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Disciplina(){
		
	}
	
	public Disciplina(String nome, String professor, String sala, String abreviatura, int creditos, String codigo){
		this.nome  = nome;
		this.professor = professor;
		this.sala = sala;
		this.abreviatura = abreviatura;
		this.creditos = creditos;
		this.codigo = codigo;
		this.estaNoHorario = false;
		this.horariosDaDisciplina = new ArrayList<Horario>();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public boolean isEstaNoHorario() {
		return estaNoHorario;
	}

	public void naoMostrarNoHorario() {
		this.estaNoHorario = false;
	}
	
	public void mostrarNoHorario() {
		this.estaNoHorario = true;
	}

	public List<Horario> getHorariosDaDisciplina() {	
		return horariosDaDisciplina;
	}

	public String getHorariosDaDisciplinaToString() {	
		String horarios = "";
		for (Horario h: horariosDaDisciplina)	{
			horarios += h.getDiaDaSemana() +"-"+ h.getHorarioDeInicioDaAula() + "     ";
		}
		return horarios;
	}
	
	public void setHorariosDaDisciplina(List<Horario> horariosDaDisciplina) {
		this.horariosDaDisciplina = horariosDaDisciplina;
	}
	
	public void addNosHorariosDaDisciplina(Horario horario) {
		this.horariosDaDisciplina.add(horario);
	}
	
	public void removeDosHorariosDaDisciplina(Horario horario) {
		if(this.horariosDaDisciplina.contains(horario)){
			this.horariosDaDisciplina.remove(horario);
		}
		
	}
	
	public String retornaIDUnico(String dia){
		return this.id.toString() + dia;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public boolean contemEsseHorario(Horario horario){
		for (Horario meu:this.horariosDaDisciplina){
			if (meu.equals(horario)){
				return true;
				}
			}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abreviatura == null) ? 0 : abreviatura.hashCode());
		result = prime * result + (estaNoHorario ? 1231 : 1237);
		result = prime * result + ((horariosDaDisciplina == null) ? 0 : horariosDaDisciplina.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (abreviatura == null) {
			if (other.abreviatura != null)
				return false;
		} else if (!abreviatura.equals(other.abreviatura))
			return false;
		if (estaNoHorario != other.estaNoHorario)
			return false;
		if (horariosDaDisciplina == null) {
			if (other.horariosDaDisciplina != null)
				return false;
		} else if (!horariosDaDisciplina.equals(other.horariosDaDisciplina))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}

}
