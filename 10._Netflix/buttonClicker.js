let counter = 0;
const clickbutton = document.getElementById("click-btn");
clickbutton.addEventListener("mouseenter",()=>{

});
clickbutton.addEventListener("click",buttonClicked);

function buttonClicked(){
    counter ++;

    const paragraph = document.createElement("p");
    paragraph.innerText = "You've clicked the button " + counter + " times.";
    paragraph.style.color = "blue";

    const counterWrapper = document.getElementById("click-counters");
    counterWrapper.prepend(paragraph);

}