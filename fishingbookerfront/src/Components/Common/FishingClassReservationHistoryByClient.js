import React, { useRef, useState } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import complaintServices from "../../Services/ComplaintServices/ComplaintServices";
import Popup from "./Popup";

export default function FishingClassReservationHistoryByClient({
  reservationHistory,
  addInstructorRateHandler,
  addFishingClassRateHandler,
  addInstructorComplaintHandler,
}) {
  const rate1 = useRef();
  const rate2 = useRef();
  const zalba = useRef();

  console.log("reservationHistory", reservationHistory);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  var hisReservations = [];

  reservationHistory.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (today > endDate) {
      console.log("✅ Reservation is past.");
      hisReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });
  var logedClient = JSON.parse(localStorage.getItem("Client"));
  console.log("logedClient", logedClient);

  console.log("hisReservations", hisReservations);

  //console.log("zalba", zalba.current.value);

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}>
            {" "}
            Fishing Class Reservation History{" "}
          </h1>
        </div>
        {hisReservations.map((reservation) => (
          <div className="container">
            <div className="row gutters">
              <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div className="card h-100">
                  <div className="card-body">
                    <Card className="cardContainer" style={{ width: "30rem" }}>
                      <Card.Img variant="top" />
                      <Card.Body>
                        <Card.Title className="cardTitle">
                          Fishing Class: {reservation.fishingClass.name}
                        </Card.Title>
                        <Card.Text>
                          Description:{" "}
                          {reservation.fishingClass.promoDescription}
                        </Card.Text>
                        <Card.Text>Price: {reservation.price} euro</Card.Text>
                        <Card.Text> Place: {reservation.place}</Card.Text>

                        <Card.Text>
                          Start date: {reservation.startDate}
                        </Card.Text>
                        <Card.Text>
                          End date: {reservation.finishDate}
                        </Card.Text>
                      </Card.Body>
                      <ListGroup className="list-group-flush">
                        <ListGroupItem>
                          <Card.Title className="cardTitle">
                            {reservation.client.name}{" "}
                            {reservation.client.surname}
                          </Card.Title>

                          <Card.Text>
                            {" "}
                            Email: {reservation.client.email}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Explanation of registration:{" "}
                            {reservation.client.explanation}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Address: {reservation.client.address}{" "}
                            {reservation.client.city}{" "}
                            {reservation.client.country}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Number: {reservation.client.number}
                          </Card.Text>
                          <Card.Text>
                            {" "}
                            Penalty: {reservation.client.penalty}
                          </Card.Text>
                        </ListGroupItem>
                      </ListGroup>

                      <Card.Body>
                        <div className="popup">
                          <h6 for="text">Please rate this fishing Class: </h6>
                          <input
                            ref={rate1}
                            type="text"
                            className="form-control"
                            id="start"
                          />
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
                            Make a complaint for:{" "}
                            {reservation.fishingClass.instructor.name}{" "}
                            {reservation.fishingClass.instructor.surname}
                          </h6>
                          <input
                            ref={zalba}
                            type="text"
                            className="form-control"
                          />
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
                    </Card>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
