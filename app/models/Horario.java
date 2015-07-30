package models;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
public class Horario {
	@Id
	@SequenceGenerator(name = "HORARIO_SEQUENCE", sequenceName = "HORARIO_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@Column
	private int horarioDeInicioDaAula;
	
	@Column
	@Enumerated(value = EnumType.ORDINAL)
	@NotNull
	private DiaDaSemana diaDaSemana; 
	
	// Construtor vazio para o Hibernate criar os objetos
	public Horario(){
			
	}
	
	public Horario(DiaDaSemana diaDaSemana, int horarioDeInicioDaAula){
		this.horarioDeInicioDaAula = horarioDeInicioDaAula;
		this.diaDaSemana = diaDaSemana;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public int getHorarioDeInicioDaAula() {
		return horarioDeInicioDaAula;
	}

	public void setHorarioDeInicioDaAUla(int horarioDeInicioDaAUla) {
		this.horarioDeInicioDaAula = horarioDeInicioDaAUla;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + horarioDeInicioDaAula;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Horario other = (Horario) obj;
		if (other.diaDaSemana.equals(this.diaDaSemana) && other.getHorarioDeInicioDaAula() == this.horarioDeInicioDaAula){
			return true;
		}
		return false;
	}
	
	
	
	


}
