window.onload = function loadDisciplina() {
    var url = "http://localhost:8888/disciplina/template";
    
    httpGet(url, mostraDisciplina);

    function mostraDisciplina(template_disciplina) {
        var url = "http://localhost:8888/api/disciplina.get";
        httpGet(url, montaHorario);

        function montaHorario(http_json) {
          disciplinas = JSON.parse(http_json);

          for (var i = 0 ; i < disciplinas.length ; i++) {          
              for (var j = 0 ; j < disciplinas[i].horario.length ; j++) {
                            
              disciplina_html = template_disciplina.replace(/__abrev__/g, disciplinas[i].nome_curto);
              disciplina_html = disciplina_html.replace(/__professor__/g, disciplinas[i].professor);
              document.getElementById(disciplinas[i].horario[j]).insertAdjacentHTML("beforeend", disciplina_html);
            }            
          }
        }
    }
}
