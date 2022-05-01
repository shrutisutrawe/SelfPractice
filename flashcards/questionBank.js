
function makeFlashcards() {

  const id1 = 0;
  const id2 = 1;
  const id3 = 2;
  const id4 = 3;

  const questionBankObject = {};
  const subjectFlashcards = {
    [id1]: {
        id: id1,
        category: 'english',
        question: 'Abolish?',
        answer:'extinguish',
      },
      [id2]: {
        id: id2,
        category: 'maths',
        question: '2*100?',
        answer:'200',
      },
      [id3]: {
        id: id3,
        category: 'english',
        question: 'Admonish?',
        answer:'reprimand',
      },
      [id4]: {
        id: id4,
        category: 'maths',
        question: '3*1000',
        answer:'3000',
      },
  };

  questionBankObject.contains = function contains(id) {
    return !!subjectFlashcards[id];
  };

   
  questionBankObject.addFlashcard = function addFlashcard(category,question,answer) {
    const id = Object.keys(subjectFlashcards).length;
    subjectFlashcards[id] = {
        id,
        category,
        question,
        answer,
      };
    return id;
  };

  questionBankObject.getFlashcard = function getFlashcard(id) {
    return subjectFlashcards[id];
  };

  questionBankObject.getUserFlashcards = function getUserFlashcards() {
    return subjectFlashcards;
  };
  questionBankObject.updateFlashcard = function updateFlashcard(id, flashcardData) {
    subjectFlashcards[id].answer = flashcardData.answer ?? subjectFlashcards[id].answer;
    subjectFlashcards[id].question = flashcardData.question || subjectFlashcards[id].question;
  };


  questionBankObject.deleteFlashcard = function deleteFlashcard(id) {
    delete subjectFlashcards[id];
  };

  return questionBankObject;
};

module.exports = {
  makeFlashcards: makeFlashcards,
};
