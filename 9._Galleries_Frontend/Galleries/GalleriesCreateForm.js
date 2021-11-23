const galleryFormParentDiv = document.getElementById("create-gallery-form");
const galleryFormExpandButton = document.getElementById("expand-gallery-form");
const createGalleryForm = `
<div>
<label>Name</label>
<input id="create-gallery-name" placeholder="Gallery Name"><br>
<label>Location</label>
<input id="create-gallery-location" placeholder="Gallery Location"><br>
<label>Square Feet</label>
<input type="number" min="0" max="150" id="create-gallery-size" placeholder="square feet"><br>
<label>Gallery Owner</label>
<input id="create-gallery-owner" placeholder="Gallery Owner"><br>
<button onclick="removeGalleryForm()">Cancel</button>
<button onclick="console.log('about to create a new gallery')">Create A New Gallery</button>
</div>

`


function showGalleryForm() {
    galleryFormExpandButton.style.display = "none";
    galleryFormParentDiv.innerHTML = createGalleryForm;
}

function removeGalleryForm(){
galleryFormExpandButton.style.display ="block";
galleryFormParentDiv.innerHTML = "";
}

function createGallery() {
    /*  const name = document.getElementById("create-gallery-name").value;
      const location = document.getElementById("create-gallery-location").value;
      const size = document.getElementById("create-gallery-size").value;
      const owner = document.getElementById("create-gallery-owner").value;


     */
    const newGallery = {
        name: "name",
        location: "location",
        squareFeet: "150",
        owner: "owner"
    };
    fetch(baseURL + "/galleries", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newGallery)
    })
        .then(response => response.json())
        .then(gallery => {
            createGalleryTable(gallery);
        })
}

document.getElementById("expand-gallery-form")
    .addEventListener("click", showGalleryForm);