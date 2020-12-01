function inputRoles() {
    fetch("http://localhost:8088/allRoles").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (role) {
                output += `<option>${role.role}</option>`;
            });
            document.getElementById("roles").innerHTML = output;
            document.getElementById("roleEdit").innerHTML = output;
            document.getElementById("roleDelete").innerHTML = output;
        })
}

inputRoles()