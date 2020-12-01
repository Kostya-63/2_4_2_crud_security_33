document.getElementById("newUser").addEventListener("submit", addNewUser);

function addNewUser(e){
    e.preventDefault();

    let name = document.getElementById("name").value;
    let password = document.getElementById("password").value;
    let character = document.getElementById("character").value;
    let iq = document.getElementById("iq").value;
    let roles = setRoles(Array.from(document.getElementById("roles").selectedOptions)
        .map(option => option.value));

    fetch("http://localhost:8088/addUser", {
        method: "POST",
        headers: {
            "Accept": "application/json, text/plain, */*",
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            id: null,
            name: name,
            password: password,
            character: character,
            iq: iq,
            //roles: roles
        })
    })
        .finally(() => {
            document.getElementById("allUsersTable").click();
            getUsers();
            document.getElementById("addUser").reset();
        })
}

function setRoles(someRoles) {
    let roles = [];
    if (someRoles.indexOf("ROLE_USER") >= 0) {
        roles.push({"id": 2, "name": "ROLE_USER"});
    }
    if (someRoles.indexOf("ROLE_ADMIN") >= 0) {
        roles.push({"id": 1, "name": "ROLE_ADMIN"});
    }
    return roles;
}

function inputRolesIntoAdd() {
    fetch("http://localhost:8088/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option id="new${role.role}">${role.role}</option>`;
            });
            document.getElementById("roles").innerHTML = output;
        })
}
inputRolesIntoAdd()