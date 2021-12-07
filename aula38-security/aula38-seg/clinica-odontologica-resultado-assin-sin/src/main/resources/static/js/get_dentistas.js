$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/dentistas",
            success: function(response){
              $.each(response, (i, dentistas) => {


                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + dentistas.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            dentistas.id +
                                            '</button>';
                
                let tr_id = 'tr_' + dentistas.id;
                let dentistasRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_first_name\">' + dentistas.nome.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + dentistas.sobrenome + '</td>' +
                          '<td class=\"td_matricula\">' + dentistas.matricula + '</td>' +
                          '</tr>';                
                $('#dentistaTable tbody').append(dentistasRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/dentistas.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});