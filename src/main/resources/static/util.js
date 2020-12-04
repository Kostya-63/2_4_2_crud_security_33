function setRoles(someRoles) {
    let roles = [];
    if (someRoles.indexOf("ROLE_ADMIN") >= 0) {
        roles.push({"id": 1});
    }
    if (someRoles.indexOf("ROLE_USER") >= 0) {
        roles.push({"id": 2});
    }
    return roles;
}

function inputUserAfterEdit(id) {
    const url = "http://localhost:8088/getUser/" + id;

            fetch(url).then((res) => res.json())
                .then((user) => {
                    let userRoles = "";
                    for (let i = 0; i < user.rolesSet.length; i++) {
                        userRoles += `${user.rolesSet[i].role} `
                    }

            let output = "";
            output += `
                <td class="p-2" id="id${id}">${user.id}</td>
                <td class="p-2" id="name${id}">${user.name}</td> 
                <td class="p-2" id="character${id}">${user.character}</td>
                <td class="p-2" id="iq${id}">${user.iq}</td>
                <td class="p-2" id="roles${id}">${userRoles}</td>
                <td class="p-2" style="width: 9%">
                    <a class="btn btn-primary text-white"
                    data-toggle="modal" data-target="#editUser" id="callModalEdit"
                    onclick="modalWindowEdit(${id})">Edit
                    </a>
                </td>
                <td class="p-2" style="width: 9%">
                    <a class="btn btn-danger text-white" role="button"
                    data-toggle="modal" data-target="#deleteUser" id="delete-post"
                    onclick="modalWindowDelete(${id})">Delete
                    </a>
                </td>`
            ;
            document.getElementById(id).innerHTML = output;
        })
}