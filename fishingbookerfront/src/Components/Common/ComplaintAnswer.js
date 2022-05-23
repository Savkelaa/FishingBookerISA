import { Button } from "bootstrap";
import React, { useRef } from "react";
import { Card } from "react-bootstrap";

export default function ComplaintAnswer({
  complaintRequest,
  updateComplaintHandler,
}) {
  const answer = useRef();

  return (
    <div>
      <Card.Body>
        <h6 for="text">Enter a response to a complaint : </h6>
        <input
          ref={answer}
          type="refusalReason"
          className="form-control"
          id="refusalReason"
        />

        <button
          type="button"
          className="btn btn-success"
          onClick={() => {
            complaintRequest.answer = answer.current.value;
            complaintRequest.active = "false";
            updateComplaintHandler(complaintRequest);
          }}
        >
          {" "}
          Send answer
        </button>
      </Card.Body>
    </div>
  );
}
