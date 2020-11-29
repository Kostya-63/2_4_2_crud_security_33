const url = "http://localhost:8088/getUser"

function getUser() {

    fetch(url).then((res) => res.json())
        .then((user) => {
            // let userRoles = "";
            // for (let i = 0; i < user.roles.length; i++) {
            //     userRoles += `${user.roles[i].role} `
            // }

            let output = "<tr>";
            output += `
                <td class="p-2">${user.id}</td>
                <td class="p-2">${user.name}</td>
                <td class="p-2">${user.character}</td>
                <td class="p-2">${user.iq}</td>
                <td class="p-2">${user.roles}</td>
            `;
            output += "<tr>";

            document.getElementById("getUser").innerHTML = output;
        })
}

function getHeader() {
    fetch(url).then((res) => res.json())
        .then((user) => {
            // let userRoles = "";
            // for (let i = 0; i < user.roles.length; i++) {
            //     userRoles += `${user.roles[i].role} `
            // }
            let output = "";
            output += `${user.name}  with roles: ${user.roles}`;
            document.getElementById("header").innerHTML = output;
        })
}

getHeader()
getUser()
