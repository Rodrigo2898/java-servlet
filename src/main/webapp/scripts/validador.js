function validar() {
    let nome = frmProfissao.nome.value;
    let idade = frmProfissao.idade.value;
    let profissao = frmProfissao.profissao.value;
    if (nome === "") {
        alert("Preencha o campo nome");
        frmProfissao.nome.focus();
        return false;
    } else if (idade === "") {
        alert("Preencha o campo idade");
        frmProfissao.idade.focus();
        return false;
    } else if (profissao === "") {
        alert("Preencha o campo profissao");
        frmProfissao.profissao.focus();
        return false;
    }
    else {
        document.form["frmProfissao"].submit();
    }
}