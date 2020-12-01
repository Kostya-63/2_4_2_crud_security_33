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
        getUsers();
    });
}
