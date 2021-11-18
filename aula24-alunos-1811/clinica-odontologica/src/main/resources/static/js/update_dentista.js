$(document).ready(function(){
    $("#update_dentista_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let dentistaId = $("#dentista_id").val();
            
        let formData = {
            id: $("#dentista_id").val(),
            nome : $("#nome").val(),
            sobrenome :  $("#sobrenome").val(),
            matricula: $("#matricula").val(),
        }
            
            $.ajax({
                url: '/dentistas',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let dentista = response;
        
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> dentista atualizado </strong></div>'

                 
                    $("#tr_" + dentistaId + " td.td_first_name").text(dentista.nome.toUpperCase());
                    $("#tr_" + dentistaId + " td.td_last_name").text(dentista.sobrenome.toUpperCase());
                    $("#tr_" + dentistaId + " td.td_matricula").text(dentista.matricula);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Erro </strong></div>';

                    $("#response").empty();                                    
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let dentistaId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/dentistas/' + dentistaId,
            type: 'GET',
            success: function(response) {
                let dentista = response;
                $("#dentista_id").val(dentista.id);
                $("#nome").val(dentista.nome);
                $("#sobrenome").val(dentista.sobrenome);
                $("#matricula").val(dentista.matricula);
                $("#div_dentista_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});