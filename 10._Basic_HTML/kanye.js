let kanyeQuote;

function getKanyeQuote() {
    fetch("https://api.kanye.rest/")
        .then(response => response.json())
        .then(result => {
            document.getElementById("kanye-quote").innerText = result.quote;
            kanyeQuote = result.quote;
        })
}

getKanyeQuote();

document.getElementById("btn-laugh").addEventListener("click", () => addQuoteToList("laugh"));
document.getElementById("btn-wtf").addEventListener("click", () => addQuoteToList("wtf"));
document.getElementById("btn-horny").addEventListener("click", () => addQuoteToList("horny"));

function addQuoteToList(reaction) {

    // Checks if the quote already exist in the Div Class .list-wrapper
    /*  for (const div of document.querySelectorAll("div.list-wrapper")) {
        if (div.textContent.includes(kanyeQuote)) {
            getKanyeQuote();
        } else {

     */

    const paragraph = document.createElement("p");
    paragraph.innerText = kanyeQuote;
    document.getElementById("list-" + reaction).appendChild(paragraph);
    getKanyeQuote();
      /*  }
 }
       */
}

setInterval(kanyeQuote,5000)
