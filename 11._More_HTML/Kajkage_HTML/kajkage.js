/*const list = [1, 2, 3, 4, 5];

const squaredList = list.map(number => number * number)

const isOdd = list.filter(number => number % 2 !== 0);
console.log(isOdd);
 */

const kajkager = [{
    type: "Andrea",
    color: "Blue",
    deliciousness: 8
}
];

kajkager.push({
    type: "Kaj",
    color: "Green",
    deliciousness: 10
});
const cakeTbodyElement = document.getElementById("cake-tbody");


kajkager.map(cake => {
    const tableRowElement = document.createElement("tr");
    tableRowElement.innerHTML = `
        <td>${escapeHTML(cake.type)}</td>
        <td>${escapeHTML(cake.color)}</td>
        <td>${escapeHTML((cake.deliciousness).toString())}/10</td>
    `
    cakeTbodyElement.appendChild(tableRowElement);
});











