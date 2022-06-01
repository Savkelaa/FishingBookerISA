import React, { useState, useEffect } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function CurrentReservations({
  currentReservations,
  currentQuickReservations,
}) {
  console.log("currentReservations", currentReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  //  const date = new Date("2022-05-19");

  var currReservations = [];
  var quickReservations = [];

  currentReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (today > startDate && today < endDate) {
      console.log("✅ Current date is between the 2 dates of reservation");
      currReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });

  currentQuickReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (today > startDate && today < endDate) {
      console.log("✅ Current date is between the 2 dates of reservation");
      quickReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });

  console.log("currentReservationssssss", currReservations);

  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Current reservations </h1>
        </div>
        {currReservations.map((reservation) => (
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
                          Client: {reservation.client.name}{" "}
                          {reservation.client.surname}
                        </ListGroupItem>
                        <ListGroupItem>
                          Adress of client : {reservation.client.address}{" "}
                          {reservation.client.city} {reservation.client.country}
                        </ListGroupItem>
                      </ListGroup>
                      <Link
                        reservation={reservation}
                        to={`/createReservation/${reservation.fishingClass.id}`}
                      >
                        <Card.Body>
                          <Button
                            onClick={() =>
                              localStorage.setItem(
                                "reservation",
                                JSON.stringify(reservation)
                              )
                            }
                          >
                            Book a new quick reservation for this client
                          </Button>
                        </Card.Body>
                      </Link>
                    </Card>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Current quick reservations </h1>
        </div>
        {currentQuickReservations.map((reservation) => (
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
                          Client: {reservation.client.name}{" "}
                          {reservation.client.surname}
                        </ListGroupItem>
                        <ListGroupItem>
                          Adress of client : {reservation.client.address}{" "}
                          {reservation.client.city} {reservation.client.country}
                        </ListGroupItem>
                      </ListGroup>
                      <Link
                        reservation={reservation}
                        to={`/createReservation/${reservation.fishingClass.id}`}
                      >
                        <Card.Body>
                          <Button
                            onClick={() =>
                              localStorage.setItem(
                                "reservation",
                                JSON.stringify(reservation)
                              )
                            }
                          >
                            Book a new quick reservation for this client
                          </Button>
                        </Card.Body>
                      </Link>
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
