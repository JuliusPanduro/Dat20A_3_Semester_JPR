const poelseTableBody = document.getElementById("poelse-tbody");

fetch("http://localhost:8080/poelses")
    .then(response => response.json())
    .then(result => {
        result.map(createPoelseTable)
        console.log(result)
    });


function createPoelseTable(poelse) {
    const poelseTableRow = document.createElement("tr");

    poelseTableRow.innerHTML = `
<td>
<p>${escapeHTML(poelse.name)}</p>
</td>
<td>
<p>${escapeHTML(poelse.type)}</p>
</td>
<td>
<p>${escapeHTML(poelse.length.toString()) + "cm"}</p>
</td>
<td>
<p>${escapeHTML(poelse.weight.toString()) + "g"}</p>
</td>
<td>
<p>${escapeHTML(poelse.price.toString()) + ".-"}</p>
</td>
`
    poelseTableBody.appendChild(poelseTableRow);
}

function createNewPoelse() {
    const name = document.getElementById("poelse-name").value;
    const type = document.getElementById("poelse-type").value;
    const length = document.getElementById("poelse-length").value;
    const weight = document.getElementById("poelse-weight").value;
    const price = document.getElementById("poelse-price").value;


    const newPoelse = {
        "name": name,
        "type": type,
        "price": Number(price),
        "length": Number(length),
        "weight": Number(weight)
    };

    fetch("http://localhost:8080/poelses", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newPoelse)
    })
        .then(response => {
            if (response.status === 200) {
                createPoelseTable(newPoelse);
            } else {
                console.log("Poelse is not created." + response.status);
            }
        })
        .catch(error => console.log("Network related error" + error));
}

document.getElementById("create-poelse-btn")
    .addEventListener("click", createNewPoelse);