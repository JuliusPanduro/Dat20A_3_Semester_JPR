fetch(baseURL + "/artists")
    .then(response => response.json())
    .then(result => {
        result.map(createArtistCard)
    });



function createArtistCard(artist) {
    const artistElement = document.getElementById("card-container");
    const artistDiv = document.createElement("div");

    let artistAvatar = artist.image;
    if (artistAvatar === null || artistAvatar === ""){
        artistAvatar = "../lib/player_avatar.png"
    }else{
        artistAvatar = escapeHTML(artist.image);
    }

    artistDiv.innerHTML = `
                <div class="card">
                <img src="${escapeHTML(artistAvatar)}" alt="profile image" class="card-image">
                <h2>${artist.name}</h2>
                <p class="artist-style">${artist.primaryStyle}</p>
                <p class="artist-age">${artist.age.toString()}</p>
                <p class="artist-about">Nationality : ${artist.nationality} <br>
                Gender : ${artist.gender.toString()}<br>
                Gallery : ${artist.gallery}<br>
                </p>
                </div>
                    `
    artistElement.append(artistDiv);


    /* artistDiv.innerHTML = `
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
    artistElement.append(artistDiv);


     */
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

    fetch(baseURL + "/artists", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newArtist)
    })
        .then(response => {
            if (response.status === 200) {
                createArtistCard(newArtist);
            } else {
                console.log("Artist not created." + response.status);
            }
        })
        .catch(error => console.log("Network related error", error));
}

document.getElementById("create-artist-btn")
    .addEventListener("click", createNewArtist);



