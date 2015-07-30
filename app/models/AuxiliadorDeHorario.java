package models;

import java.util.ArrayList;
import java.util.List;

public class AuxiliadorDeHorario {
	private List<Disciplina> disciplinas;
	
	public AuxiliadorDeHorario(List<Disciplina> disciplinas){
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	private List<Disciplina> retornaDisciplinasExibiveisPeloDiaEHorario(Horario horario){
		List<Disciplina> retorno = new ArrayList<Disciplina>();
		
		for (Disciplina disciplina:retornaDisciplinasQueDevemSerExibidasNoHorario()){
			if (disciplina.contemEsseHorario(horario)){
				retorno.add(disciplina);
			}
			}
		
		
		return retorno;
	}
	
	private List<Disciplina> retornaDisciplinasQueDevemSerExibidasNoHorario(){
		List<Disciplina> retorno = new ArrayList<Disciplina>();
		for(Disciplina disciplina:this.disciplinas){
			if(disciplina.isEstaNoHorario()){
				retorno.add(disciplina);
			}
		}
		
		return retorno;
	}
	
	public List<Disciplina> retornaDisciplinasQueNãoDevemSerExibidasNoHorário(){
		List<Disciplina> retorno = new ArrayList<Disciplina>();
		for(Disciplina disciplina:this.disciplinas){
			if(!disciplina.isEstaNoHorario()){
				retorno.add(disciplina);
			}
		}
		return retorno;
	}
	
	public List<Disciplina> retornaDisciplinasExibiveis(int dia, int horario){
		Horario horarioPesquisado = new Horario(defineDiaDaSemanaRecebendoInt(dia), horario);	
		return retornaDisciplinasExibiveisPeloDiaEHorario(horarioPesquisado);
	}
	
	private DiaDaSemana defineDiaDaSemanaRecebendoInt(int dia){
		DiaDaSemana segunda = DiaDaSemana.SEGUNDA;
		if (dia == 3){
			return DiaDaSemana.TERCA;
		} else if (dia == 4){
			return DiaDaSemana.QUARTA;
		} else if (dia == 5){
			return DiaDaSemana.QUINTA;
		} else if (dia == 6){
			return DiaDaSemana.SEXTA;
		} 
		return segunda;
	}

}
