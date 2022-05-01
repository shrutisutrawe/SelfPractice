import { useState } from "react";

function FlashCard({ index, question, answer, updateCard, removeCard }) {
  const [showEditForm, setShowEditForm] = useState(false);
  const [possibleQuestion, setPossibleQuestion] = useState(question);
  const [possibleAnswer, setPossibleAnswer] = useState(answer);

  
  return(
    <div>
  { !showEditForm && <div data-id={index} className="flashcard">
    <div className="card-body">
      <h4 className="card-title">
        {question}
      </h4>
      <p className="card-text">
        {answer}
      </p>
      <button onClick={()=> { setShowEditForm(true)}} className="edit-card-btn">edit</button>
      <button onClick={() => {removeCard(index)}} className="delete-card-btn">delete</button>
    </div>
  </div>}
  {showEditForm && 
    <div className="edit-card">
    <form className="edit-card-form" onSubmit={(e) => e.preventDefault()}>
        <h3>
        Edit Flash Card
        </h3>
        <div className="form-group">
            <label>
              Edit Question
            </label>
            <input
              type="text"
              value={possibleQuestion}
              onChange={(e) => setPossibleQuestion(e.target.value)}
              name="question"
              className="form-control"
              placeholder="Enter Question"
            />
        </div>
        <div className="form-group">
            <label>
              Edit Answer
            </label>
            <input
              type="text"
              value={possibleAnswer}
              onChange={(e) => setPossibleAnswer(e.target.value)}
              name="answer"
              className="form-control"
              placeholder="Enter Answer"
            />
        </div>
        <button onClick={() => {
                              setShowEditForm(false);
                              updateCard(index, possibleQuestion,possibleAnswer);
                              setPossibleAnswer(possibleAnswer);
                              setPossibleQuestion(possibleQuestion);}} type="button" className="btn-edit-cancel btn btn-large btn-danger">
          Save
        </button>
        <button onClick={()=>{setShowEditForm(false);setPossibleAnswer(answer);setPossibleQuestion(question);}} type="submit" className="btn-edit-cancel btn btn-large btn-danger">
          Cancel
        </button>
    </form>
</div>}
</div>
  );
};

export default FlashCard;