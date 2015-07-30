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


public class SistemaAlunoController extends Controller {
	
	// INICIO DA DECLARACAO DE VARIAVEIS
	private static GenericDAO dao = new GenericDAO();
	private static Form<Disciplina> form = Form.form(Disciplina.class);
	private static Form<Problema> formProblema = Form.form(Problema.class);
	// FIM DA DECLARACAO DE VARIAVEIS
	
	private static List<Disciplina> retornaDisciplinasCadastradas(){
		return dao.findAllByClass(Disciplina.class);
	}	
	
	private static Usuario retornaUsuario(String email){
		List<Usuario> todosUsuarios = dao.findAllByClass(Usuario.class);
		for (Usuario u : todosUsuarios){
			if (u.getEmail().equals(email)){
				return u;
			}
		}
		return null;
	}
	
	@Transactional
	public static Result indicarIntencaoDeMatricula(Long id){
		
		return ok(listDisciplinasAluno.render(retornaDisciplinasCadastradas()));
	}
	
	@Transactional
	public static Result irParaTelaDeIntencaoDeMatricula(){
		
		return ok(listDisciplinasAluno.render(retornaDisciplinasCadastradas()));
	}
	
	@Transactional
	public static Result indicarProblema(Long id, String email){
		Form<Problema> formPreenchido = formProblema.bindFromRequest();
		
		Disciplina disc = SistemaCoordenadorController.retornaDisciplina(id);
		Usuario user = retornaUsuario(email);
		
		if (formPreenchido.hasErrors()) {
    		 flash("error", "Aconteceu um erro na indicação do problema!");
             return Application.sistemaAluno(email);
        } else {
            Problema problema = formPreenchido.get();
			
           
            if (problema.getProblema() != null){
            	dao.persist(problema);
                dao.flush();
                flash("success", "Indicação de problema salvo com sucesso!");
                return Application.sistemaAluno(email);
            }
			problema.addDisciplina(disc);
			problema.addUsuario(user);
			dao.merge(problema);
			dao.flush();	
        }
    	 flash("error", "Erro no cadastro");
         return Application.sistemaAluno(email);
	}
	
	
	
}

