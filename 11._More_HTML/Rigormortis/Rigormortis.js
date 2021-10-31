/*let currentPage = 0;
while (currentPage <= 34) {
    currentPage++;
    fetch("https://rickandmortyapi.com/api/character/?page=" + currentPage)
        .then(response => response.json())
        .then(result => {
            const characters = result.results;
            characters.map(character => createCharacterCard(character));
        });
}

 */

let characters;
let filteredCharacters;

fetch("https://rickandmortyapi.com/api/character/?page=")
    .then(response => response.json())
    .then(result => {
        characters = result.results;
        filteredCharacters = characters;
        characters.map(character => createCharacterCard(character));
    });


const characterDivElement = document.getElementById("div-wrapper");

function createCharacterCard(character) {
    // console.log(character);

    let alive;
    if (character.status === "Alive") {
        alive = "🟢";
    } else if (character.status === "Dead") {
        alive = "⚰️";
    } else {
        alive = "❓";
    }

    let isAlien;
    isAlien = character.species === "Human" ? "🧑" : "👽"

    const tableRowElement = document.createElement("fieldset");
    tableRowElement.innerHTML = `
          <legend>${escapeHTML(character.name)}</legend>
          <img alt="avatar" src="${escapeHTML(character.image)}">
          <h4> Existence: ${escapeHTML(character.status)} ${alive} </h4>
          <h3> Species Type: ${escapeHTML(character.species)} ${isAlien}</h3>
    `
    characterDivElement.appendChild(tableRowElement);
    //  console.log(character);
}


function searchCharacters() {
    const selectedStatus = document.getElementById("DropDown_Status").value;
    characterDivElement.innerHTML = "";

    if (selectedStatus === "All"){
        filteredCharacters = characters;
       characters.map(createCharacterCard);

    } else {
        filteredCharacters = characters.filter(character => character.status === selectedStatus);
        filteredCharacters.map(createCharacterCard);
      //  characters.map(createCharacterCard).filter(characters.status);
    }
}

function handleSearchName(event){
    characterDivElement.innerHTML = "";
    const searchTerm = event.target.value.toLowerCase();
    filteredCharacters.filter(character => character.name.toLowerCase().includes(searchTerm)).map(createCharacterCard);
}


//document.getElementById("search-btn").addEventListener("click", searchCharacters);
document.getElementById("DropDown_Status").addEventListener("click", searchCharacters);

document.getElementById("name-search").addEventListener("input", handleSearchName);

