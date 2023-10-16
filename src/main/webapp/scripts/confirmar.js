function confirmar(idcon) {
    let resposta = confirm("Confirmar exclusão deste contato");
    if (resposta === true) {
        //alert(idcon);
        window.location.href = "delete?idcon=" + idcon;
    }
}