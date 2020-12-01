document.getElementById("deleteUserModal").addEventListener("submit", deletePost)

function deletePost(e){
    e.preventDefault();

    let id = document.getElementById("idDelete").value;
    let name = document.getElementById("nameDelete").value;
    let character = document.getElementById("characterDelete").value;
    let IQ = document.getElementById("IQDelete").value;
    let roles = setRoles(Array.from(document.getElementById("roleDelete").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8088/deleteUser/" + id, {
        method: "DELETE"
    }).finally(() => {
        $('#deleteUser').modal("hide")
        getHeader();
        getUsers();
    });
}

function inputRolesIntoDelete() {
    fetch("http://localhost:8088/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option id="delete${role.role}">${role.role}</option>`;
            });
            document.getElementById("roleEdit").innerHTML = output;
        })
}
inputRolesIntoDelete()

function modalWindowDelete(id) {
    document.getElementById("idDelete").value = id;
    document.getElementById("nameDelete").value = $("#name" + id).text();
    document.getElementById("characterDelete").value = $("#character" + id).text();
    document.getElementById("IQDelete").value = $("#iq" + id).text();
}