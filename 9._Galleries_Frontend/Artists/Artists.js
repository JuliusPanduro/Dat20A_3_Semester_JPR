fetch("http://localhost:8080/artists")
    .then(response => response.json())
    .then(result => {
        result.map(createArtistCard)
    });

function createArtistCard(artist) {
    const artistElement = document.getElementById("card_artist");
    const artistDiv = document.createElement("div");

    const testArtistElement = document.getElementById("artist_test")
    const testArtistDiv = document.createElement("div");
    testArtistDiv.innerHTML = ` 
    
    <h2>${escapeHTML(artist.name)}</h2>
             <p>Age : ${escapeHTML(artist.age.toString())}</p>
             <p>Gender : ${escapeHTML(artist.gender.toString())}</p>
    `
    testArtistElement.append(testArtistDiv);


    artistDiv.innerHTML = `
             <div class="card-image_artist">${artist.image}</div>
             <div class="card-text_artist">
             <h2>${escapeHTML(artist.name)}</h2>
             <p>Age : ${escapeHTML(artist.age.toString())}</p>
             <p>Gender : ${escapeHTML(artist.gender.toString())}</p>
             <p>Nationality : ${escapeHTML(artist.nationality)}</p>
             <p>Primary Style : ${escapeHTML(artist.primaryStyle)}</p>
             <p>Gallery : ${artist.gallery}</p>
             </div>
            `
    //artistElement.append(artistDiv);

}


function createNewArtist() {
    const name = document.getElementById("create-artist-name").value;
    const age = document.getElementById("create-artist-age").value;
    const img = document.getElementById("create-artist-img").value;
    const gender = document.getElementById("create-artist-gender").value;

    const newArtist = {
        name: name,
        age: Number(age),
        image: img,
        gender: gender
    };

    fetch("http://localhost:8080/artists", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newArtist)
    })
        .then(response => {
            if (response.status === 200){
                createArtistCard(newArtist);
            }else{
                console.log("Artist not created." + response.status);
            }
        })
        .catch(error => console.log("Network related error",error));


}

document.getElementById("create-artist-btn").addEventListener("click", createNewArtist);



