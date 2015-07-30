import models.*;
import play.*;
import models.dao.GenericDAO;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {
	private static GenericDAO DAO = new GenericDAO();

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {

				//USUARIOS
				Usuario u1 = new Usuario("isabelly.cavalcante@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u1);
				DAO.flush();
				Usuario u2 = new Usuario("gleyser.bonfim.guimaraes@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u2);
				DAO.flush();
				Usuario u3 = new Usuario("dandara.navarro@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u3);
				DAO.flush();
				Usuario u4 = new Usuario("uian.gorgonio@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u4);
				DAO.flush();
				Usuario u5 = new Usuario("rayff.queiroga@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u5);
				DAO.flush();
				Usuario u6 = new Usuario("francisco.neto@computacao.ufcg.edu.br", "1234", false);
				DAO.persist(u6);
				DAO.flush();
				Usuario u7 = new Usuario("lbmarinho@computacao.ufcg.edu.br", "1234", false);
				DAO.persist(u7);
				DAO.flush();

			

				// Eh aqui que vamos adicionar as disciplinas, todas elas!

				// comecando pelas disciplinas da TERCA de 8h
							
				Disciplina linear = new Disciplina("ALGEBRA LINEAR I", "Jose Luiz", "CAA102", "linear", 4, "1109049");
				linear.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				linear.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				linear.mostrarNoHorario();
				DAO.persist(linear);
				DAO.flush();

				Disciplina eda = new Disciplina("ESTRUTURA DE DADOS E ALGORITMOS", "Campelo", "CD105", "eda", 4, "1411172");
				eda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				eda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				eda.mostrarNoHorario();
				DAO.persist(eda);
				DAO.flush();

				Disciplina moderna = new Disciplina("FUNDAMENTOS DE FÍSICA MODERNA", "Igo", "CAA104", "moderna", 4, "1108090");
				moderna.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 16));
				moderna.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 14));
				moderna.mostrarNoHorario();
				DAO.persist(moderna);
				DAO.flush();

				Disciplina ginf = new Disciplina("GERÊNCIA DA INFORMAÇÃO", "Carlos Eduardo", "CAA401", "ginf", 4, "1411176");
				ginf.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				ginf.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				ginf.mostrarNoHorario();
				DAO.persist(ginf);
				DAO.flush();

				Disciplina leda = new Disciplina("LAB.DE ESTRUTURA DE DADOS E ALGORITMOS", "Adalberto", "LCC2", "leda", 4, "1411179");
				leda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				leda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				leda.mostrarNoHorario();
				DAO.persist(leda);
				DAO.flush();

				Disciplina prob = new Disciplina("PROBABILIDADE E ESTATISTICA", "Alexsandro", "CAA401", "prob", 4, "1114107");
				prob.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				prob.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				prob.mostrarNoHorario();
				DAO.persist(prob);
				DAO.flush();

				Disciplina tct1 = new Disciplina("TEORIA DA COMPUTAÇÃO", "Kyller", "CAA401", "tc-t1", 4, "1411171");
				tct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 16));
				tct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 14));
				tct1.mostrarNoHorario();
				DAO.persist(tct1);
				DAO.flush();

				Disciplina si2 = new Disciplina("Sistemas da Informação II", "Franklin", "CD105", "si2", 4, "1411195");
				si2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				si2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				si2.mostrarNoHorario();
				DAO.persist(si2);
				DAO.flush();


				Disciplina vetorial = new Disciplina("Álgebra vetorial e Geometria Analítica", "Ivaldo", "CAA104", "vetorial", 4, "1109035");
				vetorial.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				vetorial.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				vetorial.mostrarNoHorario();
				DAO.persist(vetorial);
				DAO.flush();

				Disciplina calculo1 = new Disciplina("Cálculo Diferencial e Integral", "Alcionio", "CAA102", "calculo1", 4, "1109103");
				calculo1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 14));
				calculo1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 16));
				calculo1.mostrarNoHorario();
				DAO.persist(calculo1);
				DAO.flush();

				Disciplina ic = new Disciplina("Introdução a Computação", "Joseana", "CAA405", "ic", 4, "1411174");
				ic.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				ic.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				ic.mostrarNoHorario();
				DAO.persist(ic);
				DAO.flush();

				Disciplina lp1 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO I", "Dalton", "LCC1", "lp1", 4, "1411180");
				lp1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				lp1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				lp1.mostrarNoHorario();
				DAO.persist(lp1);
				DAO.flush();

				Disciplina lpt = new Disciplina("LEITURA E PRODUCAO DE TEXTOS", "Maria", "BD202", "lpt", 4, "1307151");
				lpt.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 14));
				lpt.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 16));
				lpt.mostrarNoHorario();
				DAO.persist(lpt);
				DAO.flush();

				Disciplina p1 = new Disciplina("PROGRAMAÇÃO I", "Jorge", "CD106", "p1", 4, "1411167");
				p1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				p1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				p1.mostrarNoHorario();
				DAO.persist(p1);
				DAO.flush();


				Disciplina calculo2 = new Disciplina("CALCULO DIFERENCIAL E INTEGRAL II", "Amauri", "CAA102", "calculo2", 4, "1109053");
				calculo2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				calculo2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				// esta comentado para poder aparecer essa disciplina na tela de adicionar disciplinas
				//calculo2.mostrarNoHorario();
				DAO.persist(calculo2);
				DAO.flush();

				Disciplina fisicaClassica = new Disciplina("FUNDAMENTOS DE FÍSICA CLÁSSICA", "Alexandre", "CAA403", "fisicaClassica", 4, "1108089");
				fisicaClassica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 16));
				fisicaClassica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				fisicaClassica.mostrarNoHorario();
				DAO.persist(fisicaClassica);
				DAO.flush();

				Disciplina lp1t3 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO II", "Neto", "LCC1", "lp1-t3", 4, "1411181");
				lp1t3.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				lp1t3.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				lp1t3.mostrarNoHorario();
				DAO.persist(lp1t3);
				DAO.flush();

				Disciplina matdisct1 = new Disciplina("MATEMÁTICA DISCRETA", "Leandro", "CAA304", "matdisc-t1", 4, "1109113");
				matdisct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				matdisct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				matdisct1.mostrarNoHorario();
				DAO.persist(matdisct1);
				DAO.flush();

				Disciplina p2t1 = new Disciplina("PROGRAMAÇÃO II", "Gustavo", "RE10", "p2-t1", 4, "1411168");
				p2t1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				p2t1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				p2t1.mostrarNoHorario();
				DAO.persist(p2t1);
				DAO.flush();

				Disciplina grafost1 = new Disciplina("TEORIA DOS GRAFOS", "Patricia", "CD105", "grafos-t1", 2, "1411170");
				grafost1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				grafost1.mostrarNoHorario();
				DAO.persist(grafost1);
				DAO.flush();

				Disciplina metci = new Disciplina("METODOLOGIA CIENTÍFICA", "Jacques", "DSC", "metci", 4, "1305218");
				metci.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				metci.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				metci.mostrarNoHorario();
				DAO.persist(metci);
				DAO.flush();

				Disciplina es1 = new Disciplina("ENGENHARIA DE SOFTWARE I", "Rohit", "CAA401", "es", 4, "1411177");
				es1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 14));
				es1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 16));
				es1.mostrarNoHorario();
				DAO.persist(es1);
				DAO.flush();

				Disciplina loact2 = new Disciplina("LAB.DE ORG.E ARQUITETURA DE COMPUTADORES", "Elmar", "RE16", "loac", 4, "1411182");
				loact2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				loact2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				loact2.mostrarNoHorario();
				DAO.persist(loact2);
				DAO.flush();

				Disciplina logica = new Disciplina("LÓGICA MATEMÁTICA", "Elmar", "CAA201", "logica", 4, "1411173");
				logica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				logica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				logica.mostrarNoHorario();
				DAO.persist(logica);
				DAO.flush();

				Disciplina metEstatisticos = new Disciplina("METODOS ESTATISTICOS", "", "CAA401", "met. estatisticos", 4, "1114114");
				metEstatisticos.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				metEstatisticos.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				metEstatisticos.mostrarNoHorario();
				DAO.persist(metEstatisticos);
				DAO.flush();

				Disciplina oac = new Disciplina("ORG.E ARQUITETURA DE COMPUTADORES I", "Joseana", "CAA407", "oac", 4, "1411175");
				oac.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				oac.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				oac.mostrarNoHorario();
				DAO.persist(oac);
				DAO.flush();

				Disciplina plpt1 = new Disciplina("PARADIGMAS DE LING. DE PROGRAMAÇÃO", "Patricia", "CD105", "plp", 4, "1411169");
				plpt1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				DAO.persist(plpt1);
				DAO.flush();

				Disciplina si1 = new Disciplina("SISTEMAS DE INFORMAÇÃO I", "Nazareno", "CAA401", "si1", 4, "1411178");
				si1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 16));
				si1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 14));
				si1.mostrarNoHorario();
				DAO.persist(si1);
				DAO.flush();

				Disciplina atal = new Disciplina("ANÁLISE E TÉCNICA DE ALGORITMOS", "Gustavo", "CAA408", "si1", 4, "1411187");
				atal.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				atal.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				atal.mostrarNoHorario();
				DAO.persist(atal);
				DAO.flush();

				Disciplina bd1 = new Disciplina("BANCO DE DADOS I", "Baptista", "CD105", "BD1", 4, "1411193");
				bd1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				bd1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				bd1.mostrarNoHorario();
				DAO.persist(bd1);
				DAO.flush();

				Disciplina infosoc = new Disciplina("INFORMÁTICA E SOCIEDADE", "Kalley", "CAA408", "infosoc", 4, "1305220");
				infosoc.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 14));
				infosoc.mostrarNoHorario();
				DAO.persist(infosoc);
				DAO.flush();

				Disciplina compil = new Disciplina("COMPILADORES", "Franklin", "CD105", "compil", 4, "1411189");
				compil.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				compil.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				compil.mostrarNoHorario();
				DAO.persist(compil);
				DAO.flush();

				Disciplina lest2 = new Disciplina("LABORATÓRIO DE ENGENHARIA DE SOFTWARE", "Gustavo/Neto", "LCC2", "les", 4, "1411183");
				lest2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				lest2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				lest2.mostrarNoHorario();
				DAO.persist(lest2);
				DAO.flush();

				Disciplina redes = new Disciplina("REDES DE COMPUTADORES", "Reinaldo", "RE-02", "redes", 4, "1411190");
				redes.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				redes.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				redes.mostrarNoHorario();
				DAO.persist(redes);
				DAO.flush();

				Disciplina dirCidadania = new Disciplina("DIREITO E CIDADANIA", "", "", "Dir. Cidadania", 4, "1305219");
				dirCidadania.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				dirCidadania.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				dirCidadania.mostrarNoHorario();
				DAO.persist(dirCidadania);
				DAO.flush();

				Disciplina bd2 = new Disciplina("BANCO DE DADOS II", "Carlos Eduardo", "RE-02", "bd2", 4, "1411194");
				bd2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				bd2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				bd2.mostrarNoHorario();
				DAO.persist(bd2);
				DAO.flush();

				Disciplina ia1 = new Disciplina("INTELIGENCIA ARTIFICIAL I", "Herman", "CD105", "ia1", 4, "1411196");
				ia1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 16));
				ia1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 14));
				ia1.mostrarNoHorario();
				DAO.persist(ia1);
				DAO.flush();

				Disciplina irc = new Disciplina("INTERCONEXÃO DE REDES DE COMPUTADORES", "Peter", "DSC", "irc", 4, "1411191");
				irc.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				irc.mostrarNoHorario();
				DAO.persist(irc);
				DAO.flush();

				Disciplina lirc = new Disciplina("LAB.DE INTERCON.DE REDES DE COMPUTADORES", "Peter", "DSC", "lirc", 4, "1411184");
				lirc.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				lirc.mostrarNoHorario();
				DAO.persist(lirc);
				DAO.flush();

				Disciplina so = new Disciplina("SISTEMAS OPERACIONAIS", "Fubica", "CD105", "so", 4, "1411192");
				so.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				so.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				so.mostrarNoHorario();
				DAO.persist(so);
				DAO.flush();

				Disciplina adsd = new Disciplina("AVAL.DE DESEMPENHO DE SISTEMAS DISCRETOS", "Reinaldo", "RE-08", "adsd", 4, "1411197");
				adsd.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				adsd.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				adsd.mostrarNoHorario();
				DAO.persist(adsd);
				DAO.flush();

				Disciplina msn = new Disciplina("MÉTODOS E SOFTWARE NUMÉRICOS", "Antao", "CD107", "msn", 4, "1411188");
				msn.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				msn.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				msn.mostrarNoHorario();
				DAO.persist(msn);
				DAO.flush();

				Disciplina projeto1 = new Disciplina("PROJETO EM COMPUTAÇÃO I", "Kyller", "CD107", "projeto I", 4, "1411185");
				projeto1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 18));
				projeto1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 18));
				projeto1.mostrarNoHorario();
				DAO.persist(projeto1);
				DAO.flush();

				Disciplina projeto2 = new Disciplina("PROJETO EM COMPUTAÇÃO II", "Hyggo", "CD105", "projeto II", 4, "1411186");
				projeto2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				projeto2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				projeto2.mostrarNoHorario();
				DAO.persist(projeto2);
				DAO.flush();
			}
		});
	}
}
