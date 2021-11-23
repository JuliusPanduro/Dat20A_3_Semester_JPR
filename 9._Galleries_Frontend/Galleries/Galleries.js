const galleriesTableBody = document.getElementById("galleries-tbody");

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        galleries.map(createGalleryTable)
        console.log(galleries);
    });


function createGalleryTable(gallery) {
    const galleryTableRow = document.createElement("tr");
    galleryTableRow.id = gallery.galleryID;

    galleryTableRow.innerHTML = `
            <td>
                <a href="../Gallery/Gallery.html?galleryId=${gallery.galleryID}">
                    <p class="galleryName">${escapeHTML(gallery.name)}</p>
                </a>
            </td>
            <td>
                <p>${escapeHTML(gallery.location)}</p>
            </td>
            <td>
                <p>${escapeHTML(gallery.owner)}</p>
            </td>
            <td>
                <p>${escapeHTML(gallery.squareFeet.toString())}</p>
            </td>           
            <td>
                <button onclick="deleteGallery(${gallery.galleryID})">❌</button>            
            </td>
        `;

    galleriesTableBody.appendChild(galleryTableRow);
}






function deleteGallery(galleryId) {
    console.log(galleryId);
    fetch(baseURL + "/galleries/" + galleryId, {
        method: "DELETE"
    }).then(response => {
        if (response.status === 200) {
            document.getElementById(galleryId).remove();
        } else {
            console.log("Did not delete gallery")
        }
    });
}