const url = "http://localhost:8088/getUser"

function getUser() {

    fetch(url).then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            for (let i = 0; i < user.rolesSet.length; i++) {
                userRoles += `${user.rolesSet[i].role} `
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
        })
}
//
// function getHeader() {
//     fetch(url).then((res) => res.json())
//         .then((user) => {
//             let output2 = "";
//             output2 += `${user.name}  with roles: ${user.roles}`;
//             document.getElementById("header").innerHTML = output;
//         })
// }
//
// getHeader()
getUser()
