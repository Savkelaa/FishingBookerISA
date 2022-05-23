import React, { useRef } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";

export default function RateAndComplaint({
  addInstructorRateHandler,
  addInstructorComplaintHandler,
  addFishingClassRateHandler,
  reservation,
}) {
  var logedClient = JSON.parse(localStorage.getItem("Client"));
  console.log("logedClient", logedClient);

  const rate1 = useRef();
  const rate2 = useRef();
  const zalba = useRef();

  return (
    <div>
      <Card.Body>
        <div className="popup">
          <h6 for="text">Please rate this fishing Class: </h6>
          <input ref={rate1} type="text" className="form-control" id="start" />
          <button
            onClick={() =>
              addFishingClassRateHandler({
                accepted: "false",
                request: "true",
                rate: rate1.current.value,
                client: { id: logedClient.id },
                fishingClass: {
                  id: reservation.fishingClass.id,
                },
              })
            }
            className="btn btn-success"
          >
            Rate
          </button>
          <br></br>
          <br></br>
          <h6 for="text">Please rate this Instructor: </h6>
          <input
            ref={rate2}
            type="refusalReason"
            className="form-control"
            id="refusalReason"
          />
          <button
            onClick={() =>
              addInstructorRateHandler({
                accepted: "false",
                request: "true",
                rate: rate2.current.value,
                client: { id: logedClient.id },
                instructor: {
                  id: reservation.fishingClass.instructor.id,
                },
              })
            }
            className="btn btn-success"
          >
            Rate
          </button>
        </div>
      </Card.Body>
      <Card.Body>
        <div className="popup">
          <h6 for="text">
            Make a complaint for: {reservation.fishingClass.instructor.name}{" "}
            {reservation.fishingClass.instructor.surname}
          </h6>
          <input ref={zalba} type="text" className="form-control" />
          <button
            onClick={() => {
              addInstructorComplaintHandler({
                active: "true",
                description: zalba.current.value,
                client: { id: logedClient.id },
                instructor: {
                  id: reservation.fishingClass.instructor.id,
                },
              });
            }}
            className="btn btn-danger"
          >
            Complain
          </button>
        </div>
      </Card.Body>
    </div>
  );
}
