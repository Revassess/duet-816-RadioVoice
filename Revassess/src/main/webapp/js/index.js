/**
 * use the provided url to receive the
 * json object and assign it to the resp
 * variable in this function. this is for 
 * testing purposes, do not change the getResp
 * function and leave the function names alone. 
 * the url for the api is:
 *  http://ec2-3-19-123-54.us-east-2.compute.amazonaws.com:9999/flashcard
 */
window.addEventListener('load',callFlashcardApi);

let resp = null;
let cardID = document.querySelector('#cardID');
let cardQuestion = document.querySelector('#cardQstn');
let cardAnswer = document.querySelector('#cardAns');
let cardCategory = document.querySelector('#cardCat');

document.addEventListener('DOMContentLoaded', () => {
    loadFlashcard();
});

function loadFlashcard() {
    fetch('http://ec2-3-19-123-54.us-east-2.compute.amazonaws.com:9999/flashcard')
        .then(
            (resp) => resp.json(),
            (f) => console.log(f)
        )
        .then((obj) => {
            resp = obj;
            showFlashcard();
        })
        .catch((err) => console.log(err));
}

function showFlashcard(){
    cardID.innerHTML = '';
    cardQuestion.innerHTML = '';
    cardAnswer.innerHTML = '';
    cardCategory.innerHTML = '';

    if (!resp || resp.count == 0) {
        cardID.innerText = 'No Flashcards Found';
        return;
    }

    const results = resp.results;
    results.forEach((card) => {

        const id = document.createElement('p');
        id.innerText = card.id;
        cardID.appendChild(id);

        const question = document.createElement('p');
        question.innerText = card.question;
        cardQuestion.appendChild(question);

        const answer = document.createElement('p');
        answer.innerText = card.answer;
        cardAnswer.appendChild(answer);

        const category = document.createElement('p');
        category.innerText = card.category;
        cardCategory.appendChild(question);
    })
}

//assign the returned json to the resp variable
async function callFlashcardApi(){
}

//manipulate the dom with this function
function manipDom(){
}

//this returns the variable that holds the json received from the api
function getResp(){
    return resp;
}
