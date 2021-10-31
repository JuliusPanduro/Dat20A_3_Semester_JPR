fetch("https://pokeapi.co/api/v2/pokemon")
    .then(Response => Response.json())
    .then(result => {
        const pokemons = result.results;
        pokemons.map((pokemon) => {
            const pokemonDivElement = document.getElementById("poke-div")
            const pokemonParagraphElement = document.createElement("p")
            pokemonParagraphElement.innerText = `
            ${pokemon.name}    
   `
            pokemonDivElement.appendChild(pokemonParagraphElement)
        });

    });




/*function createPokemon(pokemon) {
    console.log(pokemon);
    const createUL = document.createElement("ul")
    createUL.innerHTML = `
    <li>${escapeHTML(pokemon.name)}</li>    
   `
    pokemonDivElement.appendChild(createUL)

}

 */