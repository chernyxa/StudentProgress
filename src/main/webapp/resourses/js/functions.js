function studentModify(){

    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    var idModify;

    for(var i = 0; i < chekedChekboxes.length; i++){
        if(chekedChekboxes[i].checked){
            countChecked++;
            idModify = chekedChekboxes[i].value;
        }
    }

    if(countChecked == 0){
        alert("Pleas, select student!!");
        return;
    }

    if(countChecked > 1){
        alert("Pleas, select only one student!!");
        return;
    }


    document.getElementById('hiddenToModify').value = idModify;
    document.getElementById('formToModify').submit();
}

function studentProgress(){

    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    var idStud;

    for(var i = 0; i < chekedChekboxes.length; i++){
        if(chekedChekboxes[i].checked){
            countChecked++;
            idStud = chekedChekboxes[i].value;
        }
    }

    if(countChecked == 0){
        alert("Pleas, select student!!");
        return;
    }

    if(countChecked > 1){
        alert("Pleas, select only one student!!");
        return;
    }


    document.getElementById('hiddenIdToProgress').value = idStud;
    document.getElementById('formToProgress').submit();
}

function studentDelete(){

    var chekedChekboxes = document.getElementsByClassName('checkbox');
    var countChecked = 0;
    var IdsToDelete;

    for(var i = 0; i < chekedChekboxes.length; i++){
        if(chekedChekboxes[i].checked){
            countChecked++;
            idToDelete = idToDelete + chekedChekboxes[i].value + " ";
        }
    }

    if(countChecked == 0){
        alert("Pleas, select student!!");
        return;
    }




    document.getElementById('hiddenIdsToDelete').value = IdsToDelete;
    document.getElementById('formToDelete').submit();
}

function modifyDiscipline() {
    var checkedBoxes = document.querySelectorAll('input[type=checkbox]:checked');
    if (checkedBoxes.length == 0) {
        alert("Пожалуйста выберите хотя бы одну дисциплину")
        return;
    }
    if (checkedBoxes.length > 1) {
        alert("Пожалуйста выберите только одну дисциплину")
        return;
    }
    var id = checkedBoxes[0].getAttribute("value")
    var hidden = document.getElementById("hiddenModify")
    hidden.setAttribute("value", id)
    var form = document.getElementById("formModify");
    form.submit();
}

function deleteDiscipline() {
    var cekedVBoxes = document.querySelectorAll('input[type=checkbox]:checked')
    if (cekedVBoxes.length == 0) {
        alert("Пожалуйста выберите хотя бы одну дисциплину")
        return;
    }
    var ids = "";
    for (var i = 0; i < cekedVBoxes.length; i++) {
        ids = ids + cekedVBoxes[i].getAttribute("value") + "-";
    }
    var hidden = document.getElementById("hiddenDelete")
    hidden.setAttribute("value", ids)
    var form = document.getElementById("formDelete");
    form.submit();

}

