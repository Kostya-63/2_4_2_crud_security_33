document.getElementById("newUser").addEventListener("submit", addNewUser);

function addNewUser(e){
    e.preventDefault();

    let name = document.getElementById("name").value;
    let password = document.getElementById("password").value;
    let character = document.getElementById("character").value;
    let iq = document.getElementById("iq").value;

    let roles = null;

    if (document.getElementById("ROLE_ADMIN").selected) {
        roles += 1;
    }
    if (document.getElementById("ROLE_USER").selected) {
        roles += 2;
    }

    fetch("http://localhost:8088/addUser", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: null,
            name: name,
            password: password,
            character: character,
            iq: iq,
            roles: roles
        })
    })
        .finally(() => {
            document.getElementById("allUsersTable").click();
            getUsers();
            document.getElementById("addUser").reset();
        })
}

function inputRolesIntoAdd() {
    fetch("http://localhost:8088/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option id="${role.role}">${role.role}</option>`;
            });
            document.getElementById("roles").innerHTML = output;
        })
}
inputRolesIntoAdd()