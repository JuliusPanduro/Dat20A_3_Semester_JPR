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

document.getElementById("btn-laugh").addEventListener("click",() => addQuoteToList("laugh"));
document.getElementById("btn-wtf").addEventListener("click",() => addQuoteToList("wtf"));
document.getElementById("btn-horny").addEventListener("click",() => addQuoteToList("horny"));

function addQuoteToList(reaction){
   const paragraph = document.createElement("p");
   paragraph.innerText = kanyeQuote;
   document.getElementById("list-" +reaction).appendChild(paragraph);
}
setInterval(getKanyeQuote,5000)