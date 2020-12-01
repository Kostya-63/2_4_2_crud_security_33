document.getElementById("updateUserModal").addEventListener("submit", editPost)

function editPost(e) {
    e.preventDefault();

    let id = document.getElementById("idEdit").value;
    let name = document.getElementById("nameEdit").value;
    let password = document.getElementById("passwordEdit").value;
    let character = document.getElementById("characterEdit").value;
    let iq = document.getElementById("IQEdit").value;
    let roles = setRoles(Array.from(document.getElementById("roleEdit").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8088/editUser", {
        method: "PUT",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type": "application/json; charset = utf-8"
        },
        body: JSON.stringify({
            id: id,
            name: name,
            password: password,
            character: character,
            iq: iq,
            //roles: roles
        })
    }).finally(() => {
        $('#editUser').modal("hide")
        getHeader();
        getUsers();
    })
}

function inputRolesIntoEdit() {
    fetch("http://localhost:8088/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option id="edit${role.role}">${role.role}</option>`;
            });
            document.getElementById("roleEdit").innerHTML = output;
        })
}
inputRolesIntoEdit()

function modalWindowEdit(id) {
    document.getElementById("idEdit").value = id;
    document.getElementById("nameEdit").value = $("#name" + id).text();
    document.getElementById("passwordEdit").value = "";
    document.getElementById("characterEdit").value = $("#character" + id).text();
    document.getElementById("IQEdit").value = $("#iq" + id).text();
}
