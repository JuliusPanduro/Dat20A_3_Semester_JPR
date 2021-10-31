fetch("https://my-first-restapi-2021.herokuapp.com/cars/")
    .then(response => response.json())
    .then(result => {
        const cars = result.results;
        cars.map(car => createCarCard(car));
    });


const characterDivElement = document.getElementById("div-wrapper");


function createCarCard(car) {
    console.log(car);
    const tableRowElement = document.createElement("fieldset");
}

