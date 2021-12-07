$(document).ready(function(){
    $("#update_dentistas_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let dentistasId = $("#dentista_id").val();
            
        let formData = {
            id: $("#dentista_id").val(),
            nome : $("#nombre").val(),
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
                    let dentistas = response;
        
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> Dentista atualizado </strong></div>'

                 
                    $("#tr_" + dentistasId + " td.td_first_name").text(dentistas.nome.toUpperCase());
                    $("#tr_" + dentistasId + " td.td_last_name").text(dentistas.sobrenome.toUpperCase());
                    $("#tr_" + dentistasId + " td.td_matricula").text(dentistas.matricula);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

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
        let dentistasId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/dentistas/' + dentistasId,
            type: 'GET',
            success: function(response) {
                let dentistas = response;
                $("#odontologo_id").val(dentistas.id);
                $("#nome").val(dentistas.nome);
                $("#sobrenome").val(dentistas.sobrenome);
                $("#matricula").val(dentistas.matricula);
                $("#div_dentista_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});