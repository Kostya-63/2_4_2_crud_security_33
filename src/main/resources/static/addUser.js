document.getElementById("newUser").addEventListener("submit", addNewUser);

function addNewUser(e) {
    e.preventDefault();

    let name = document.getElementById("name").value;
    let character = document.getElementById("character").value;
    let iq = document.getElementById("iq").value;
    let password = document.getElementById("password").value;

    let admin = "";
    let user = "";
    if (document.getElementById("ROLE_ADMIN").selected) {
        admin = "ADMIN";
    }
    if (document.getElementById("ROLE_USER").selected) {
        user = "USER";
    }

    fetch("http://localhost:8088/addUser", {
        method: 'POST',
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
            admin: admin,
            user: user
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