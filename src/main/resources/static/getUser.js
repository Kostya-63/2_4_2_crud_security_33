const url = "http://localhost:8088/getUser"

function getUser() {

    fetch(url).then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            let output3 = "";
            for (let i = 0; i < user.rolesSet.length; i++) {
                userRoles += `${user.rolesSet[i].role} `
            }

            if (userRoles.includes("ROLE_ADMIN")) {
                output3 +=
                    `<li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#adminPanel">Admin</a>
                    </li>`
                ;
            }
            if (userRoles.includes("ROLE_USER")) {
                output3 +=
                    `<li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#userAdmin">User</a>
                    </li>`
                ;
            }

            let output = "<tr>";
            output += `
                <td class="p-2">${user.id}</td>
                <td class="p-2">${user.name}</td>
                <td class="p-2">${user.character}</td>
                <td class="p-2">${user.iq}</td>
                <td class="p-2">${userRoles}</td>
            `;
            output += "<tr>";

            document.getElementById("getUser").innerHTML = output;

            let output2 = "";
            output2 += `${user.name}  with roles: ${user.roles}`;
            document.getElementById("header").innerHTML = output2;
            document.getElementById("tabsAdminUser").innerHTML = output3;
        })
}

getUser()
