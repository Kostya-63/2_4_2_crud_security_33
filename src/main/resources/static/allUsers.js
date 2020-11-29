function getUsers() {
    fetch("http://localhost:8088/allUsers")
        .then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (user) {

                // let userRoles = "";
                // for (let i = 0; i < user.roles.length; i++){
                //     userRoles+=`${user.roles[i].role} `
                // }

                output += `
                <tr>
                <td class="p-2" id="id${user.id}">${user.id}</td>
                <td class="p-2" id="firstName${user.id}">${user.name}</td> 
                <td class="p-2" id="lastName${user.id}">${user.character}</td>
                <td class="p-2" id="age${user.id}">${user.iq}</td>
                <td class="p-2" id="roles${user.id}">${user.roles}</td>
                <td class="p-2" style="width: 9%">
                <a class="btn btn-primary text-white"
                data-toggle="modal" data-target="#editUser" id="callModalEdit"
                onclick="openModalWindow(${user.id})">Edit</a>
                </td>
                <td class="p-2" style="width: 9%">
                <a class="btn btn-danger text-white" role="button"
                data-toggle="modal" data-target="#deleteUser" id="delete-post"
                onclick="openModalWindowDel(${user.id})">Delete</a>
                </td>
              </tr>
          `;
            });
            document.getElementById("allUsers").innerHTML = output;
        })
}
getUsers()