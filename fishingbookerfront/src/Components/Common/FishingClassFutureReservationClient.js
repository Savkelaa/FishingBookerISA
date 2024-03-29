import React, { useState, useEffect, useRef } from "react";
import {
  Card,
  ListGroup,
  ListGroupItem,
  CardGroup,
  Button,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import Popup from "./Popup";

export default function FishingClassFutureReservationClient({
  futureReservations,
}) {
  console.log("futureReservations", futureReservations);
  const timeElapsed = Date.now();
  const today = new Date(timeElapsed);

  var hisReservations = [];

  futureReservations.forEach((reservation) => {
    const startDate = new Date(reservation.startDate);
    const endDate = new Date(reservation.finishDate);
    if (startDate > today) {
      console.log("✅ Reservation is past.");
      hisReservations.push(reservation);
    } else {
      console.log("⛔️ date is not in the range");
      console.log("reservation.startDate", startDate);
      console.log("reservation.endDate", endDate);
    }
  });

  console.log("hisReservations", hisReservations);
  var category = JSON.parse(localStorage.getItem("Category"));
  console.log("category", category[0]?.name);

  const pomnozi = 1 - category[0]?.discount / 100;

  console.log("pomnozi", pomnozi);
  return (
    <div>
      <div className="App">
        <div className="header">
          <h1 style={{ textAlign: "center" }}> Future reservations </h1>
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
                        <Card.Text>
                          Loyalty Category: {category[0]?.name}, Discount:{" "}
                          {category[0]?.discount} %
                        </Card.Text>
                        <Card.Text>
                          NEW PRICE: {reservation.price * pomnozi} euro
                        </Card.Text>
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
