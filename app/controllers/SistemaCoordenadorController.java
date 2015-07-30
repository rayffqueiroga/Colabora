package controllers;

import java.util.*;
import models.*;
import models.dao.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.db.jpa.Transactional;
import play.data.Form;
import static play.data.Form.form;


public class SistemaCoordenadorController extends Controller {
	
	// INICIO DA DECLARACAO DE VARIAVEIS
	private static GenericDAO dao = new GenericDAO();
	private static Form<Disciplina> form = Form.form(Disciplina.class);
	// FIM DA DECLARACAO DE VARIAVEIS
	
	private static List<Disciplina> retornaDisciplinasCadastradas(){
		return dao.findAllByClass(Disciplina.class);
	}
	
	private static List<Problema> retornaIndicacoesDeProblemas(){
		return dao.findAllByClass(Problema.class);
	}
	
	@Transactional
	public static Result sistemaCoordenador() {
		AuxiliadorDeHorario auxiliador = new AuxiliadorDeHorario(retornaDisciplinasCadastradas());
		return ok(sistemaCoordenador.render(auxiliador));
    }
	
	@Transactional	
	public static Result listDisciplinas() {
        return ok(listDisciplinas.render(retornaDisciplinasCadastradas()));
    }
	
	@Transactional
	public static Result listaDeProblemas(){
		return ok(listProblemas.render(retornaIndicacoesDeProblemas()));
	}
	
	@Transactional	
	public static Result novaDisciplina() {
        return ok(newdisciplina.render("Your new application is ready."));
    }
	
	@Transactional	
	public static Result listaDeDisciplinas() {
        return ok(listDisciplinas.render(retornaDisciplinasCadastradas()));
    }
	
	@Transactional
	public static Result salvarAlteracao(Long id){
		String codigo = form().bindFromRequest().get("codigo");
		String nome = form().bindFromRequest().get("nome");
		String creditos = form().bindFromRequest().get("creditos");
		int creditosInt = Integer.parseInt(creditos);
		String sala = form().bindFromRequest().get("sala");
		String professor = form().bindFromRequest().get("professor");
		String abreviatura = form().bindFromRequest().get("abreviatura");

		Disciplina disciplina = retornaDisciplina(id);
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);			
		disciplina.setCreditos(creditosInt);
		disciplina.setSala(sala);
		disciplina.setProfessor(professor);
		disciplina.setAbreviatura(abreviatura);
		disciplina.mostrarNoHorario();
		dao.merge(disciplina);

		dao.flush();

		flash("success", "Mudanca efetuada com sucesso.");
		return sistemaCoordenador();
	}
	
	@Transactional
	public static Result removeDisciplinaDoHorario(Long id){
		Disciplina disciplina = retornaDisciplina(id);
		disciplina.naoMostrarNoHorario();
		dao.merge(disciplina);
		dao.flush();
		flash("success", "Disciplina removida com sucesso!");
		return sistemaCoordenador();
	}
	
	@Transactional
	public static Result adicionaDiscipliNoHorario(Long id){
		Disciplina disciplina = retornaDisciplina(id);
		disciplina.mostrarNoHorario();
		
		disciplina.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
		
		dao.merge(disciplina);
		dao.flush();
		flash("success", "Disciplina adicionada com sucesso!");
		return ok(listDisciplinas.render(retornaDisciplinasCadastradas()));
	}
	
	@Transactional
	public static Disciplina retornaDisciplina(Long id){
		for (Disciplina disciplina: retornaDisciplinasCadastradas()){
			if (disciplina.getId().equals(id)){
				return disciplina;
			}
		}
		return null;
	}
	
	@Transactional	
	public static Result criaDisciplina() {
    	Form<Disciplina> formPreenchido = form.bindFromRequest();
    	
    	if (formPreenchido.hasErrors()) {
    		 flash("error", "Aconteceu um erro no cadastro!");
             return novaDisciplina();
        } else {
            Disciplina disciplina = formPreenchido.get();
            
            if (disciplina.getNome() != null){
            	dao.persist(disciplina);
                dao.flush();
                flash("success", "Disciplina cadastrada com sucesso!");
                return novaDisciplina();
            } 
        }
    	 flash("error", "Erro no cadastro");
         return novaDisciplina();
    }
}

