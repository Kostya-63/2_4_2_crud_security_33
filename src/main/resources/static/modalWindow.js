function openModalWindow(id) {
    document.getElementById("idEdit").value = id;
    document.getElementById("nameEdit").value = $("#firstName" + id).text(); //userFirstNameGod
    document.getElementById("lastNameEdit").value = $("#lastName" + id).text();
    document.getElementById("ageEdit").value = $("#age" + id).text();
    document.getElementById("mailEdit").value = $("#mail" + id).text();
    document.getElementById("passwordEdit").value = "";
}

function openModalWindowDel(id) {
    document.getElementById("idDelete").value = id;
    document.getElementById("firstNameDelete").value = $("#firstName" + id).text();
    document.getElementById("lastNameDelete").value = $("#lastName" + id).text();
    document.getElementById("ageDelete").value = $("#age" + id).text();
    document.getElementById("mailDelete").value = $("#mail" + id).text();
    document.getElementById("passwordDelete").value = "";
}
