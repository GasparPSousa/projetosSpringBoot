$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/dentistas",
            success: function(response){
              $.each(response, (i, dentista) => {


                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + dentista.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            dentista.id +
                                            '</button>';
                
                let tr_id = 'tr_' + dentista.id;
                let dentistaRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_first_name\">' + dentista.nome.toUpperCase() + '</td>' +
                          '<td class=\"td_last_name\">' + dentista.sobrenome + '</td>' +
                          '<td class=\"td_matricula\">' + dentista.matricula + '</td>' +
                          '</tr>';                
                $('#dentistaTable tbody').append(dentistaRow);
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